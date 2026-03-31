package com.the703.basic004;

public class Casting001 {

	public static void main(String[] args) {
		// 1. 자바 자료형 / 기본형 & 참조형
		// 2. 기본형 	- 논리형 boolean - true/false
		//			- 정수형 byte(1) short(2) ★int(4) long(8, L)
		// 			- 실수형 float(4, F) ★double(8)
		
		
		
		// 3. #1. 형변환 - 자동타입변환 (boolean 빼고)
		byte by = 1; 	short sh = 2;	 int in = 4;	 long lo = 8;
		
		float fl = 3.14f; 	double dou = 3.14;
		boolean bl = true;
		
		sh = by; // 정수형 2byte - 정수형 1byte
		in = by; // 정수형 4byte - 정수형 1byte
		lo = by; // 정수형 8byte - 정수형 1byte
		// lo = fl; // 정수형 8byte - 실수형 4byte ( 정수 < 실수 )
		
		fl = lo; // 실수형 4byte - 정수형 8byte ( 실수 > 정수 )
		// in = bl; // 정수형 4byte - 불린형 1byte ( 정수 != 예약어 true/false )
		
		by = -128;
		by = 0;
		// by = 128; // byte = -128 ~ 127 (2^8)
		// 1) 1bit : 1 0 - 8bit = 1byte
		//	   1 0 (2개) / 10 10 → 11 10 01 00 (4개) / (8개) / (16개) ...
		
		
		
		//    #2. 형변환 - 강제타입변환 
		by = (byte)in; // 정수형 1byte = 정수형 4byte
		
		int in2 = (int) 1.2;
		float fl2 = (float) 1.2;
		System.out.println(in2 + "\t" + fl2);
		
		// Q1) System.out.println( 1.5 + 2.7 ); 형변환이용해서 3으로 나오게 만들기
		System.out.println((int)1.5 + (int)2.7);

		int in3 = (int) 1.5;
		int in4 = (int) 2.7;
		System.out.println(in3 + in4);
		
		//

	}

}
