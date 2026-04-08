package com.the703.basic006;

public class RepeatEx001 {

	public static void main(String[] args) {
//		1.  for , while , do while문을 이용해서
//		다음과 같이 출력하시오 :  1 2 3 4 5
		System.out.println("Q1. for ");
		for(int i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println("\nQ2. while ");
		int i = 1;
		while( i <= 5 ) {
			System.out.print(i + " ");
			i++;
		} 

		System.out.println("\nQ3. do while ");
		int i1 = 1;
		do {
			System.out.print(i1 + " ");
			i1++;
		} while( i1 <= 5 );
		
		
		
//		2.  for , while , do while문을 이용해서
//		다음과 같이 출력하시오 :  5 4 3 2 1
		System.out.println("\nQ4. for ");
		for(int j = 5; j >= 1; j--) {
			System.out.print(j + " ");
		}
		
		System.out.println("\nQ5. while ");
		int j = 5;
		while (j >= 1) {
			System.out.print(j + " ");
			j--;
		}
		
		System.out.println("\nQ6. do while ");
		int j1 = 5;
		do {
			System.out.print(j1 + " ");
			j1--;
		} while( j1 >= 1 );
		
		
		
//		3.  for , while , do while문을 이용해서
//		다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3
		System.out.println("\nQ7. for ");
		for(int a = 1; a <= 3; a++) {
			System.out.print("JAVA" + a + " ");
		}
		
		System.out.println("\nQ8. while ");
		int a = 1;
		while (a <= 3) { 
			System.out.print("JAVA" + a + " ");
			a++;
		}
		System.out.println("\nQ9. do while ");
		int a1 = 1;
		do { 
			System.out.print("JAVA" + a1 + " ");
			a1++;
		} while (a1 <= 3);
	}

}
