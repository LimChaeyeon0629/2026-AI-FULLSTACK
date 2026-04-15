package com.the703.basic008_ex;

public class Array2Ex004 {

	public static void main(String[] args) {
//		1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//
//		int[][] datas = {  {  10, 10, 10 ,10},             
//		                  {  20, 20, 20 ,20},     
//		                  {  30, 30, 30 ,30},     
//		};  // 3층 4칸                                  
//		                               
//		int[][] result = new int[datas.length+1][datas[0].length+1];    
//
//		#1. result 에 datas데이터 복사하기
//		#2. 가로방향누적데이터
//		#3. 세로방향데이터누적
//		#4. 총합
//
//		출력내용:
//		10   10   10   10   40   
//		20   20   20   20   80   
//		30   30   30   30   120   
//		60   60   60   60   240   
		
		int [][] datas = { 
				{ 10,10,10,10 },
				{ 20,20,20,20 },
				{ 30,30,30,30 } };
		
		int [][] result = new int[datas.length+1][datas[0].length+1]; // 4층 5칸 배열 지정

		/*
		for(int ch=0; ch<datas.length; ch++) {
			for(int i=0; i<datas[ch].length; i++) {
//			System.out.print(datas[0][1] + "\t"); // 1칸 2칸 3칸 4칸 출력
				System.out.print(datas[ch][i] + "\t");
			}
			System.out.println();
		}
		*/
		
		int data = 0;
		
//		result[0][5] = data++; // 40
//		result[1][5] = data++; // 80
//		result[2][5] = data++; // 120
//		result[3][5] = data++; // 240
		
		for(int ch=0; ch<result.length; ch++) { // 4층
			for(int i=0; i<result[ch].length; i++) { // 5칸
//				result[0][i] = 10;
//				if (i == 5) { result[0][5] = 40; }
//				data += 10;
				System.out.printf("%d\t", datas[ch][i]); // datas 3층 4칸 출력
//				System.out.printf("%d\t", result[ch][i]);
				
			}
			System.out.println();
		}
	}
}
