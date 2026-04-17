package com.the703.v1;

import java.util.Scanner;

public class BankProjectV5 {

	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		
		// 0 	1	 2
		// one	two	three
		// 1111 2222 3333
		// 1100 2200 3300
		
		int size = 3;
		int [] arr = new int[size];
		int [] menu = new int[9];
		String [] id = new String[size];
		int [] pw = new int[size];
		int [] balance = new int[size];
		int [] money = new int[size];
		String [] tid = new String[size];
		int [] tpw = new int[size];
		String answer; // char again = '\u0000';
		
		// 입력
		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		for(int i=1; i<=9; i++) {
			System.out.println("\n======BANK======");
			System.out.println("[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기"  + "\n[5] 🗑️ 계좌 삭제" + "\n[9] 💀 종료" + "\n👉 번호를 선택하세요: ");
			menu[i] = sc.nextInt(); // 1 ~ 9까지 입력

			
			
			if (menu[i] == 1) { // [1] ➕ 계좌 추가
				for(int j=0; j<arr.length; j++) { // 저장된 주소값 0 1 2 (3번 연속으로 입력받기)
					System.out.print("아이디 입력: ");
					id[j] = sc.next();
					System.out.print("비밀번호 입력: ");
					pw[j] = sc.nextInt();
					System.out.print("잔액 입력: ");
					balance[j] = sc.nextInt();
				}
				
			} else if (menu[i] >= 2 && menu[i] <= 5) { // [2]계좌 조회, [3]입금하기, [4]출금하기, [5]계좌 삭제
				for(int j=0; j<arr.length; j++) { // 저장된 주소값 0 1 2 (3번 반복)
					if (id[j] == null) {
						System.out.println("[1] 계좌 추가 먼저 해주세요");
						break;
					}

					System.out.print("아이디 입력: ");
					tid[j] = sc.next();				
					System.out.print("비밀번호 입력: ");
					tpw[j] = sc.nextInt();				
					
					if (tid[j] != id[j] && tpw[j] != pw[j]) {
						System.out.println("다시 입력해주세요");
						continue; // id 또는 pw가 다르면 continue;
					} 
					
					switch (menu[i]) { // 2~5 메뉴판 선택
					
						case 2:
							System.out.printf("ID: %s\nPW: %d\n잔액: %d\n", id[j], pw[j], balance[j]);
							break;
						case 3:
							System.out.print("입금: ");
							money[j] = sc.nextInt();
							balance[j] += money[j];
							System.out.println("💵 입금완료");
							System.out.println("잔액: " + balance[j]);
							break;
						case 4:
							System.out.print("출금: ");
							money[j] = sc.nextInt();
							System.out.println( money[j] > balance[j] ? "출금불가" : "출금완료! 잔액: " + (balance[j] -= money[j]));
							break;
						case 5:
							System.out.println("계좌를 삭제하시겠습니까? (y/n)");
							answer = sc.next();
							
							if (answer.equals("y")) {
								id[j] = "";
								pw[j] = -1;
								balance[j] = -1;
								System.out.println("🗑️ 계좌 삭제 완료");
								
							} else if (answer.equals("n")) {
								continue;
								
							} else {
								System.out.println("(y/n)을 입력해주세요.");
							}
						}
					}
				
			} else if (menu[i] >= 6 && menu[i] <= 8) { // 6 ~ 8 입력했을 때
				System.out.println("잘못 입력하셨습니다");
				continue;
				
			} else if (menu[i] == 9) { System.out.println("종료합니다"); break; } // [9] 💀 종료
			
		} // 1~9 메뉴판 end
	}
}
