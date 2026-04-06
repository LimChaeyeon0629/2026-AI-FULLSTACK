package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// char ch = '\u0000';
		
		System.out.print("문자 한개 입력: ");
		char ch = sc.next().charAt(0); // 'a'
		
		switch(ch) {
		case 'a':
			System.out.println("APPLE");
			break;

		case 'b': 
			System.out.println("BANANA");
			break;
		
		case 'c': 
			System.out.println("COCONAT");
			break;
			
		default:
			System.out.println("'a', 'b', 'c'를 입력해주세요.");
		}
	}

}
