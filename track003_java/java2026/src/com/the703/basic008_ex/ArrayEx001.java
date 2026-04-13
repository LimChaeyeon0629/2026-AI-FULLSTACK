package com.the703.basic008_ex;

public class ArrayEx001 {

	public static void main(String[] args) {
//	    1. 배열명 : arr
//	    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5
//	    3. for + length 로 출력
		
		double [] arr = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		System.out.println(arr.length);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
}
