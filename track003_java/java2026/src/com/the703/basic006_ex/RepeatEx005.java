package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1 = -1, num2 = -1, hap1 = 0, hap2 = 0;
		String i1, i2;
		
		System.out.println("숫자1 입력: ");
		num1 = sc.nextInt();
		System.out.println("숫자2 입력: ");
		num2 = sc.nextInt();
		
		
		
		// for
		if(num1 < num2) {			
			for(int i = num1; i <= num2; i++) {
				System.out.print(i);			// num1 ~ num2 출력
				i1 = i < num2 ? "+" : "";		// if(i < num2) { System.out.print("+"); }
				hap1 += i;						// num1 ~ num2 덧셈
			}
			System.out.print("=" + hap1);
		} else {
			for(int i = num1; i >= num2; i--) {
				System.out.print(i);			// num1 ~ num2 출력
				i2 = i > num2 ? "+" : "";		// if(i > num2) { System.out.print("+"); }
				hap2 += i;						// num1 ~ num2 덧셈
			}
			System.out.print("=" + hap2);
		}
		
//		for(; i <= num2;) {
//			System.out.print(i);
//			i1 = i < num2 ? "+" : "";
//			System.out.print(i1);
//			hap1 += i;
//			i++;
//		}
//		System.out.print("=" + hap1);
		
		
		
		// while
		int i = num1;
	
		if(num1 < num2) {
			while (i <= num2) {
				System.out.print(i);
				i1 = i < num2 ? "+" : "";
				System.out.print(i1);
				hap1 += i;
				i++;
			}
			System.out.print("=" + hap1);
		
		} else {
			while (i >= num2) {
				System.out.print(i);
				i2 = i > num2 ? "+" : "";
				System.out.print(i2);
				hap2 += i;
				i--;
			}
			System.out.print("=" + hap2);
		}
		
		
		
		// do while
		int j = num1;
		
		if (num1 < num2) {
			do {
				System.out.print(j);
				i1 = j < num2 ? "+" : "";
				System.out.print(i1);
				hap1 += j;
				j++;
			} while (j <= num2);
			System.out.print("=" + hap1);
			
		} else {
			do {
				System.out.print(j);
				i2 = j > num2 ? "+" : ""; 
				System.out.print(i2);
				hap2 += j;
				j--;
			} while (j >= num2);
			System.out.print("=" + hap2);
		}

	}
	
}