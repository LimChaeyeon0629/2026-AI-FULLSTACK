package com.the703.basic015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream001 {
	public static void main(String[] args) {
		Integer [] arr = { 1, 2, 3, 4, 5 }; 		// 배열
		List<Integer> list = Arrays.asList(arr); 	// 리스트
		
//		System.out.println( arr ); // 주소값
		System.out.println( Arrays.toString(arr) );
		System.out.println(list);
		
		System.out.println();
		//1. Stream (흐름)
		Stream<Integer> sarr  = Arrays.stream(arr);  // Stream<Integer> ← 리턴값
		Stream<Integer> sarr1  = Arrays.stream(arr); // Stream<Integer>
		Stream<Integer> sarr2  = Arrays.stream(arr); // Stream<Integer>
		Stream<Integer> slist = list.stream(); 		 // Stream<Integer>
		Stream<Integer> slist1 = list.stream(); 		 // Stream<Integer>
		Stream<Integer> slist2 = list.stream(); 		 // Stream<Integer>
		
		//2. 처리
		// (t) -> { syso };
		// void java.util.function.Consumer.accept( T t )
		sarr.forEach( (t) -> {
			System.out.println(t);
		});
		//2-1. 람다식
		sarr1.forEach( t -> System.out.print(t) );
		//2-2. 참조형
		sarr2.forEach( System.out::print );
		
		System.out.println("\n\n");
		slist.forEach( (t) -> {
			System.out.println(t);
		});
		slist1.forEach( t -> System.out.print(t) ); // slist1 람다식
		slist2.forEach( System.out::print );		// slist2 참조형
		
	}
}

/*
Stream - 데이터 종류에 상관없이 같은 방식으로 처리



*/