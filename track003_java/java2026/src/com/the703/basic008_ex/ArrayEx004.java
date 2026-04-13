package com.the703.basic008_ex;

public class ArrayEx004 {

	public static void main(String[] args) {
//	    1. 배열명 : ch
//	    2. 값 넣기 : 'B' , 'a' , 'n' , 'a', 'n' , 'a'

		char [] ch = { 'B', 'a', 'n', 'a', 'n', 'a' };
		
//		System.out.println(ch.length); // 6개
//		System.out.println(ch[1]);
//		System.out.println(ch[3]);
//		System.out.println(ch[5]);
		
//	    3. ch 배열에서 a의 갯수 세기
		// ver-0 'B'가 소문자 a라면 카운트
		// ver-1 ch[0] 소문자 a라면 카운트
		// ver-2 if (ch[0] 소문자 a라면) { 카운트 }
		// ver-2 if (ch[0] 소문자 a라면) { count++; }
		
		int count = 0;
		
		for(int i = 1; i < ch.length; i++) {
//			System.out.printf("%c\t", ch[i]);
			if (ch[i] == 'a') {
				count++;
			}
		}
		
		
//	    4. 출력된화면 :  a의 갯수 3  
		System.out.println("a의 갯수: " + count);
		
		
	}

}
