package com.the703.basic008;

import java.util.Arrays;

public class Array2002 {

	public static void main(String[] args) {
		// 1. 값을 알고 있는 경우
		int [][] arr2 = {
				{1,2,3}, //00 01 02
				{4,5,6}  //10 11 12
		};
		
		// 2. 값을 모르는 경우
		int [][] arr21 = new int[2][3];
		// new 메모리 빌려오기 int (자료형) 2층 3칸
		
//		arr21[0][0] = 10;	arr21[0][1] = 20;	arr21[0][2] = 30;
//		arr21[1][0] = 40;	arr21[1][1] = 50;	arr21[1][2] = 60; // for문으로 값 확인

//		for(int kan=0; kan<arr21.length; kan++) {
//			System.out.println(Arrays.toString(arr21[kan]));
//		}
		
		// ver-2
		int data = 10;
		arr2[0][0] = data; 	data+=10;
		arr2[0][1] = data; 	data+=10;
		arr2[0][2] = data; 	data+=10;

		arr2[1][0] = data; 	data+=10;
		arr2[1][1] = data; 	data+=10;
		arr2[1][2] = data; 	data+=10;
		
		// ver-3
		for(int kan=0; kan<arr21[0].length; kan++) { arr2[0][kan] = data; 	data+=10; }
		for(int kan=0; kan<arr21[1].length; kan++) { arr2[1][kan] = data; 	data+=10; }

		// ver-4
		for(int ch=0; ch<arr21.length; ch++) { // 배열명.length 몇 층 (0 1)
			for(int kan=0; kan<arr21[ch].length; kan++) { // 배열명[층].length 몇 칸 (0 1 2)
				arr2[ch][kan] = data;
				data+=10;
				System.out.print(arr21[ch][kan] + "\t");
			}
			// 끝나고 해야할 일
			System.out.println();
		}
		
		// ver-4
		System.out.println();
		for(int ch=0; ch<arr21.length; ch++) { // 2-1 배열의 층수
			for(int kan=0; kan<arr21[ch].length; kan++) { // 2-2 배열[층]의 칸수
				System.out.print(arr21[ch][kan] + "\t");
			}
			// 한 층이 끝나면 해야 할 일
			System.out.println();
		}
		
	}

}
