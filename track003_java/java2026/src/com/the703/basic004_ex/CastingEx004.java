package com.the703.basic004_ex;

public class CastingEx004 {

	public static void main(String[] args) {
		
		  short sh1 = 1; 
		  short sh2 = 2;
		  short result = (short)(sh1 + sh2); // short ( int(1) + int(2) )
		  
		  // int 보다 작은 자료형 : byte, short / char
		  // 작은 정수형끼리 연산 시 내부적으로 자동으로 int로 변환해서 계산
		  
		  System.out.println(sh1 + "\t" + sh2 + "\t" + result);
		  
	}

}
