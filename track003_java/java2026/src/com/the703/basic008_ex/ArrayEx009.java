package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayEx009 {

	public static void main(String[] args) {
		
		// 1. new를 이용하여 문자열 배열 ch 52개 만드시오
		// 2. 대문자 A~Z, a~z까지 52개의 데이터를 for을 이용하여 ch배열에 데이터를 대입하시오
		// 3. for문을 이용하여 모음의 갯수를 구하시오
		// >> 모음 : a, e, i, o, u, A, E, I, O, U
		
		// 변수
		char [] ch = new char[52];
		
		char data = 'A'; // 초기값 지정
		int count = 0;
		
		
		// 입력 (ch[i])
		for (int i = 0; i < ch.length; i++) {
			ch[i] = data;
			data += 1;
			if (data >= '[' && data <= '`') { data = 97; }
		}
		System.out.println(Arrays.toString(ch));
			
		
		// 처리 (count)
		for (int i = 0; i < ch.length; i++) { // index 0 ~ 51
			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' ||
				ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
//				System.out.println(data);
				count++;
			}
		}
		
		
		// 출력
		System.out.println(count + "개");
		
		
		
		
		
		
		/*
		for (int i = 0; i < ch.length; i++) { 
			if (data == 'a' || data == 'e' || data == 'i' || data == 'o' || data == 'u') {
//				System.out.println(data);
				count++;
			} else if (data == 'A' || data == 'E' || data == 'I' || data == 'O' || data == 'U') {
//				System.out.println(data);
				count++;
			}
		}
		*/ 

	}

}
