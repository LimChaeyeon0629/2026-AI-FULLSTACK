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
		
		
		// for
		for(int ch = 1; ch <= 6; ch++) {
			for(int i = ch; i <= 6; i++) { 
				if(ch+i==6) { System.out.println(ch + "+" + i + "=" + 6); } 
			}
		}
		
		// while
		System.out.println();
		int ch = 1;
		
		while(ch <= 6) {
			int i = ch;
			
			while(i <= 6) {
				if(ch+i==6) { System.out.println(ch + "+" + i + "=" + 6); } i++;
			} ch++;
		}
		
		// do while
		System.out.println();
		int ch1 = 1;
		
		do {
			int i = ch1;
			
			do {
				if(ch1+i==6) { System.out.println(ch1 + "+" + i + "=" + 6); } i++;
			} while (i <= 6); ch1++;
		} while(ch1 <= 6);
		
		
//		// for
//		System.out.println();
//		for(int i = 1; i <= 6; i++) {
//			for(int j = 6; j >= 1; j--) {
//				if(i+j == 6) { System.out.println(i + "+" + j + "=" + 6); }
//			}
//		}
//
//			
//			
//		// while
//		System.out.println();
//		int i = 1;
//		
//		while(i <= 6) {
//			int j = 6;
//			
//			while(j >= 1) {
//				if(i+j == 6) { System.out.println(i + "+" + j + "=" + 6); } j--;
//			} i++;
//		}
//		
//		
//		
//		// do while
//		System.out.println();
//		int k = 1;
//		
//		do {
//			int l = 6;
//			
//			do {
//				if(k+l == 6) { System.out.println(k+ "+" + l + "=" + 6); } l--;
//			} while(l >= 1); k++;
//		} while(k <= 6);

	}
}