package com.the703.basic007_ex;

public class For2Ex008_2 {

	public static void main(String[] args) {
//		두 개의 주사위를 던졌을 때 눈의 합이 b이 되는
//		모든 경우의 수를 출력하는 프로그램을 작성하시오.
//		이중 for, 이중 while, 이중 do while
		
		
//		1 일때
//		if(1+1==6) { System.out.println(1+"+"+1+"="+6); }
//		if(1+2==6) { System.out.println(1+"+"+2+"="+6); }
//		if(1+3==6) { System.out.println(1+"+"+3+"="+6); }
//		if(1+4==6) { System.out.println(1+"+"+4+"="+6); }
//		if(1+5==6) { System.out.println(1+"+"+5+"="+6); }
//		if(1+6==6) { System.out.println(1+"+"+5+"="+6); }
		
//		for(int i = 1; i <= 6; i++) {
//			if(1+i==6) { System.out.println(1+"+"+i+"="+6); }
//		}
		
//		2 일때
//		if(2+1==6) { System.out.println(2+"+"+1+"="+6); }
//		if(2+2==6) { System.out.println(2+"+"+2+"="+6); }
//		if(2+3==6) { System.out.println(2+"+"+3+"="+6); }
//		if(2+4==6) { System.out.println(2+"+"+4+"="+6); }
//		if(2+5==6) { System.out.println(2+"+"+5+"="+6); }
//		if(2+6==6) { System.out.println(2+"+"+5+"="+6); }
		
//		for(int i = 2; i <= 6; i++) {
//			if(2+i==6) { System.out.println(2+"+"+i+"="+6);
//			}
//		}
		
		
		
		for(int ch = 1; ch <= 6; ch++)
		{
			for(int i = ch; i <= 6; i++) { if(ch+i==6) { System.out.println(ch+"+"+i+"="+6); } 
		}
		
		
//		for(int n = 6; n >= 1; n--) // 두번째 주사위 n
//		{
//			for(int i = n; i <= 6; i++) // 첫번째 주사위 i
//			{
//				if(n+i==6) { System.out.println(n+"+"+i+"="+6); }
//			}
//		}
		
		
		
		// for
//		for(int i = 1; i <= 6; i++) {
//			for(int j = 6; j >= 1; j--) {
//				if(i+j == 6) {
//					System.out.println(i+ "+" + j + "=" + 6);
//				}
//			}
//		}
//
//			
//			
//		// while
//		int i = 1, j = 6;
//		
//		while(i <= 6)
//		{
//			while(j >= 1) {
//				if(i+j == 6) {
//					System.out.println(i+ "+" + j + "=" + 6);
//				}
//			}
//			j--;
//		}
//		i++;
//		
//		
//		
//		// do while
//		int i1 = 1, j1 = 6;
//		
//		do {
//			do {
//				if(i1+j1 == 6) { System.out.println(i1+ "+" + j1 + "=" + 6); }
//			j1--;
//			}
//			while(j1 >= 1);
//		
//		i1++;
//		}
//		while(i1 <= 6);
//
		}
	}
}