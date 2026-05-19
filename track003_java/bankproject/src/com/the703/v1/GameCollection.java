package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적 (기본생성자, 필드생성자, toString, getters/setters, hashCode/equals)
class PlayerDto {
	// 멤버 변수
	private String name;	//id
	private String job;		//pass
	private int hp;
	private int gold;	//balance
	private int level;
	private int exp; //name job hp gold level exp
	
	public PlayerDto() { super(); }
	public PlayerDto(String name, String job, int hp, int gold, int level, int exp) { super(); this.name = name; this.job = job; this.hp = hp; this.gold = gold; this.level = level; this.exp = exp; }
	@Override public String toString() { return "GameDto [name=" + name + ", job=" + job + ", hp=" + hp + ", gold=" + gold + ", level=" + level + ", exp=" + exp + "]"; }
	
	@Override public int hashCode() { return Objects.hash(exp, gold, hp, job, level, name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		PlayerDto other = (PlayerDto) obj;
		return exp == other.exp && Double.doubleToLongBits(gold) == Double.doubleToLongBits(other.gold)
				&& hp == other.hp && Objects.equals(job, other.job) && level == other.level
				&& Objects.equals(name, other.name);
	}
	
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public String getJob() { return job; } public void setJob(String job) { this.job = job; }
	public int getHp() { return hp; } public void setHp(int hp) { this.hp = hp; }
	public int getGold() { return gold; } public void setGold(int gold) { this.gold = gold; }
	public int getLevel() { return level; } public void setLevel(int level) { this.level = level; }
	public int getExp() { return exp; } public void setExp(int exp) { this.exp = exp; }
}




// 게임 컨트롤러
class Game {
	Scanner sc = new Scanner(System.in);
	
	// 객체를 생성하는게 아니라 플레이어 정보만 받을 목적
	List<PlayerDto> users;

	public Game() { super(); }
	public Game(List<PlayerDto> users) { super(); this.users = users; }

	// 메뉴 - 안에 내용작성
	public void menu() {
		int menu = -1;
//		String name = "", job = "";
//		int gold = -1;

		System.out.println("🌟🗡️ RPG GAME START 🗡️🌟");
		for (;;) { 
			System.out.print("\n======RPG GAME======\n"
					+ "[1] ➕ 캐릭터 추가\n"
					+ "[2] 🔍 캐릭터 상태 조회\n"
					+ "[3] 💵 입금하기\n" //
					+ "[4] 💸 회복하기\n"
					+ "[5] 🗑️ 계좌 삭제\n"
					+ "[9] 💀 종료\n"
					+ "👉 번호를 선택하세요: ");
			menu = sc.nextInt();
			
			if (menu == 9) {
				exit();
				break;

			} else if (menu == 1) {
				add();

			} else if (menu >= 2 && menu <= 5) {
				if (users.size() == 0) {
					System.out.println("아직 생성된 캐릭터가 없습니다. \n캐릭터 추가 먼저 해주세요.");
					continue;
				}
				
				/////////////////////////////////////////
				PlayerDto find = login(); // 로그인확인
				if(find==null) {
					System.out.println("정보를 확인해주세요.");
					continue;
				}
				
				switch (menu) { // 각각의 메뉴에 맞는 기능호출
					case 2: show(find); break;
					case 3: heal(find); break;
					case 4: withdraw(find); break;
					case 5: delete(find); break;
					case 9: exit(); break;
				}

			} else {
				System.out.println("메뉴판 숫자 1~5, 9 중에 입력해주세요"); continue;
			}
		}
	}

	
	
	// 캐릭터 추가 (add)
	void add() {
		System.out.println("캐릭터명 입력: ");
		String tempName = sc.next();
		for( PlayerDto u : users ) { // ※ 아이디 중복 검사 추가
			// PlayerDto에있는name = 입력받은tempName
			if( u.getName().equals(tempName)) {
				System.out.println("이미 존재하는 닉네임입니다.");
				return;
			}
		}
		
		System.out.println("직업 입력 (전사/마법사/궁수): ");
		String tempJob = sc.next();
		System.out.println("소지 골드 입력: ");
		int tempGold = sc.nextInt();

		// 처리, list=기차 ( add, get, size, remove, contains )
		// 							name, 	job,	 hp, gold, level, exp
		users.add( new PlayerDto(tempName, tempJob, 100, tempGold, 1, 0) );

		// 출력
		System.out.println("캐릭터명: " + tempName + "\n직업: " + tempJob + "\n캐릭터 생성 완료!");
	}
	
	// 유저로그인 - 유저정보 - PlayerDto login(){}
	PlayerDto login() {
		System.out.print("캐릭터명 입력: ");
		String tid = sc.next();
		
		for( PlayerDto u : users ) { //처리
			//	users Id	=	사용자입력 id
			if( u.getName().equals(tid) ) {
				return u;
			}
		}
		return null;
	}

	// 상태 조회 (contains) - void show( PlayerDto users ){}
	void show(PlayerDto users) {					// GameDto에 getName() 꺼내오기
	   System.out.printf("\\n======상태창======\\n" 	//name job hp gold level exp
	   		+ "캐릭터명: %s" + "\n직업: %s" + "\nHP: %s" + "\n소지 골드: %s" + "\n레벨: %s" + "\n경험치: %s\n",
	   		users.getName(), users.getJob(), users.getHp(), users.getGold(), users.getLevel(), users.getExp() );
	}

	// 회복 (get) - void heal( PlayerDto users ){}
	void heal(PlayerDto users) {
		int healCost = 50;
		
		System.out.print("현재 소지 골드: " + users.getGold()
				+ "\n골드를 사용해서 회복합니다..." );
		int tempMoney = sc.nextInt();
        
        if( users.getGold() < tempMoney || tempMoney <= 0 ) {
			System.out.println("소지 골드가 적습니다.");
			return;
		}
        users.setGold( users.getGold() + tempMoney );	//처리
        
        System.out.println("💵 입금완료");
        System.out.println("잔액: " + users.getGold() );	//출력
   }

	// 출금 (get) - void withdraw( BankDto users ){}
	void withdraw(PlayerDto users) {
		System.out.print("출금: ");
		int tempMoney = sc.nextInt();
		
		if( users.getGold() < tempMoney || tempMoney <= 0 ) {
			System.out.println("제대로 된 금액을 입력해주세요.");
			return;
		}
		users.setGold( users.getGold() - tempMoney );	//처리
		
		System.out.println("💵 완료");
		System.out.println("잔액: " + users.getGold() );
	}

	// 유저삭제 (remove) - void delete( BankDto users ){}
	void delete(PlayerDto users) {
		System.out.println("계좌를 삭제하시겠습니까? (y/n)");
		String answer = sc.next();

		if (answer.equals("y")) {
//			users.setId(""); //			users.setPass(""); //			users.setBalance(0);
			this.users.remove(users);
			System.out.println("🗑️ 계좌 삭제 완료");
			return;

		} else if (answer.equals("n")) {
			System.out.println("🗑️ 계좌 삭제 취소");
			return;

		} else {
			System.out.println("(y/n)을 입력해주세요.");
		}
	}

	// 종료
	void exit() {
		System.out.println("프로그램을 종료합니다.");
		return;
	}
}

public class GameCollection {
	public static void main(String[] args) {
		List<PlayerDto> users = new ArrayList<>();
		Game controller = new Game(users);
		controller.menu();

		// 테스트용
		// controller.add();
		// System.out.println(controller.users);
	}
}