package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex001 {

	public static void main(String[] args) {
//		   int[][] arr2={{100,200,300},{400,500,600}};
//
//		   이중for+ length 이용해서 출력하기 

		int [][] arr2 = { {100, 200, 300}, {400, 500, 600} };
		
//		for(int kan=0; kan < arr2.length; kan++) {
//			System.out.println(Arrays.toString(arr2[kan]));
//		}

		// 1층
//		for(int kan=0; kan<arr2[0].length; kan++) { System.out.print(arr2[0][kan] + "\t"); }
		// 2층
//		for(int kan=0; kan<arr2[0].length; kan++) { System.out.print(arr2[0][kan] + "\t"); }

		
		for(int ch=0; ch<arr2.length; ch++) {
			for(int kan=0; kan<arr2[ch].length; kan++) {
//				System.out.print(arr2[ch][kan] + "\t");
				System.out.printf("%d\t", arr2[ch][kan]);
			}
			System.out.println();
		}
	}

}
