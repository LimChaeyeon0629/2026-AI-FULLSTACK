package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {
//	    1. 배열명 : ch
//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'

		char [] ch = { 'B', 'a', 'n', 'a', 'n', 'a' };
		System.out.println(ch.length);
		
		// 대문자
//		System.out.println(ch[0]);
		
		// 소문자
//		System.out.println(ch[1]);
//		System.out.println(ch[2]);
//		System.out.println(ch[3]);
//		System.out.println(ch[4]);
//		System.out.println(ch[5]);
		
//	    3. ch 배열에서 대문자의 갯수카운트, 소문자의 갯수 카운트
		int count1 = 0, count2 = 0;
		for(int i = 0; i < ch.length; i++) {
			if(ch[i] >= 65 && ch[i] <= 90) { // 대문자
//				System.out.printf("%c\t", ch[i]);
				count1++;
			} else if (ch[i] >= 97 && ch[i] <= 122) { // 소문자
//				System.out.printf("%c\t", ch[i]);
				count2++;
			}
		}
		System.out.println("대문자: " + count1 + "개");
		System.out.println("소문자: " + count2 + "개");
	}
}
