package com.the703.days;

public class Day015 {

	public static void main(String[] args) {
//		■2. JAVA
//		1.  for, while , do while을 이용해서 문제를 풀으시오.
//		     3   2   1
		
		// for
		for (int i = 3; i >= 1; i--) {
			System.out.print(i);
		}
		
		// while
		System.out.println();
		int i = 3;
		while (i >= 1) {
			System.out.print(i);
			i--;
		}
		System.out.println();
		
		// do while
		int j = 3;
		do {
			System.out.print(j);
			j--;
		} while (j >= 1);
//
//		2 이중 for 버전
//		다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//		★★★
//		★★
//		★
		
		System.out.println();
		for (int k = 3; k >= 1; k--) {
			for (int l = 3; l >= 4-k; l--) {
				System.out.print("★");
			}
			System.out.println();
		}
//
//		3.  1차원배열      new 연산자 이용해서 배열만들기
//		    1. 배열명 : arr     
//		    2. 값 넣기 :   A B C        for+length 이용서 값 대입
//		    3. for + length 로 출력 
		
		char [] arr = new char[3];
		char data = 'A';
		
		for (int m = 0; m < arr.length; m++) {
			arr[m] = data;
			data += 1;
			System.out.print(arr[m]);
		}
	}

}
