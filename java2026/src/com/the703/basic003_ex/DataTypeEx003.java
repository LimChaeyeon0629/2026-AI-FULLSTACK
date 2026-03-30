package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {
		
//		패키지명 : com.the703.basic003_ex
//		클래스명 : DataTypeEx003
//		출력내용 :  Scanner 이용해서 태어난 년도를 입력받아 나이 계산하기
//		태어난 년도를 입력하세요. >
//		2000
//		당신의 나이는 25살 입니다.
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int year = -1;
		
		// 입력
		System.out.print("태어난 년도를 입력하세요. > ");
		year = sc.nextInt();
		
		// 처리
		year = 2026 - year;
		
		// 출력
		System.out.println("당신의 나이는 " + year + "살 입니다.");
		System.out.print("당신의 나이는 " + year + "살 입니다.");
		System.out.printf("\n당신의 나이는 %d살 입니다.", year);
	}

}
