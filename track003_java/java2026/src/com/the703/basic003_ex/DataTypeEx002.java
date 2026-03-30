package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx002 {

	public static void main(String[] args) {
		
//		패키지명 : com.the703.basic003_ex
//		클래스명 : DataTypeEx002
//		출력내용 :  Scanner 이용해서 나이 입력받고 출력하시오.
//		좋아하는 수(정수)   입력하시오 > _입력받기
//		좋아하는 숫자는 ** 입니다.
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int num = -1;
		
		// 입력
		System.out.print("좋아하는 수(정수) 입력하시오 > ");
		num = sc.nextInt();
		
		//처리 - x
		
		//출력
		System.out.println("좋아하는 숫자는 " + num + "입니다");
		System.out.print("좋아하는 숫자는 " + num + "입니다");
		System.out.printf("\n좋아하는 숫자는 %d입니다", num);
		
	}

}
