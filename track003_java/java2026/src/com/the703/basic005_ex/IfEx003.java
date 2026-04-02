package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		// 입력
		System.out.print("숫자 입력: ");
		num = sc.nextInt();
		
		// 처리 + 출력
//		if (num == 1) {
//			System.out.println("one");
//		} else if (num == 2) {
//			System.out.println("two");
//		} else if (num == 3) {
//			System.out.println("three");
//		} else {
//			System.out.println("1, 2, 3이 아니다");
//		}
		
//		String answer = num == 1 ? "one" :
//						num == 2 ? "two" :
//						num == 3 ? "three" : "1, 2, 3이 아니다";
//		System.out.println(answer);
		
		System.out.println(num == 1 ? "one"
				:		   num == 2 ? "two"
				:		   num == 3 ? "three"
				:		   "1, 2, 3이 아니다");
	}

}
