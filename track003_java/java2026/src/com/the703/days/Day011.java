package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
		// a = apple
		// b = banana
		// c = coconut
		Scanner sc = new Scanner(System.in);
		char ch = '\u0000';
		
		System.out.println("문자 하나 입력: ");
		ch = sc.next().charAt(0);
		
		// if문
		if (ch == 'a') { System.out.println("apple"); }
		else if (ch == 'b') { System.out.println("banana"); }
		else if (ch == 'c') { System.out.println("coconut"); }
		
		// switch문
		switch(ch) { 
		case 'a': System.out.println("apple"); break;  
		case 'b': System.out.println("banana"); break;  
		case 'c': System.out.println("coconut"); break; }
		
		
		
		// for, while, do while
		// 1 2 3 4 5 출력
		
		// for
		for(int i = 1; i <= 5; i++) { System.out.print(i + " "); }
		
		System.out.println();
		// while
		int i = 1;
		while (i<=5) { System.out.print(i + " "); i++; }
		
		System.out.println();
		// do while
		int j = 1;
		do { System.out.print(j + " "); j++; } while (j<=5);
	
	}

}
