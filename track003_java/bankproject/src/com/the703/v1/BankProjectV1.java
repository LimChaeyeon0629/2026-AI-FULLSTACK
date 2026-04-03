package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1 {

	public static void main(String[] args) {
		
//		Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
//	      1을 입력하면 추가기능입니다. 출력구문까지만
//	      2를 입력하면 조회기능입니다. 출력구문까지만
//	      3을 입력하면 입금기능입니다. 출력구문까지만
//	      4를 입력하면 출금기능입니다. 출력구문까지만
//	      5를 입력하면 삭제기능입니다. 출력구문까지만
//	      9를 입력하면 종료합니다.    출력구문까지만
//
//		Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
//	  	 ■ 힌트
//	  	 for(;;) { 
//	      System.out.println("숫자1을 입력하세요.");
//	      int a = scanner.nextInt();
//	      if(a == 1) { break;}
		
		
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int num = -1, id = -1, pw = -1, balance = -1;
		
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
			if (num == 9) {
				break;
			} else if (num == 1) {
				System.out.print("아이디 입력: ");
				id = sc.nextInt();
				System.out.print("비밀번호 입력: ");
				pw = sc.nextInt();
				System.out.print("잔액 입력: ");
				balance = sc.nextInt();
			} else if (num == 2) {
				int tid = -1, tpw = -1;
				
				System.out.print("아이디 입력: ");
				tid = sc.nextInt();
				if (tid != id) {
					System.out.println("다시 입력해주세요");
					continue;
				}
				
				System.out.print("비밀번호 입력: ");
				tpw = sc.nextInt();
				if (tpw != pw) {
					System.out.println("다시 입력해주세요");
					continue;
				}
				
				if (tid == id && tpw == pw) {
					System.out.println("🔍 계좌 조회");
					System.out.println("아이디: " + id);
					System.out.println("비밀번호: " + pw);
					System.out.println("잔액: " + balance);
				}
			} else if (num == 3) {
				System.out.println("3. 입금");
				// id, pw 	입력받기
				// id || pw 틀리면 재입력
				// id && pw 맞으면 money 입금
			} else if (num == 4) {
				System.out.println("4. 출금");
				// id, pw 	입력받기
				// id || pw 틀리면 재입력
				// id && pw 맞으면 money 출금
			} else if (num == 5) {
				System.out.println("5. 삭제");
				// id, pw 	입력받기
				// id || pw 틀리면 재입력
				// id && pw 맞으면 계좌 삭제
			} else {
				System.out.println("1 ~ 5 숫자를 입력해주세요. (9. 종료)");
				continue;
			}
		}
		
	}

}
