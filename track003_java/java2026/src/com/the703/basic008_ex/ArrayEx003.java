package com.the703.basic008_ex;

public class ArrayEx003 {

	public static void main(String[] args) {
//	    1. 배열명 : arr
//	    2. 값 넣기 : "아이언맨" , "헐크" , "캡틴"
//	    3. for + length 로 출력
		
		String [] arr = { "아이언맨", "헐크", "캡틴" };
		System.out.println(arr.length);
		
		System.out.printf("%s\t", arr[0]);
		System.out.printf("%s\t", arr[1]);
		System.out.printf("%s\t", arr[2]);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
