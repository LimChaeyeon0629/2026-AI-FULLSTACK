package com.the703.basic014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
	public static void main(String[] args) {
		// ArrayList와 LinkedList의 차이점을 설명하세요.
		// ArrayList  : 배열 기반으로 동작, 				 검색속도 빠름, 삽입/삭제 느림
		// LinkedList : 노드 기반 연결 구조(주소 사라지면 연결), 삽입/삭제 빠름, 검색속도 느림
		
		int size = 100000;

		//1. Array  List 테스트 → 검색할 때 사용
		List<Integer> arrayList = new ArrayList<>();
		long start = System.currentTimeMillis(); //####
		//////////////////////////////////////////////////
		for(int i=0; i<size; i++) { arrayList.add(i); }
		//////////////////////////////////////////////////
		long end = System.currentTimeMillis(); //####
		System.out.println("ArrayList 삽입시간: " +(end-start) + "ms");
		
		
		//2. Linked List 테스트 → 삽입/삭제할 때 사용
		List<Integer> linkedList = new LinkedList<>();
		start = System.currentTimeMillis(); //####
		//////////////////////////////////////////////////
		for(int i=0; i<size; i++) { linkedList.add(i); }
		//////////////////////////////////////////////////
		end = System.currentTimeMillis(); //####
		System.out.println("LinkedList 삽입시간: " +(end-start) + "ms");
		
		
		//3 중간삽입 테스트
		start = System.currentTimeMillis(); //####
		//////////////////////////////////////////////////
		for(int i=0; i<size; i++) { arrayList.add( size/2, i ); }
		//////////////////////////////////////////////////
		end = System.currentTimeMillis(); //####
		System.out.println("ArrayList 중간삽입: " +(end-start) + "ms");
		
		start = System.currentTimeMillis(); //####
		//////////////////////////////////////////////////
		for(int i=0; i<size; i++) { linkedList.add( size/2, i ); }
		//////////////////////////////////////////////////
		end = System.currentTimeMillis(); //####
		System.out.println("LinkedList 중간삽입: " +(end-start) + "ms");
	}
}