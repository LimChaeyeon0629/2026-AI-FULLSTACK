package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx001 {
	public static void main(String[] args) {
		List list = null;
			 list = new ArrayList();
		
		List<String> colors = new ArrayList<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
//		colors.add("blue"); // 배열은 중복 가능
		
//		System.out.println(colors);
		
		System.out.println();
		for(int i=0; i<colors.size(); i++) {
			System.out.println(colors.get(i));
		}
		
		System.out.println();
		for ( String c : colors ) {
			System.out.println(c);
		}
	}
}

//다음과 같이 코드를 작성하시오.
// 1. ArrayList이용해서 colors 만들기
// 2. red, green, blue 데이터 추가
// 3. 출력
//
//red
//green
//blue