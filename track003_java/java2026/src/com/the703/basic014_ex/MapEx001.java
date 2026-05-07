package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("피구왕", "통키");
		map.put("제빵왕", "김탁구");
		map.put("요리왕", "비룡");
		
		System.out.println("==============================\n"
				+ "KING   NAME\n"
				+ "==============================\n"
				+ "피구왕   통키\n"
				+ "---------------------\n"
				+ "제빵왕   김탁구\n"
				+ "---------------------\n"
				+ "요리왕   비룡\n"
				+ "---------------------\n"
				+ "KING의 정보를 제공중입니다");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = sc.next();
		
//		System.out.println( map.containsKey(name) ? 
//				"ㅁ" + name + ": " + map.get(name) : "찾으시는 왕이 없어요.");
		
//		향상된 for 
//		for( Entry<String, String> e : map.entrySet()) {
//			System.out.println("ㅁ" + e.getValue());
//		}
		
//		if(name.equals("피구왕")) {
//			for(int i=0; i<map.size(); i++) {
//				System.out.println("ㅁ" + map.get(name));
//				break;
//			}
//		} else if(name.equals("제빵왕")) {
//				for(int i=0; i<map.size(); i++) {
//					System.out.println("ㅁ" + map.get(name));
//					break;
//				}
//		} else if(name.equals("요리왕")) {
//			for(int i=0; i<map.size(); i++) {
//				System.out.println("ㅁ" + map.get(name));
//				break;
//			}
//		}
		
	}
}


//1. MAP 만들기
//KEY   VALUE
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//
//Map<String, String> map = new HashMap<>();
//
//2 다음과 같이 문제풀기
//2-1. 다음과 같이 출력
//2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//KING   NAME
//==============================
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//---------------------
//KING의 정보를 제공중입니다
//이름을 입력하세요> 제빵왕
//
//ㅁ제빵왕 : 김탁구