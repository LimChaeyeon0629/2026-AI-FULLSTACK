package com.the703.basic007_ex;

public class For2Ex006 {

	public static void main(String[] args) {
//		1
//		22
//		333
//		4444
		
		// ver-1
		System.out.print("1"); System.out.println();
		System.out.print("2"); System.out.print("2"); System.out.println();
		System.out.print("3"); System.out.print("3"); System.out.print("3"); System.out.println();
		System.out.print("4"); System.out.print("4"); System.out.print("4"); System.out.print("4"); System.out.println();
		
		
		
		// ver-2
		System.out.println();
		for(int i = 1; i <= 1; i++) {
			System.out.print("1");
		}
		System.out.println();
		
		for(int i = 1; i <= 2; i++) {
			System.out.print("2");
		}
		System.out.println();
		
		for(int i = 1; i <= 3; i++) {
			System.out.print("3");
		}
		System.out.println();
		
		for(int i = 1; i <= 4; i++) {
			System.out.print("4");
		}
		System.out.println();
		
		
		
		// ver-3
		System.out.println();
		for(int j = 1; j <= 4; j++) { // 1 2 3 4
			for(int i = 1; i <= j; i++) { // 조건: i가 j보다 작거나 같으면 j 출력
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
