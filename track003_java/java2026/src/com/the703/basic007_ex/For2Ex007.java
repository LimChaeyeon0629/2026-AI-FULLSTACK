package com.the703.basic007_ex;

public class For2Ex007 {

	public static void main(String[] args) {
//		4444
//		333
//		22
//		1
		
		// ver-1
		// ...(4)
		System.out.print("3"); System.out.print("3"); System.out.print("3"); System.out.println();
		System.out.print("2"); System.out.print("2"); System.out.println();
		// ...(1)
		
		
		
		// ver-2
		System.out.println();
		
		// ...(4)
		for(int i = 1; i <= 3; i++) {
			System.out.print("3");
		}
		System.out.println();
		
		for(int i = 1; i <= 2; i++) {
			System.out.print("2");
		}
		System.out.println();
		// ...(1)
		
		
		
		// ver-3
		System.out.println();
		for(int ch = 4; ch >= 1; ch--) 		// ch = 4 3 2 1 (열)
		{				// 1 <= 4;
			for(int i = 1; i <= ch; i++) { 	// 조건: i가 ch보다 작거나 같으면 ch 출력
				System.out.print(ch); 		// 4444
			}
		System.out.println();
		}
	}

}
