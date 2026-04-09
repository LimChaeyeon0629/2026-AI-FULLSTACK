package com.the703.basic007_ex;

public class For2Ex003 {

	public static void main(String[] args) {
//		#
//		##
//		###
//		####

		// ver-1
		System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();

		
		
		// ver-2
		System.out.println();
		for(int i = 1; i <= 1; i++) { System.out.print('#'); }
		System.out.println();
		for(int i = 1; i <= 2; i++) { System.out.print('#'); }
		System.out.println();
		for(int i = 1; i <= 3; i++) { System.out.print('#'); }
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print('#'); }
		System.out.println();
		
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print( i <= 1 ? '#' : ' '); }
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print( i <= 2 ? '#' : ' '); }
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print( i <= 3 ? '#' : ' '); }
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print( i <= 4 ? '#' : ' '); }
		System.out.println();
		
		
		// ver-3
		System.out.println();
		for(int j = 1; j <= 4; j++) {
			for(int i = 1; i <= j; i++) {
				System.out.print('#');
			}
			System.out.println();
		}
		
	}

}

//		if(i == 1) { System.out.print('#'); } System.out.println();
//		for(int i = 1; i <= 4; i++) 
//		{
//			if(i == 1) { System.out.print('#'); } System.out.println();
//			if(i == 2) { System.out.print('#'); } System.out.println();
//			if(i == 3) { System.out.print('#'); } System.out.println();
//			if(i == 4) { System.out.print('#'); } System.out.println();
//		}

//		for(int j = 1; j <= 4; j++) {
//			for(int i = 1; i <= 4; i++) {
//				System.out.println( i == j ? '#':"" );
//				}
//			System.out.println();
//		}