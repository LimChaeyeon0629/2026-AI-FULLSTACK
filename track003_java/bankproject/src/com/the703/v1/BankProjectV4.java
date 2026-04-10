package com.the703.v1;

import java.util.Scanner;

public class BankProjectV4 {

	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		int menu = -1, id = -1, pw = -1, balance = -1, money = -1, tid = -1, tpw = -1;
		String answer; // char again = '\u0000';
		
		/*
			1. 계좌 추가
			2. [2~5]
				2-1) 사용자 맞는지 여부
				임시 아이디 입력받기 임시 비번 입력받기
				저장되어 있는 아이디와 임시 아이디가 같고 저장되어 있는 비번과 임시 비번이 같으면 아래 내용 처리
				2-2) 조회면 조회기능, 입금이면 입력입금, 출금이면 입력출금, 삭제면 y/n 입력삭제
				switch (menu) {
					case 2: 조회처리 break;
					case 3: 입금받기 / 잔액추가 break;
					case 4: 출금받기 / 잔액빼기 break; (마이너스 통장 안 되게)
					case 5: 계좌삭제 / y/n 입력받고 삭제 break;
					}
			3. 종료
			
			ver-1
			조건문: if, switch
			반복문: for(시작; 종료; 변화), while(조건), do while(한 번은 무조건 실행 후 나중에 조건)
		*/
		
		
		// 입력
		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		while(menu != 9) {
			System.out.println("\n======BANK======");
			System.out.println("[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" +
					"\n[4] 💸 출금하기" + "\n[5] 🗑️ 계좌 삭제" + "\n[9] 💀 종료" + "\n👉 번호를 선택하세요: ");
			menu = sc.nextInt();

			
//			if (menu == 9) { // [9] 💀 종료
//				break;
				
			} if (menu == 1) { // [1] ➕ 계좌 추가
				System.out.print("아이디 입력: ");
				id = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				pw = sc.nextInt();
				System.out.print("잔액 입력: ");
				balance = sc.nextInt();
				
			} else if ( menu >= 2 && menu <= 5 ){ // [2] 🔍 계좌 조회, [3] 💵 입금하기, [4] 💸 출금하기, [5] 🗑️ 계좌 삭제
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					continue; // id 또는 pw가 다르면 continue;
				} 
				
				switch (menu) {
					case 2:
//						System.out.println("🔍 계좌 조회" + "\n아이디: " + id + "\n비밀번호: " + pw + "\n잔액: " + balance);
						System.out.printf("ID: %d\nPW: %d\nBANLANCE: %d\n", id, pw, balance);
						break;
						
					case 3:
						System.out.print("입금: ");
						money = sc.nextInt();
						balance += money;
						System.out.println("💵 입금완료");
						System.out.println("잔액: " + balance);
						break;
						
					case 4:
						System.out.print("출금: ");
						money = sc.nextInt();
						System.out.println( money > balance ? "출금불가" : "출금완료! 잔액: " + (balance -= money));
//						if (balance < money) {
//							System.out.println("출금 불가!");
//							continue;
//						} else {
//							balance -= money;
//							System.out.println("💵 출금완료");
//							System.out.println("잔액: " + balance);
							break;
//						}
						
					case 5:
						System.out.println("계좌를 삭제하시겠습니까? (y/n)");
						answer = sc.next(); // again = sc.next().charAt(0);
											// if (again == 'Y' || again == 'y')
											// { id = -1, pw = -1, balance = -1 };
						
//						if (answer.equals("y")) {
//							id = -1;
//							pw = -1;
//							balance = -1;
//							System.out.println("🗑️ 계좌 삭제 완료");
//						} else if (answer.equals("n")) {
//							continue;
//						} else {
//							System.out.println("(y/n)을 입력해주세요.");
//						}
						
						switch(answer) {
							case "y":
								id = -1;
								pw = -1;
								balance = -1;
								System.out.println("🗑️ 계좌 삭제 완료");
								
							case "n":
								continue;
								
							default:
								System.out.println("(y/n)을 입력해주세요.");
						}
						break;
					}
			}
				
				
				
		}
	}
}
