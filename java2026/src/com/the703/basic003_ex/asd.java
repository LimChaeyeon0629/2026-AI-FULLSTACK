package com.the703.basic003_ex;

import java.util.Scanner;

public class asd {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  int num1 = -1, num2 = -1;
		  double result;

		  System.out.print("num1 입력: ");
		  num1 = sc.nextInt();
		  System.out.print("num2 입력: ");
		  num2 = sc.nextInt();

		  result = (double)num1 / num2;

		  System.out.printf("%.2f", result);
	}

}
