package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {
//		문자한개를 입력받아 
//		   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
//		   ※  a = 'A' + 32  
		
		// 변수
		Scanner sc = new Scanner(System.in);
		char ch = '\u0000', answer = '\u0000';
		
		// 입력
		System.out.print("문자 한 개 입력: ");
		ch = sc.next().charAt(0);
		
		// 처리
//		answer = (char)(ch + 32); // 대문자 → 소문자
//		answer = (char)(ch - 32); // 소문자 → 대문자
		
		if (ch >= 'A' && ch <= 'Z') {
			System.out.println(answer = (char)(ch + 32));
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println(answer = (char)(ch - 32));
		}
		
		// 출력
		System.out.println(ch + "를 변환 " + answer);
		
//		System.out.println(ch >= 'A' && ch <= 'Z' ? ch+=32
//				:			ch >= 'a' && ch <= 'z' ? ch-=32 : "");
	}

}
