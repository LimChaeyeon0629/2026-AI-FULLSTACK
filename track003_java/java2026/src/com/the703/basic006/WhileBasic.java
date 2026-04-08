package com.the703.basic006;

public class WhileBasic {

	public static void main(String[] args) {
		// for 	 	1 2 3 출력
		// { 반복 }  { 변수 } 		for(시작; 종료; 변화)
		System.out.println("ver-0");
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		
		System.out.println("ver-1");
		for(int i = 1; i <= 3; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nver-2 while");
		int j = 1;
		while( j <= 3 ) {
			System.out.print(j + " ");
			j++;
		}
		
		System.out.println("\nver-3 do while");
		int i1 = 1;
		do {
			System.out.print(i1 + " ");
			i1++;
		} while( i1 <= 3 );
	}

}