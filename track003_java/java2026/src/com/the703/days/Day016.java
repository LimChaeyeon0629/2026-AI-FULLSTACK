package com.the703.days;

public class Day016 {

	public static void main(String[] args) {
//		■2. java (5분)
//
//		1. new 연산자 이용하여 다차원배열만들기
//		2. for + length 이용해서 대입   
//		3. for + length 이용해서 출력 
//		   101   102   103
//		   104   105   106 
		
		int [][] arr = new int[2][3]; // 2층 3칸

		int data = 101;
		
		for(int j=0; j<arr.length; j++) {
			for(int i=0; i<arr[j].length; i++) {
				arr[j][i] = data;
				data += 1;
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
			
		}
	}

}
