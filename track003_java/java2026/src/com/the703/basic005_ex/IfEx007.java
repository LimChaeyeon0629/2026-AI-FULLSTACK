package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {

		// 변수
		int num1 = -1, num2 = -1;
		double result = -1;
		char ch = '\u0000'; // String s; 안 되는 이유 : 문자열은 .equals();
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.print("1. 정수를 하나 입력: ");
		num1 = sc.nextInt();
		System.out.print("2. 정수를 하나 입력: ");
		num2 = sc.nextInt();
		System.out.print("3. 연산자 입력: ");
		ch = sc.next().charAt(0);

		// 처리
		if (ch == '+') {
			result = (num1 + num2);
		} else if (ch == '-') {
			result = (num1 - num2);
		} else if (ch == '*') {
			result = (num1 * num2);
		} else if (ch == '/') {
			result = (double)num1 / num2;
		}

		// 출력
		if (ch == '+' || ch == '-' || ch == '*') {
			System.out.printf("%d%c%d=%d", num1, ch, num2, (int)result);
		} else if (ch == '/') {
			System.out.printf("%d%c%d=%.2", num1, ch, num2, result);
		}
		
	}

}
