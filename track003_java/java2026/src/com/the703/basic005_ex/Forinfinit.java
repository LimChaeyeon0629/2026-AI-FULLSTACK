package com.the703.basic005_ex;

import java.util.Scanner;

public class Forinfinit {

	public static void main(String[] args) {
		// 제어문
		// 조건문: ~라면 if / switch
		// 반복문: 반복 for / while / do while
		// 제어조건: break / continue
		
		// 1. 영역
//		for(;;) { System.out.println("Hello"); }
		
		Scanner sc = new Scanner(System.in);
		
		// 2. 빠져나올조건
		int a = -1;

		for(;;) {
			System.out.println("Hello");
			System.out.println("빠져나오실래요? 0이면 종료: ");
			a = sc.nextInt();
			if (a == 0) { break; }
		}
		
//		int a = -1;			  	// a [ -1 ]
//		for(; 	a != 0	 ;) { 	// a가 0이 아니면
//			System.out.println("Hello");
//			System.out.println("빠져나오실래요? 0이면 종료: ");
//			a = sc.nextInt();
//		}
	}

}
