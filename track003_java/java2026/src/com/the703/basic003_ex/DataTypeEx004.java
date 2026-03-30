package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx004 {

	public static void main(String[] args) {
		
//		패키지명 : com.the703.basic003_ex
//		클래스명 : DataTypeEx004
//		출력내용 :  Scanner 이용해서 파이값을 입력받고 출력하시오. 
//		     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
//		     파이값은 **입니다.
		
		// 변수
		Scanner sc = new Scanner(System.in);
		float f1 = 3.14f; 		// double d1 = 3.14;
		
		// 입력
		System.out.print("파이값을 입력하시오 > ");
		f1 = sc.nextFloat();	// d1 = sc.nextDouble();
		
		System.out.println("파이값은 " + f1 + "입니다"); // 소숫점 7까지 출력
		System.out.print("파이값은 " + f1 + "입니다"); // 소숫점 7까지 출력
		System.out.printf("\n파이값은 %f입니다", f1); // ★ %f → 기본 6자리 (반올림)
//		System.out.printf("\n파이값은 %.f입니다", f1);
		System.out.printf("\n (소숫점 0까지) 파이값은 %.0f입니다", f1); // 소숫점 0까지 출력 (반올림)
		System.out.printf("\n (소숫점 1까지) 파이값은 %.1f입니다", f1); // 소숫점 1까지 출력 (반올림)
		System.out.printf("\n (소숫점 2까지) 파이값은 %.2f입니다", f1); // 소숫점 2까지 출력 (반올림)
		System.out.printf("\n (소숫점 6까지) 파이값은 %.6f입니다\n", f1); // 소숫점 6까지 출력 (반올림)
		
		/*
		System.out.println(10/3); // 정수 / 정수 = 정수
		System.out.println(10/3f); // 정수 / 실수 = 실수
		System.out.println(10f/3); // 실수 / 정수 = 실수
		*/
	}

}
