package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayNewEx001 {

	public static void main(String[] args) {
//		new 연산자 이용해서 배열만들기
//	    1. 배열명 : arr     
//	    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
//	       for+length 이용해보기
//	    3. for + length 로 출력
		
		double [] arr = new double[5];
		double data = 1.0; // 초기값 지정

		for (int i = 0; i < arr.length; i++) {
			arr[0] = data; // arr[0] arr[1] arr[2] arr[3] arr[4]
			data += 0.1;
			System.out.printf("%.1f\t", data);
		}
		
	}

}
