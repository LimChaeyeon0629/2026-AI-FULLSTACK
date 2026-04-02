package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {

		// 변수
		Scanner sc = new Scanner(System.in);
		int num1 = -1, num2 = -1, num3 = -1;
		double num4 = -1;
		char ch; // String s; 안 되는 이유 : 문자열은 .equals();
		
		// 입력
		System.out.print("정수1 입력: ");
		num1 = sc.nextInt();
		System.out.print("정수2 입력: ");
		num2 = sc.nextInt();
		System.out.print("연산자 입력: ");
		ch = sc.next().charAt(0);
		
		// 처리
		if (ch == '+') {
			num3 = (num1 + num2);
		} else if (ch == '-') {
			num3 = (num1 - num2);
		} else if (ch == '*') {
			num3 = (num1 * num2);
		} else if (ch == '/') {
			num4 = (double)num1 / num2;
		}
		
		// 출력
		if (ch == '+' || ch == '-' || ch == '*') {
			System.out.printf("%d%c%d=%d", num1, ch, num2, num3);
		} else if (ch == '/') {
			System.out.printf("%d%c%d=%.2f", num1, ch, num2, num4);
		}
	}

}

//		if (ch == '+') {
//			System.out.printf("%d + %d" + " = " + "%d", num1, num2, num1+num2);
//		} else if (ch == '-') {
//			System.out.printf("%d - %d" + " = " + "%d", num1, num2, num1-num2);
//		} else if (ch == '*') {
//			System.out.printf("%d * %d" + " = " + "%d", num1, num2, num1*num2);
//		} else if (ch == '/') {
//			System.out.printf("%d / %d" + " = " + "%.2f", num1, num2, num3);
//		}