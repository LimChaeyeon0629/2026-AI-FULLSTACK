package com.the703.basic008;

public class Array001 {

	public static void main(String[] args) {
		// 1. 변수 활용 시
		int a=1, b=2, c=3;
		
		// 2. 배열?
		/* [같은 타입]의 데이터를 [연속된 공간에 저장]하는 자료구조
		  - 각 데이터의 저장위치 [인덱스]를 통해서 접근
		  - 1) int [] arr 주소 보관할 준비 됐어요
		  - 2) null 공간은 있지만 값이 없어요
	
		 */
		int [] arr = null ;
		System.out.println(arr);
		
		// [stack] arr2 주소값 보관	= [heap] 1, 2, 3 연속된 공간에 저장
		int [] arr2 				= { 1, 2, 3 }; // index 3개는 0부터 2까지
		// arr2(1000번지)			= 1000번지에 있는 { 1, 2, 3 }
		// 									 		[0] [1] [2]
		System.out.println(arr2); // [I@73a28541
		System.out.println("index 1 꺼내쓰기: " + arr2[0]); // 1
		System.out.println("index 2 꺼내쓰기: " + arr2[1]); // 2
		System.out.println("index 3 꺼내쓰기: " + arr2[2]); // 3
		
		// 3. 배열에서
		// 3-1. arr3 : 1 2 3 4 5
		int [] arr3 = { 1, 2, 3, 4, 5 }; // 갯수 5개, index 범위 0~4
		System.out.println(arr3[2]); // 3
		
		// 3-2. arr4 : 100 200 300
		int [] arr4 = { 100, 200, 300 }; // 갯수 3개, index 범위 0~2
		System.out.println(arr4[0]); // 100
		
		// 3-3. arr5 : 1.1 1.2 1.3
		double [] arr5 = { 1.1, 1.2, 1.3 }; // 갯수 3개, index 범위 0~2
		System.out.println(arr5[2]); // 1.3
		
		// 3-4. arr6 : 'a' 'b' 'c'
		char [] arr6 = { 'a', 'b', 'c' }; // 갯수 3개, index 범위 0~2
		System.out.println(arr6[0]); // 시작: 0
		System.out.println(arr6[1]); // 변화: 1씩 증가
		System.out.println(arr6[2]); // 종료: 2
		System.out.println(arr6.length); // 갯수 3개
		
		// 3-5. 41~45줄 for문으로 줄이기	{반복} {변수} for(시작; 종료; 변화)
		System.out.println();
		for(int i = 0; i < arr6.length; i++) { // i = index 값 0 1 2
			System.out.print(arr6[i] + " ");
		}
	}
}
