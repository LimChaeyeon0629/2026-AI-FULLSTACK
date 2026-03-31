package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
		
//			패키지명 : com.the703.basic003_ex
//			클래스명 : DataTypeEx005
//			출력내용 :  Scanner 이용해서  성적처리를 입력받고 출력하시오.
//			국어점수를 입력하시오.  _입력받기    100 
//			영어점수를 입력하시오.  _입력받기    100 
//			수학점수를 입력하시오.  _입력받기    99
//
//		   총점 :  299
//		   평균 :  99.67 

		// 변수
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total = -1;
		double avg = -1;
		
		// 입력
		System.out.print("국어 점수를 입력하시오: ");
		kor = sc.nextInt();
		
		System.out.print("영어 점수를 입력하시오: ");
		eng = sc.nextInt();
		
		System.out.print("수학 점수를 입력하시오: ");
		math = sc.nextInt();
		
		// 처리
		total = kor + eng + math;
		avg = total / 3f; 	// avg = total / 3.0;
		// 정수 / 정수 = 정수
		// 정수 / 실수 = 실수
		// total / 3f = 실수
		
		// 출력
		System.out.println("총점: " + total);
		System.out.printf("평균: %.2f", avg); // 소숫점 2자릿수까지 출력
		
		System.out.println("\n평균: " + avg); // 소숫점 14자릿수까지 출력
											 // double 15자리에서 반올림
		
		System.out.print("\n평균: " + avg);
		System.out.printf("\n총점: %d \n평균: %.2f", total, avg);
	}

}
