package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		
		// 변수
		char ch = '\u0000'; // ch 초기화
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("문자 하나 입력: ");
		ch = sc.next().charAt(0);
//		ch = sc.next().charAt(ch); // x
		
		// 처리 + 출력
//		if (ch >= 'A' && ch <= 'Z') {
//			System.out.println("대문자");
//		} else if (ch >= 'a' && ch <= 'z') {
//			System.out.println("소문자");
//		} else {
//			System.out.println("잘못 입력");
//		}
		
//		String answer = ch >= 'A' && ch <= 'Z' ? "대문자" :
//						ch >= 'a' && ch <= 'z' ? "소문자" : "잘못 입력";
//		System.out.println(answer);
		
		System.out.println(ch >= 'A' && ch <= 'Z' ? "대문자"
				:		   ch >= 'a' && ch <= 'z' ? "소문자" : "");
	}

}
