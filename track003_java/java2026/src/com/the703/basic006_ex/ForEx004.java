package com.the703.basic006_ex;

public class ForEx004 {

	public static void main(String[] args) {
//		1~10까지 3의 배수 갯수를 출력
		
		// 1번
		// 만약 1이 3의 배수라면 갯수 카운트
		
		// 2번
		// if (1이 3의 배수라면)  { 갯수 카운트 }
		
		// 3번
		// if (1%3 == 0)  { count++; }
		// if (2%3 == 0)  { count++; }
		// if (3%3 == 0)  { count++; }

		// { if (i%3 == 0)  { count++; } }

		int count = 0;
		
		for (int i = 1; i <= 10; i++) { // 1 2 3 4 5 ... 9 10
			if (i%3 == 0) { // 3 6 9
				count++;
			}
		}
		
		System.out.println("갯수: " + count); // 3
		
	}
}

/*
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
 */