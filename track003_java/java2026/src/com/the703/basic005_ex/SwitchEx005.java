package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 한개 입력: ");
		int num = sc.nextInt();
		
		switch(num%2) {
		case 1:
			System.out.println("남자");
			break;

		case 0:
			System.out.println("여자");
			break;
		}
	}

}
