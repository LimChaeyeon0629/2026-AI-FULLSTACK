package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx001 {

	public static void main(String[] args) {
			
		// 변수
		Scanner sc = new Scanner(System.in);
	    double result;
	    
	    // 입력
	    int num1 = (int)sc.nextInt();
	    int num2 = (int)sc.nextInt();
	    
	    // 처리
	    result = (double)num1 / num2; // num1 = 10 입력 (int), num2 = 3 (int)
	    
	    // 출력
	    System.out.printf("%d + %d = %.2f", num1, num2, result);
	}

}
