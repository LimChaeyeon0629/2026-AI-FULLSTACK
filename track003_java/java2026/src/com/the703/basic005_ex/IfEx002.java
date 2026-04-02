package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int num;
		
		// 입력
		System.out.print("숫자 입력: ");
		num = sc.nextInt();
		
		// 처리 + 출력
//		if (num > 0) {
//			System.out.println("양수");
//		} else if (num < 0) {
//			System.out.println("음수");
//		} else {
//			System.out.println("zero");
//		}
		
		// ■4. 삼항연산자 		조건 ? 	참	: 거짓
		String answer = num > 0 ? "양수" : num < 0 ? "음수" : "zero" ;
		System.out.println(answer);
		
		
	}

}
