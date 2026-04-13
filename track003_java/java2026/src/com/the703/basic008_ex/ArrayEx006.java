package com.the703.basic008_ex;

public class ArrayEx006 {

	public static void main(String[] args) {
		// 대소문자 바꿔서 출력
		
		char [] ch = { 'B', 'a', 'n', 'a', 'n', 'a' };
		
		for (int i = 0; i <= ch.length; i++) {
			if (ch[i] >= 65 && ch[i] <= 90) { // ch[i] >= 'a'
				// 소문자로 출력
				ch[i] += 32;
				System.out.printf("%c\t", ch[i]);
			} else if (ch[i] >= 97 && ch[i] <= 122) { // ch[i] >= 'A'
				// 대문자로 출력
				ch[i] -= 32;
				System.out.printf("%c\t", ch[i]);
			}
		}
	}

}
