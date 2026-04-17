package com.the703.v1;

import java.util.Scanner;

public class BankProjectV6 {
	
	

	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		
		// 0 	1	 2
		// one	two	three
		// 1111 2222 3333
		// 1100 2200 3300
		
		int size = 3;
		int [][] arr = new int[size][size];
		int [] menu = new int[9];
		String [][] id = new String[size][size];
		int [][] pw = new int[size][size];
		int [][] balance = new int[size][size];
		int [][] money = new int[size][size];
		String [][] tid = new String[size][size];
		int [][] tpw = new int[size][size];
		String answer; // char again = '\u0000';
		
		// 입력
		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		for(int i=1; i<=9; i++) {
			System.out.println("\n======BANK======");
			System.out.println("[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기"  + "\n[5] 🗑️ 계좌 삭제" + "\n[9] 💀 종료" + "\n👉 번호를 선택하세요: ");
			menu[i] = sc.nextInt(); // 1 ~ 9까지 입력

			
			if (menu[i] == 1) { // [1] ➕ 계좌 추가
				outloop:
				for(int k=0; k<arr.length; k++) {
					for(int j=0; j<arr.length; j++) { // 저장된 주소값 0 1 2
						System.out.print("아이디 입력: ");
						id[k][j] = sc.next();
						System.out.print("비밀번호 입력: ");
						pw[k][j] = sc.nextInt();
						System.out.print("잔액 입력: ");
						balance[k][j] = sc.nextInt();
						break outloop;
					}
				}
				
			} else if (menu[i] >= 2 && menu[i] <= 5) { // [2]계좌 조회, [3]입금하기, [4]출금하기, [5]계좌 삭제
				outloop:
				for(int k=0; k<arr.length; k++) { // 층
					for(int j=0; j<arr[k].length; j++) { // 칸
//						if (tid[k][j] == null) {
//							System.out.println("계좌 추가 먼저 해주세요");
//							break;
//						}
						
						// id & pw
						System.out.print("아이디 입력: ");
						tid[k][j] = sc.next();	
						System.out.print("비밀번호 입력: ");
						tpw[k][j] = sc.nextInt();			
						
						if(tid[k][j] != id[k][j] && tpw[k][j] != pw[k][j]) {
							System.out.println("아이디랑 비번이 틀렸습니다");
							break outloop;
						}
						
						switch (menu[i]) { // 2~5 메뉴판 선택
						
						case 2:
							System.out.printf("ID: %s\nPW: %d\n잔액: %d\n", id[k][j], pw[k][j], balance[k][j]);
							break outloop;
						case 3:
							System.out.print("입금: ");
							money[k][j] = sc.nextInt();
							balance[k][j] += money[k][j];
							System.out.println("💵 입금완료");
							System.out.println("잔액: " + balance[k][j]);
							break outloop;
						case 4:
							System.out.print("출금: ");
							money[k][j] = sc.nextInt();
							System.out.println( money[k][j] > balance[k][j] ? "출금불가" : "출금완료! 잔액: " + (balance[k][j] -= money[k][j]));
							break outloop;
						case 5:
							System.out.println("계좌를 삭제하시겠습니까? (y/n)");
							answer = sc.next();
							
							if (answer.equals("y")) {
								id[k][j] = "";
								pw[k][j] = -1;
								balance[k][j] = -1;
								System.out.println("🗑️ 계좌 삭제 완료");
								break outloop;
								
							} else if (answer.equals("n")) {
								continue;
								
							} else {
								System.out.println("(y/n)을 입력해주세요.");
							}
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
