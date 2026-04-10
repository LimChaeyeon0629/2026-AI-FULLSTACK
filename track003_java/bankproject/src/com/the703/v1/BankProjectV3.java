package com.the703.v1;

import java.util.Scanner;

public class BankProjectV3 {

	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		int num = -1, id = -1, pw = -1, balance = -1, money = -1, tid = -1, tpw = -1;
		String answer, temp;
		
		// 입력
		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		for(;;) {
			System.out.println("\n======BANK======");
			System.out.println("[1] ➕ 계좌 추가");
			System.out.println("[2] 🔍 계좌 조회");
			System.out.println("[3] 💵 입금하기");
			System.out.println("[4] 💸 출금하기");
			System.out.println("[5] 🗑️ 계좌 삭제");
			System.out.println("[9] 💀 종료\n");
			System.out.print("👉 번호를 선택하세요: ");
			num = sc.nextInt();
			
			// 처리
			if (num == 9) { // [9] 💀 종료
				break;
				
			} else if (num == 1) { // [1] ➕ 계좌 추가
				System.out.print("아이디 입력: ");
				id = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				pw = sc.nextInt();
				System.out.print("잔액 입력: ");
				balance = sc.nextInt();
				
			} else if (num == 2) { // [2] 🔍 계좌 조회
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				/*
				 1. 계좌 추가
				 2. [2~5]
				 	2-1) 사용자 맞는지 여부
				 	2-2) 조회면 조회기능, 입금이면 입력입금, 출금이면 입력출금, 삭제면 입력삭제
				 3. 종료
				 
				 ver-1
				 조건문: if, switch
				 반복문: for(시작; 종료; 변화), while(조건), do while(한 번은 무조건 실행 후 나중에 조건)
				 */
			
				
//				temp = tid != id || tpw != pw ? "다시 입력해주세요"
//						: tid == id && tpw == pw ? "🔍 계좌 조회" 
//								: "";
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					continue;
				} else if (tid == id && tpw == pw) {
					System.out.println("🔍 계좌 조회");
					System.out.println("아이디: " + id);
					System.out.println("비밀번호: " + pw);
					System.out.println("잔액: " + balance);
				}
				
			} else if (num == 3) { // [3] 💵 입금하기
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				temp = tid != id || tpw != pw ? "다시 입력해주세요"
						 : tid == id && tpw == pw ? "\n 입금: " + (money = sc.nextInt()) + (balance += money) + "\n💵 입금완료" + "\n잔액: " + balance
						 : "";
				
			} else if (num == 4) { // [4] 💸 출금하기
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				temp = tid != id || tpw != pw ? "다시 입력해주세요"
						 : tid == id && tpw == pw ? "\n출금: " + (money = sc.nextInt()) + (balance -= money) + "\n💵 출금완료" + "\n잔액: " + balance
						 : "";
				
			} else if (num == 5) { // [5] 🗑️ 계좌 삭제
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				
				if (tid != id || tpw != pw) {
					System.out.println("다시 입력해주세요");
					//continue;
				} else if (tid == id && tpw == pw) {
					/////////////////////////////////////////////////	
					System.out.println("계좌를 삭제하시겠습니까? (y/n)");
					answer = sc.next();
					
					if (answer.equals("y")) {
						id = -1;
						pw = -1;
						balance = -1;
						System.out.println("🗑️ 계좌 삭제 완료");
					} else if (answer.equals("n")) {
						continue;
					} else {
						System.out.println("(y/n)을 입력해주세요.");
					}
				}
				
			} else {
				System.out.println("1 ~ 5 숫자를 입력해주세요. (9. 종료)");
				continue;
			}
		}

		
//				BankTemp tempId = new BankTemp();
//				tempId.Id(); // BankTemp class에서 입력받은 tempId 호출
//				
//				BankTemp tempPw = new BankTemp();
//				tempId.Pw(); // BankTemp class에서 입력받은 tempPw 호출
		

//	public static void tempIdpw(int id, int pw) {
//		Scanner sc = new Scanner(System.in);
//		int tid = -1, tpw = -1;
//		
//		System.out.print("아이디 입력: ");
//		tid = sc.nextInt();
//		System.out.print("비밀번호 입력: ");
//		tpw = sc.nextInt();
//		
//		if (tid != id || tpw != pw) {
//			System.out.println("다시 입력해주세요");
//		} else {
//			
//		}
//	}

	}
}

//2~5메뉴사이에 겹치는 부분 줄이기- 도전~!
