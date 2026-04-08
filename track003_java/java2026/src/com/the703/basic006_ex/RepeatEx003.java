package com.the703.basic006_ex;

public class RepeatEx003 {

	public static void main(String[] args) {
		
		int count1 = 0, count2 = 0, count3 = 0;

		// for
		System.out.println("for");
		
		for (int i = 1; i <= 30; i++) {
			if(i%3 == 0 && i%2 == 0) {
				System.out.println("3의 배수이면서 2의 배수인 숫자: " + i);
				count1++;
			}
		}
		System.out.println("갯수: " + count1 + "개");
		
		
		
		// while
		System.out.println("\nwhile");
		int i = 1;								// 1부터

		while (i <= 30) {						// 30까지
			if(i%3 == 0 && i%2 == 0) {			// 6 12 18 24 30
				System.out.println("3의 배수이면서 2의 배수인 숫자: " + i);
				count2++;						// if문 안에서 갯수+
			}
			i++;								// 조건 끝나면 i++
		}
		System.out.println("갯수: " + count2 + "개");

		
		
		// do while
		System.out.println("\ndo while");
		int j = 1;
		
		do {
			if(j%3 == 0 && j%2 == 0) {
				System.out.println("3의 배수이면서 2의 배수인 숫자: " + j);
				count3++;
			}
			j++;
		} while (j <= 30);
		System.out.println("갯수: " + count3 + "개");

	}

}
