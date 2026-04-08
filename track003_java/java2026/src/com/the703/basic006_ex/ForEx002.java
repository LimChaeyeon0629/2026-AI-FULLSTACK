package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
//		사용자에게 단을 입력받아 해당하는 
//		단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력: ");
		int dan = sc.nextInt();
		
		for(int i = dan; i <= dan; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
		}
		
//		for(int i = 1; i <= 9; i++) {
//			System.out.printf("%d*%d=%d\n", dan, 1, dan*i);
//		}
	}

}