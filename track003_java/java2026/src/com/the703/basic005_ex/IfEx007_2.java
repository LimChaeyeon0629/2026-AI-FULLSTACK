package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_2 {

	public static void main(String[] args) {
		// 변수
		Scanner sc = new Scanner(System.in);
		int num1 = -1, num2 = -1;
		String result = "";
		char ch = '\u0000';

		// 입력
		System.out.print("1. 정수를 하나 입력: ");
		num1 = sc.nextInt();
		System.out.print("2. 정수를 하나 입력: ");
		num2 = sc.nextInt();
		System.out.print("3. 연산자 입력: ");
		ch = sc.next().charAt(0);

		// 처리
		//result = "" + num1 + ch + num2 + "="; // 출력파트
		
		// "" 쓰는이유 : java 문자열로 바꾸지 않으면 아스키코드로 인식
		// + → 43			- → 45			* → 42 			/ → 47
		// 10+43+3= 56		10+45+3= 58		10+42+3= 55		10+47+3= 60
		
		if (ch == '+') {
			System.out.println( result += (num1 + num2) ); // result = result + (num1 + num2)
		} else if (ch == '-') {
			System.out.println( result += (num1 - num2) ); // result = result + (num1 - num2)
		} else if (ch == '*') {
			System.out.println( result += (num1 * num2) ); // result = result + (num1 * num2)
		} else if (ch == '/') {
			result += String.format("%.2f", (double)num1/num2);
			
//			System.out.println( result += String.format("%.2f", (double)num1/num2) );
									   // String.format("	 ", 				   );
		}
		System.out.println("" + num1 + ch + num2 + "=" + result ); // 출력파트 & result
	}

}
