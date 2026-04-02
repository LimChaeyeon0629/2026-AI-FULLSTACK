package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEX001 {

	public static void main(String[] args) {
		
		// 변수
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("평균 입력: ");
		int avg = sc.nextInt();
		
		// 처리 + 출력
//		if (avg >= 60 ) {
//			System.out.println("합격");
//		} else {
//			System.out.println("불합격");
//		}
		
		// 삼항연산자 → 조건 ? 참 : 거짓
		String answer = avg >= 60 ? "합격" : "불합격";
		System.out.println(answer);
		
		System.out.println(avg >= 60 ? "합격" : "불합격");
	}

}
