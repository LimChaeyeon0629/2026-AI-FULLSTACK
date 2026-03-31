package com.the703.basic003;

public class DataType001 {

	public static void main(String[] args) {
		
		// 1. 자바의 자료형 분류 ( 기본형 - 논리형, 정수형, 실수형 / 참조형 - 주소값 저장 )
		// 2. 기본형 : 값 저장
		// 2-1) 논리형 : boolean - true/false / 용량 1byte
		boolean b1 = true;
		System.out.println("1. 논리 boolean: " + b1);
		
		// 2-2) 정수형 : (byte - short - int★ - long(L) / 1, 2, 3 / 용량 1 - 2 - 4 - 8)
		byte by = 1; 	short sh = 2;	 int i = 4; 	long l = 8L; 
		
		// byte hap = by + 1; // byte(1) + int(4)
		int hap = by + 1;
		System.out.println("2. 정수: byte - short - int★ - long");
		
		// 2-3) 실수형 : (float(f) double★ / 3.14, 2.13 / 용량 4 - 8)
		// float f1 = 3.14; // 3.14를 double로 인식
		float f1 = 3.14f;	 double d1 = 3.14;
		
		f1 = l; // float (4byte) = long (8byte)
				// 실수(1.1111111...) > 정수(1)
		
		
		
		float fp1 = 1.0000001f; // 0 6개 + 1 = 7자리 → 정확하게 표현 가능
		float fp2 = 1.00000001f; // 0 7개 + 1 = 8자리 → 정밀도 초과 시 반올림
		float fp3 = 1.11111111f; // 1 7개 + 1 = 8자리 → 근사값
		
		System.out.println(fp1 + "\t" + fp2 + "\t" + fp3);
		//			 1.0000001			1.0			1.1111112
		
		double dp1 = 1.000000000000001; // 0 14개 + 1 = 15자리 → 정확하게 표현 가능
		double dp2 = 1.0000000000000001; // 0 15개 + 1 = 16자리 → 반올림
		double dp3 = 1.1111111111111111; // 1 15개 + 1 = 16자리 → 근사값
		
		System.out.println(dp1 + "\t" + dp2 + "\t" + dp3);
		// 		1.000000000000001		1.0			1.1111111111111112
		
		
		// 3. 참조형 : 주소값 저장
		String abc = "apple"; 				// abc (1000번지) = 1000번지["apple"]
		String abc2 = new String("apple"); 	// abc (1000번지) = 2000번지["apple"]
		System.out.println(abc);
		System.out.println(abc2);
		
		System.out.println(abc == abc2); 	// 주소값 (즉, 번지가 달라서 false)
		
		
	}

}
