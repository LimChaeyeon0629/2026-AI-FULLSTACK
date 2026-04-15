package com.the703.basic008_ex;

public class Array2Ex003 {

	public static void main(String[] args) {
//		배열을 이용하여 다음의 프로그램을 작성하시오.   
//		1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//	
//		 int[][] arr = {
//		   { 1, 1, 1,},
//		   { 2, 2, 2,},
//		   { 3, 3, 3,},
//		   { 4, 4, 4,},
//		 };
//		 int total=0;  double avg=0.0;
//	
//		출력내용:
//		총점 : 30
//		평균 : 2.5
		
		 int [][] arr = {
		   { 1, 1, 1,},
		   { 2, 2, 2,},
		   { 3, 3, 3,},
		   { 4, 4, 4,} };
		 
		 int total = 0;
		 double avg = 0.0;
		 
		 // i 칸
//		 for(int i=0; i<arr[0].length; i++) { // 1층
//			 System.out.print(arr[0][i] + "\t"); // 1칸 2칸 3칸 출력
//		 }
		 
		 int data = 0;
		 
		 // ch 층
		 for(int ch=0; ch<arr.length; ch++) {
			 for(int i=0; i<arr[ch].length; i++) { // 1층
//				 System.out.print(arr[0][0] + "\t"); // 1칸 2칸 3칸 4칸 출력
				 arr[ch][i] += data; // arr[ch][i] = arr[ch][i] + data;
				 data++;
			 } 
//			 System.out.println();
//			 System.out.println(data); // 3+6+9+12=30
			 total += data; // 총점
		 }
		 avg = (double)total / (arr.length * arr[0].length); // (층의 갯수 * 칸의 갯수)
		 System.out.println("총점: " + total);
		 System.out.println("평균: " + avg);
		 
		 
	}

}
