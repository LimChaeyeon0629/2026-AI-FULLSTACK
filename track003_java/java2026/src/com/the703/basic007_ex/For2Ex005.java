package com.the703.basic007_ex;

public class For2Ex005 {

	public static void main(String[] args) {
//		1234
//		1234
//		1234
//		1234
		
		// ver-1
		System.out.print("1"); System.out.print("2"); System.out.print("3"); System.out.print("4"); System.out.println();
		System.out.print("1"); System.out.print("2"); System.out.print("3"); System.out.print("4"); System.out.println();
		System.out.print("1"); System.out.print("2"); System.out.print("3"); System.out.print("4"); System.out.println();
		System.out.print("1"); System.out.print("2"); System.out.print("3"); System.out.print("4"); System.out.println();
		
		
		
		// ver-2
		System.out.println();
		for(int i = 1; i <= 4; i++) { System.out.print(i); }
		System.out.println();

		for(int i = 1; i <= 4; i++) { System.out.print(i); }
		System.out.println();
		
		for(int i = 1; i <= 4; i++) { System.out.print(i); }
		System.out.println();

		for(int i = 1; i <= 4; i++) { System.out.print(i); }
		System.out.println();
		
		
		
		// ver-3
		System.out.println();
		for(int j = 1; j <= 4; j++)
		{
			for(int i = 1; i <= 4; i++) { System.out.print(i); }
			System.out.println();
		}
	}

}
