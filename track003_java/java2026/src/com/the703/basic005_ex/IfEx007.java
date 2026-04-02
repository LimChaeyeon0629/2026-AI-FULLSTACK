package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
//		계산기
//		1. 정수를 하나 입력해주세요 > 10
//		2. 정수를 하나 입력해주세요 > 3
//		3. 연산자를 입력해주세요(+,-,*,/) > +
//		10+3=13

		// 변수
		Scanner sc = new Scanner(System.in);
		int num1 = -1, num2 = -1;
		double num3;
		char ch;
		// String s; 안 되는 이유: 문자열은 .equals();
		
		// 입력
		System.out.print("정수1 입력: ");
		num1 = sc.nextInt();
		System.out.print("정수2 입력: ");
		num2 = sc.nextInt();
		System.out.print("연산자 입력: ");
		ch = sc.next().charAt(0);
		
		num3 = (double)num1 / num2;
		
		// 처릭
		if (ch == '+') {
			System.out.printf("%d + %d" + " = " + "%d", num1, num2, num1+num2);
		} else if (ch == '-') {
			System.out.printf("%d - %d" + " = " + "%d", num1, num2, num1-num2);
		} else if (ch == '*') {
			System.out.printf("%d * %d" + " = " + "%d", num1, num2, num1*num2);
		} else if (ch == '/') {
			System.out.printf("%d / %d" + " = " + "%.2f", num1, num2, num3);
		}
	
	}

}
