package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx006 {

	public static void main(String[] args) {
//		숫자를입력을받아
//		   홀수면 남자, 짝수면 여자를 출력하는 프로그램을 작성하시오.
//		   ※  num%2==0  짝수
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int num = -1;
		
		// 입력
		System.out.println("숫자 입력: ");
		num = sc.nextInt();
		
		// 출력
//		if (num % 2 == 1) {
//			System.out.println("남자");
//		} else if (num % 2 == 0) {
//			System.out.println("여자");
//		}
		
		System.out.println(num % 2 == 1 ? "남자"
				:			num % 2 == 0 ? "여자" : "");
		
	}

}
