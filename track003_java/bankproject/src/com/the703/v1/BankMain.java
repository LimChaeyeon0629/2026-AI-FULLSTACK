package com.the703.v1;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {

		String id, pw, tempId, tempPw;
		int age, money, num;

		Scanner sc = new Scanner(System.in);

		id = sc.next();
		pw = sc.next();
		age = sc.nextInt();
		cash = sc.nextInt();

		System.out.println("WELCOME!");
		System.out.println("=");
		System.out.println("1. 추가");
		System.out.println("2. 조회");
		System.out.println("3. 입금");
		System.out.println("4. 출급");
		System.out.println("5. 삭제");
		System.out.println("9. 종료");

		System.out.print("입력>>> ");
		num = sc.nextInt();

		// 1. 추가
		// 2. 조회 ~ 5. 삭제 추가 안 했으면 continue;
		// 배열, 
		
		for(;;) {
			
			if (num == 9) {
				System.out.println("종료");
				break;
			} else if (num == 2 || num == 3 || num == 4 || num == 5) {
				if (id == null) {
					System.out.println("아이디를 먼저 추가해주세요");
					continue;

				}
				System.out.println("아이디 입력: ");
				tempId = sc.next();
				// 아이디 틀렸을 경우 추가
				System.out.println("비밀번호 입력: ");
				tempPw = sc.next();
				// 비밀번호 틀렸을 경우 추가
				System.out.println("나이 입력: ");
				age = sc.nextInt();
				System.out.println("잔액 입력: ");
				money = sc.nextInt();
				
				
			}
			
		}
		
		
	}

}

