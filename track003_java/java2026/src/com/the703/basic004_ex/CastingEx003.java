package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx003 {

	public static void main(String[] args) {
		// 1. 문자는 저장 시 숫자로 저장이 되고, 출력 시 문자
		System.out.println("1. " + 'A' + "\t" + (int)'A'); // 'A' 문자
		System.out.println("2. " + 'a' + "\t" + (int)'a'); // "ABC" 문자열
		System.out.println("3. " + "ABC".charAt(0)); // "A" 문자열
		System.out.println("3. " + "ABC".charAt(1)); // "B" 문자열
		System.out.println("3. " + "ABC".charAt(2)); // "C" 문자열
		
		// - 대문자입력받아서 소문자로 변경프로그램을 작성하시오.
		// 변수
		Scanner sc = new Scanner(System.in);
		char ch = '\u0000', lower = '\u0000'; // 초기화
		
		// 입력
		System.out.print("대문자 입력: ");
		ch = sc.next().charAt(0); // 문자열 입력.charAt(0);
		
		// 처리
		lower = (char)(ch + 32);
		// a(95) = A(65) + 32
		// char = char + int
		// 2byte = 2byte + 4byte
		// 2byte = (char)(2byte + 4byte) 강제형변환
		
		// 출력
		System.out.println(ch + "를 소문자로 " + lower);
		
	}

}
