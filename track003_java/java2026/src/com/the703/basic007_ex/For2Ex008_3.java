package com.the703.basic007_ex;

public class For2Ex008_3 {

	public static void main(String[] args) {
		
		// for
//		for(int ch = 1; ch <= 6; ch++) {
//			for(int i = ch; i <= 6; i++) { 
//				if(ch+i==6) { 
//					System.out.println(ch + "+" + i + "=" + 6); 
//				} 
//			}
//		}
//		
//		// while
//		System.out.println();
//		int ch = 1;
//		while(ch <= 6) {
//			for(int i = ch; i <= 6; i++) { 
//				if(ch+i==6) { 
//					System.out.println(ch + "+" + i + "=" + 6); 
//				} 
//			} ch++;
//		}
//		
//		// do while
//		do {
//			for(int i = ch; i <= 6; i++) { 
//				if(ch+i==6) { 
//					System.out.println(ch + "+" + i + "=" + 6); 
//				} 
//			} ch++;
//		} while(ch <= 6);
		
		
		
		
		
		
		
		
		
		
		
//		두 개의 주사위를 던졌을 때 눈의 합이 b이 되는
//		모든 경우의 수를 출력하는 프로그램을 작성하시오.
//		이중 for, 이중 while, 이중 do while
		
		
		// for
		System.out.println();
		for(int i = 1; i <= 6; i++) {
			for(int j = 6; j >= 1; j--) {
				if(i+j == 6) { System.out.println(i + "+" + j + "=" + 6); }
			}
		}

			
			
		// while
		System.out.println();
		int i = 1;
		
		while(i <= 6) {
			int j = 6;
			
			while(j >= 1) {
				if(i+j == 6) { System.out.println(i + "+" + j + "=" + 6); } j--;
			} i++;
		}
		
		
		
		// do while
		System.out.println();
		int k = 1;
		
		do {
			int l = 6;
			
			do {
				if(k+l == 6) { System.out.println(k+ "+" + l + "=" + 6); } l--;
			} while(l >= 1); k++;
		} while(k <= 6);

	}
}