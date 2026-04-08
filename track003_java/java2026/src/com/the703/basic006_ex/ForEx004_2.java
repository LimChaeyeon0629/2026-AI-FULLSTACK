package com.the703.basic006_ex;

public class ForEx004_2 {

	public static void main(String[] args) {
//		1~10까지 3의 배수 갯수를 출력
		
		// 1 2 3 4 5 ... 10
		// 3의 배수 = 3 6 9
		// 3의 배수 갯수 = 3개
		
		int count = 0;
		
		System.out.print("3의 배수: ");
		
		for(int i = 1; i <= 10; i++) {
			if(i%3 == 0) {
				System.out.print(i + " "); // 3 6 9 출력
				count++; // 3 6 9 → 3번 도니까 3개
			}
			
		}
		System.out.println("\n갯수: " + count + "개");
	}
}