package com.the703.basic007_ex;

public class For2Ex004 {

	public static void main(String[] args) {
		
		// ver-1
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.println();
		
		
		
		// ver-2
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print('#'); }
		System.out.println();
		
		for(int i = 1; i <= 3; i++) { System.out.print('#'); }
		System.out.println();
		
		for(int i = 1; i <= 2; i++) { System.out.print('#'); }
		System.out.println();
		
		for(int i = 1; i <= 1; i++) { System.out.print('#'); }
		System.out.println();
		
		
		
		// ver-3
		System.out.println();
		
		for(int ch = 4; ch >= 1; ch--)
		{
			for(int i = 1; i <= ch; i++) { System.out.print('#'); }
			System.out.println();
		}
	}

}
