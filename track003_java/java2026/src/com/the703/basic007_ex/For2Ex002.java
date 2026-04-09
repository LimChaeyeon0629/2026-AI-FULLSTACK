package com.the703.basic007_ex;

public class For2Ex002 {

	public static void main(String[] args) {
//		@###
//		#@##
//		##@#
//		###@
		
		// ver-1
		System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.println();
		
		// ver-2 칸 정리
		System.out.println();
		// 첫번째에 오면 @
		for(int i = 1; i <= 4; i++) { System.out.print( i == 1 ? '@' : '#'); } System.out.println();
									// if ( i == 1 ) { System.out.print('@') }
		// 두번째에 오면 @				// else { System.out.print('#') }
		for(int i = 1; i <= 4; i++) { System.out.print( i == 2 ? '@' : '#'); } System.out.println();
									// if ( i == 2 ) { System.out.print('@') }
		// 세번째에 오면 @				// else { System.out.print('#') }
		for(int i = 1; i <= 4; i++) { System.out.print( i == 3 ? '@' : '#'); } System.out.println();
									// if ( i == 3 ) { System.out.print('@') }
		// 네번째에 오면 @				// else { System.out.print('#') }
		for(int i = 1; i <= 4; i++) { System.out.print( i == 4 ? '@' : '#'); } System.out.println();
									// if (i == 4) { System.out.print('@') }
									// else { System.out.print('#') }
		// ver-3 층 정리
		System.out.println();
		for(int j = 1; j <= 4; j++)
		{
			for(int i = 1; i <= 4; i++)
			{ System.out.print( i == j ? '@' : '#'); }
			// if ( i == j ) { System.out.print('@') }
			// else { System.out.print('#') }
			System.out.println();
		}
	}
}
