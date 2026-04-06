package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx001 {

	public static void main(String[] args) {
		// 변수
		Scanner sc = new Scanner(System.in);
		
		// 입력
		System.out.print("숫자 한개 입력: ");
		int num = sc.nextInt();
		
		// 처리 + 출력
		switch(num) {
		case 3: 
			System.out.println("봄");
			break;
			
		case 6:
			System.out.println("여름");
			break;
			
		case 9:
			System.out.println("가을");
			break;
			
		case 12:
			System.out.println("겨울");
			break;
		
		default:
			System.out.println("3, 6, 9, 12 숫자만 입력");
		}
	}

}
