package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
		
//		ABCDE
//		FGHIJ
//		KLMNO
//		PQRST
//		UVWXY
//		Z
		
		
		
		// for
		System.out.println("for");

		for(char i = 'A'; i <= 'Z'; i++) {
			if(i%5 == 0) {					// 5라면 줄 바꿈
				System.out.println();
			}									
			System.out.print(i);			// 'A' ~ 'Z'
		}
		
		
		
		// while
		System.out.println("\nwhile");
		char i = 'A';						// 'A' 부터
		String i1;
		
//		while (i <= 'Z') {					// 'Z' 까지
//			if(i%5 == 0) {					// 만약 5라면 줄 바꿈
//				System.out.println();
//			}
//			System.out.print(i);			// '문자' 출력
//			i++;							// 출력하고 ++
//		}
		
		while (i <= 'Z') {
			i1 = i%5 == 0? "\n" : "";
			System.out.print(i1);
			System.out.print(i);
			i++;
		}

		
		
		// do while
		System.out.println("\ndo while");
		char j = 'A';
		String j1;
		
//		do {
//			if(j%5 == 0) {
//				System.out.println();
//			}
//			System.out.print(j);
//			j++;
//		} while (j <= 'Z');

		do {
			j1 = j%5 == 0 ? "\n" : "";
			System.out.print(j1);
			System.out.print(j);
			j++;
		} while (j <= 'Z');
	}

}
