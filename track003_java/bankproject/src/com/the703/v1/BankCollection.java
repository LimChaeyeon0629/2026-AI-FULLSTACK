package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적 (기본생성자, 필드생성자, toString, getters/setters, hashCode/equals)
class BankDto {
	// 멤버 변수
	private String id;
	private String pass;
	private double balance;

	public BankDto() { super(); }
	public BankDto(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance; }
	@Override public String toString() { return "BankDto [id=" + id + ", pass=" + pass + ", balance=" + balance + "]"; }

	@Override public int hashCode() { return Objects.hash(balance, id, pass); }
	@Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; BankDto other = (BankDto) obj; return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && Objects.equals(id, other.id) && Objects.equals(pass, other.pass); }

	public String getId() { return id; } public void setId(String id) { this.id = id; }
	public String getPass() { return pass; } public void setPass(String pass) { this.pass = pass; }
	public double getBalance() { return balance; } public void setBalance(double balance) { this.balance = balance; }
}

class Bank {
	Scanner sc = new Scanner(System.in);
	List<BankDto> users; // 객체를 생성하는게 아니라 정보만 받을 목적

	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }

	// 메뉴 - 안에 내용작성
	public void menu() {
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		String id = "", pass = "";
		double balance = -1;

		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		for (;;) { // while (menu!=9) { //for( ;menu!=9; ) {
//			System.out.println("확인용: " + id + "\t" + pass + "\t" + balance); // 계좌의 1명분 확인용
			System.out.print("\n======BANK======\n" + "[1] ➕ 계좌 추가\n" + "[2] 🔍 계좌 조회\n" + "[3] 💵 입금하기\n"
					+ "[4] 💸 출금하기\n" + "[5] 🗑️ 계좌 삭제\n" + "[9] 💀 종료\n" + "👉 번호를 선택하세요: ");
			menu = sc.nextInt();
			
			if (menu == 9) {
				exit(); break;

			} else if (menu == 1) {
				add();

			} else if (menu >= 2 && menu <= 5) {
				if (users.size() == 0) {
					System.out.println("아직 등록된 유저가 없습니다. \n계좌 추가 먼저 해주세요.");
					continue;
				}
				
				BankDto find = login(); // 로그인확인
				if(find==null) {
					System.out.println("정보를 확인해주세요.");
					continue;
				}
				
				switch (menu) { // 각각의 메뉴에 맞는 기능호출
					case 2: show(find); break;
					case 3: deposit(find); break;
					case 4: withdraw(find); break;
					case 5: delete(find); break;
					case 9: exit(); break;
				}

			} else {
				System.out.println("메뉴판 숫자 1~5, 9 중에 입력해주세요"); continue;
			}
		}
	}

	
	
	// 유저추가 (add)
	void add() {
		// 입력 - 사용자에게 정보입력받기
		System.out.println("아이디 입력: ");
		String tempId = sc.next(); // ※ 아이디 중복 검사 추가
		System.out.println("비밀번호 입력: ");
		String tempPw = sc.next();
		System.out.println("잔액 입력: ");
		Double tempBalance = sc.nextDouble();

		// 처리, list=기차 ( add, get, size, remove, contains )
		users.add( new BankDto(tempId, tempPw, tempBalance) );

		// 출력
		System.out.println("아이디: " + tempId + "\n비밀번호: " + tempPw + "\n추가 완료!");
	}
	
	// 유저로그인 - 유저정보 - BankDto login(){}
	BankDto login() {
//		return null;
		
		//입력
		System.out.print("아이디 입력: ");
		String tid = sc.next();
		System.out.print("비밀번호 입력: ");
		String tpw = sc.next();
		
		//처리
		for( BankDto u : users ) {
			//	users Id	=	사용자입력 id
			if(( u.getId().equals(tid) ) && ( u.getPass().equals(tpw)) ) {
				return u;
			}
		}
		return null;
	}

	// 조회 (contains) - void show( BankDto users ){}
	void show(BankDto users) {					// BankDto에 getId() 꺼내오기
	   System.out.printf("ID: %s\nPW: %s\n잔액: %s\n", users.getId(), users.getPass(), users.getBalance()  );
	}

	// 입금 (get) - void deposit( BankDto users ){}
	void deposit(BankDto users) {
		System.out.print("입금: ");
        double tempMoney = sc.nextDouble();		//입력
        
        users.setBalance( users.getBalance() + tempMoney );	//처리
        
        System.out.println("💵 입금완료");
        System.out.println("잔액: " + users.getBalance() );	//출력
   }

	// 출금 (get) - void withdraw( BankDto users ){}
	void withdraw(BankDto users) {
		System.out.print("출금: ");
		double tempMoney = sc.nextDouble();
		
		if( users.getBalance() < tempMoney || tempMoney <= 0 ) {
			System.out.println("제대로 된 금액을 입력해주세요.");
			return;
		}
		users.setBalance( users.getBalance() - tempMoney );	//처리
		
		System.out.println("💵 출금완료");
		System.out.println("잔액: " + users.getBalance() );
	}

	// 유저삭제 (remove) - void delete( BankDto users ){}
	void delete(BankDto users) {
		System.out.println("계좌를 삭제하시겠습니까? (y/n)");
		String answer = sc.next();

		if (answer.equals("y")) {
//			users.setId("");
//			users.setPass("");
//			users.setBalance(0);
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

public class BankCollection {
	public static void main(String[] args) {
		List<BankDto> users = new ArrayList<>();
		Bank controller = new Bank(users);
		controller.menu();

		// 테스트용
		// controller.add();
		// System.out.println(controller.users);
	}
}