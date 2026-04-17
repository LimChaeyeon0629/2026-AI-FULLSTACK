package com.the703.v1;

import java.util.Arrays;
import java.util.Scanner;

public class BankProjectV7 {
	
	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		String [] id = new String[3]; 		// one	two	three
		String [] pass = new String[3]; 	// 1111 2222 3333
		double [] balance = new double[3];  // 1100 2200 3300
		int menu = -1;
		int money = -1;
		String answer;
		
		// 입력
		System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
		
		while(menu != 9) { // 메뉴판 start
			System.out.println(Arrays.toString(id));
			System.out.println(Arrays.toString(pass));
			System.out.println(Arrays.toString(balance));
			
			int find = -1; // 1. 빈칸 찾기
//			if (balance[0] = 0이라면 ){ 빈칸 }
//			if (balance[0] == 0 ){ find = 0; }
//			if (balance[1] == 0 ){ find = 1; }
//			if (balance[2] == 0 ){ find = 2; }
			for(int i=0; i<id.length; i++) { // 0 1 2
				if(balance[i] == 0) { find = i; }
			
				System.out.println("\n======BANK======");
				System.out.println("[1] ➕ 계좌 추가" + "\n[2] 🔍 계좌 조회" + "\n[3] 💵 입금하기" + "\n[4] 💸 출금하기"  + "\n[5] 🗑️ 계좌 삭제" + "\n[9] 💀 종료" + "\n👉 번호를 선택하세요: ");
				menu = sc.nextInt(); // 1 ~ 9까지 입력
	
				if (menu == 9) { System.out.println("종료합니다"); break;  // 9 종료
				
				} else if (menu == 1) { // 1
					if (find == -1) { System.out.println("가입 불가!"); continue; } // find = -1이면 아래 사용자값 입력받게 하면 안됨
					// 2. 빈칸에 입력받기
					System.out.print("아이디 입력: "); id[find] = sc.next();
					System.out.print("비밀번호 입력: "); pass[find] = sc.next();
					System.out.print("잔액 입력: "); balance[find] = sc.nextInt();
					
				} else if (menu >= 2 && menu <= 5) { // 2~5
					String tid = "", tpw = "";
					System.out.print("아이디 입력: "); tid = sc.next();
					System.out.print("비밀번호 입력: "); tpw = sc.next();
					
					System.out.println(tid);
					// tid가 id랑 같지 않음 || tpw가 pass랑 같지 않음
					if (!tid.equals(id[find]) || !tpw.equals(pass[find]))
					{ System.out.println(tid); System.out.println(tpw);
					System.out.println(id[find]); System.out.println(pass[find]); // null
					System.out.println("잘못 입력하셨습니다"); break; }
					
					
					switch (menu) {
					case 2:
						System.out.printf("ID: %s\nPW: %s\n잔액: %d\n", id[find], pass[find], balance[find]);
						break;
					case 3:
						System.out.print("입금: ");
						money = sc.nextInt();
						balance[find+1] += money;
						System.out.println("💵 입금완료");
						System.out.println("잔액: " + balance[find]);
						break;
					case 4:
						System.out.print("출금: ");
						money = sc.nextInt();
						System.out.println( money > balance[find] ? "출금불가" : "출금완료! 잔액: " + (balance[find] -= money));
						break;
					case 5:
						System.out.println("계좌를 삭제하시겠습니까? (y/n)");
						answer = sc.next();
						
						if (answer.equals("y")) {
							id[find] = "";
							pass[find] = "";
							balance[find] = -1;
							System.out.println("🗑️ 계좌 삭제 완료");
							break;
							
						} else if (answer.equals("n")) {
							continue;
							
						} else { System.out.println("(y/n)을 입력해주세요.");}
					} // switch end
						
						
				} else { System.out.println("메뉴판 숫자 1~5를 입력해주세요"); break; }
			}
		} // 메뉴판 end
	}
}

		//if (tid.equals(id[find]) && tpw.equals(pass[find])) {
		//	System.out.println("아이디랑 비밀번호가 틀렸습니다");
		//	continue;
		//}