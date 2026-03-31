package com.the703.basic004;

public class Casting002_char {

	public static void main(String[] args) {
		// #1. 문자 - 저장시 숫자 / 출력시 문자
		char ch1 = ' '; // 공백 한 개라도 있어야 오류가 안남
		char ch2 = '\u0000'; //
		
		System.out.println("step1 : " + ch1 + "\t" + ch2);
		System.out.println("step2 : " + (int)ch1 + "\t" + (int)ch2);
		
		// #2. 문자
		char ch3 = 'A';
		System.out.println("step3 : " + ch3 + "\t" + (int)ch3);
		
		System.out.println("step4 : " + ch3 + 1); // A(char)+1(int)=A1
		System.out.println("step4 : " + (ch3 + 1)); // (65(2byte)+1(4byte))=66(int에 담김)
		// 2-1) 'A' + 1 (char 65 + int 1)
		// 2-2) char(65|2byte) + int(4byte) 4byte에 담아져서 정수(int)로 출력

		System.out.println("step : " + (int)ch3 + 1); // 65(char)+1(int)=651
		System.out.println("step : " + (int)(ch3 + 1)); // 65(2byte)+1(4byte)=66(int에 담김)
		System.out.println("step : " + (char)(ch3 + 1)); // ch3=2byte + 1=4byte
		
		// Q1. 대문자 'A' 를 소문자 'a' 로 변환
		char q = 'A';
		char a = (char)(q + 32); // q = 2byte, 32 = 4byte int
		System.out.println('A' + "\t" + 'a');
		System.out.println((int)'A' + "\t" + (int)'a');
		System.out.println(a); // a
		
//		System.out.println((int)q + 32);
		
		char q1 = 'A'; // 입력시 문자 / 출력시 숫자
		System.out.println('A' + 'a'); // 162
		System.out.println((int)'A' + (int)'a'); // 162
		System.out.println((int)'A' + "\t" + (int)'a'); // 65 97
		System.out.println(a1);
	}

}
