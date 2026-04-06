package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_team {

	public static void main(String[] args) {
		// 변수
		// 입력
		// 처리
		// 출력
		// 만약	+ 라면 10+3=13
		// 만약	- 라면 10-3=7
		// 만약	* 라면 10*3=30
		// 만약	/ 라면 10/3=3.33
		Scanner scanner = new Scanner(System.in);
		int  num1=0, num2=0, value=0;	
		
		char ch = '\u0000'; 
		System.out.print("정수를 하나 입력 > ");
		num1 = scanner.nextInt();
		System.out.print("정수를 하나 입력 > ");
		num2 = scanner.nextInt();
		System.out.print("연산자를 입력 > ");
		ch = scanner.next().charAt(0);
		
			 if( ch == '+' ) { value = num1 + num2; }
		else if( ch == '-' ) { value = num1 - num2; }
		else if( ch == '*' ) { value = num1 * num2; }
		else if( ch == '/' ) { value = (double)num1 / num2; }
		else				 { System.out.println( " + - * / 가 아니다" ); }
			 
//			 System.out.println(num1+""+ch+""+num2+"="+value);
			 System.out.printf("%d%s%d=%.2f",num1,ch,num2,value);
			 
	}

}
