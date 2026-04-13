package com.the703.basic008_ex;

public class ArrayEx008 {

	public static void main(String[] args) {
		// 양수 중에서 홀수의 합을 구하시오
		
		int [] su = { -3, 5, -1, 9, -7, 2, -11 };
		
		int hap = 0;
		
		for(int i = 0; i < su.length; i++) {
			if (su[i] > 0 && su[i]%2 == 1) { // su[i]가 양수이고 홀수
//				System.out.println(su[i]); // 5 9
				hap += su[i];
			}
		}
		System.out.println(hap);
			
	}

}
