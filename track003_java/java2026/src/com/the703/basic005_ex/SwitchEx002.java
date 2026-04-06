package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002 {

	public static void main(String[] args) {
		// 변수
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("숫자 한개 입력: ");
		int num = sc.nextInt();
		
		// 처리 + 출력
		switch(num/3) {
		case 1: 		// 3/3 = 1		 4/3 = 1(몫)		5/3 = 1(몫)
			System.out.println("봄");
			break;
		
		case 2: 		// 6/3 = 2		 7/3 = 2(몫)		8/3 = 2(몫)
			System.out.println("여름");
			break;
		
		case 3: 		// 9/3 = 3		 10/3 = 3(몫)	11/3 = 3(몫)
			System.out.println("가을");
			break;
			
		case 4: case 0: // 12/3 = 4		 1/3 = 0(몫)		2/3 = 0(몫)
			System.out.println("겨울");
			break;
		
		default:
			System.out.println("1 ~ 12 사이의 숫자 입력");
		}
	}

}
