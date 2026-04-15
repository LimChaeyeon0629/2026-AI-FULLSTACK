package com.the703.basic008_ex;

public class Array2Ex002 {

	public static void main(String[] args) {
//		1. new 연산자 이용하여 다차원배열만들기
//		2. for + length 이용해서 대입   
//		3. for + length 이용해서 출력 
//		   101   102   103
//		   104   105   106
		
		int [][] arr = new int[2][3]; // 2층 3칸 지정
		
		int data = 101;
//		arr[0][0] = data++;		arr[0][1] = data++;		arr[0][2] = data++;
//		arr[1][0] = data++;		arr[1][1] = data++;		arr[1][2] = data++;

		
		
		// ver-1
//		for(int i=0; i<arr[0].length; i++) { // 1층
//			arr[0][i] = data;
//			data += 1;
//			System.out.print(arr[0][i] + "\t"); // i칸
//		}
//		
//		System.out.println();
//		for(int i=0; i<arr[1].length; i++) { // 2층
//			arr[1][i] = data;
//			data += 1;
//			System.out.print(arr[1][i] + "\t"); // i칸
//		}
		
		// ver-2
//		for(int ch=0; ch<arr.length; ch++) { // 1층~2층
//			for(int i=0; i<arr[1].length; i++) {
//				arr[ch][i] = data;
//				data += 1;
//				System.out.print(arr[ch][i] + "\t"); // i칸
//			}
//			System.out.println();
//		}
		
		// ver-3
		for(int ch=0; ch<arr.length; ch++) { // 1층~2층 (int ch=0; ch<arr.length; ch++, data = 201)
			for(int i=0; i<arr[ch].length; i++) {
				arr[ch][i] = data;
				data += 1;
				System.out.printf("%d\t", arr[ch][i]); // i칸
			}
			System.out.println();
			// data = 201; 
		}
	}

}
