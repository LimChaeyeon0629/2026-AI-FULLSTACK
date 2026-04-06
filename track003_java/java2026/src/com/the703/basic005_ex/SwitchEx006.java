package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx006 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// char ch = '\u0000';
		
		System.out.print("문자 한개 입력: ");
		char ch = sc.next().charAt(0); // 'M', 'm'
		
		switch(ch) {	 // 문자열 String ch는 switch(ch.charAt(0))
			case 'M': case 'm':
				System.out.println("월요일: 공부하는 날");
				break;
			
			case 'T': case 't':
				System.out.println("화요일: 운동하는 날");
				break;
			
			case 'W': case 'w':
				System.out.println("수요일: 독서하는 날");
				break; 
			
			case 'F': case 'f':
				System.out.println("금요일: 영화 보는 날");
				break;
			
			case 'S': case 's':
				System.out.println("토요일: 여행 가는 날");
				break;
			
			case 'U': case 'u':
				System.out.println("일요일: 휴식하는 날");
				break;
			
			default:
				System.out.println("'M', 'T', 'W', 'F', 'S', 'U'를 입력해주세요.");
		}
		
	}
}
