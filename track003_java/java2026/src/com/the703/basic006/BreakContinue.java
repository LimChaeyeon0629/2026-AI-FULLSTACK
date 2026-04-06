package com.the703.basic006;

import java.util.Scanner;

public class BreakContinue {

	public static void main(String[] args) {
		
		// ver-0
//		{ int a = 1; System.out.println(a); } // 영역
//		a = 2; 		// { }은 영역을 나타냄 → a 영역이 이미 있어서 불가능
		
		// ver-1 	for 반복
		// 반복해 { 영역 }
//		for(;;) { System.out.println(1); }
		
		// ver-2	반복 빠져나오기 { break / 
		for(int i=1; i<5; i++) {	// for(초기; 조건; 증감)
			if(i == 3) break;
			System.out.println(i);
		}
		
		//////////////////////////////////////
		System.out.println();
		for(int i=1; i<5; i++) { 	// for(초기; 조건; 증감)
			if(i == 3) continue;
			System.out.println(i);
		}
		
		int a = -1;
		Scanner sc = new Scanner(System.in);
		// ver-3
		for(;;) {
			System.out.println("1 입력");
			a = sc.nextInt();
			
			if(a == 1) { break; } // 잘 입력하면 나가기
		}
	}
}
