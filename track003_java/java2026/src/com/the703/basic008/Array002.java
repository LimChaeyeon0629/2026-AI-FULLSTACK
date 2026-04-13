package com.the703.basic008;

import java.util.Arrays;

public class Array002 {

	public static void main(String[] args) {
		// 배열
		// [같은 타입]의 데이터 [연속된 공간]에 저장하는 자료구조
		// arr(1000번지) = 1000번지 { 1, 2, 3 } ★ 만드는 거와 동시에 값 넣기
		int [] arr = { 1, 2, 3 }; // arr 주소 담을 수 있어!
		
		int [] arr2 = new int[3]; // new 공간 빌리기 int 형태의 자료형 몇 개 ★ new
		System.out.println(arr2); // [I@5aaa6d82
		System.out.println(Arrays.toString(arr2)); // [0, 0, 0]
		
//		for(int i = 0; i < arr2.length; i++) {
//		System.out.print(arr2[i] + " ");

			
			
		int data = 0;
		// for + length 대입
		// ver-1	arr2[0] = 0;	 	arr2[1] = 10; 		arr2[2] = 20;
		
		// ver-2	arr2[0] = data;		data += 10;
//					arr2[1] = data;		data += 10;
//					arr2[2] = data;		data += 10;
					
		// ver-3
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = data;
			data += 10;
		}
		System.out.println(data);
	}

}
