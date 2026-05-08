package com.the703.basic015;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream003 {
	public static void main(String[] args) {
		Integer [] ages = { 17, 21, 26, 45, 18 };
		
		Stream<Integer> sages = Arrays.stream(ages);
		//void java.util.function.Consumer.accept( T t )
		// (t) -> {}
//		sages.forEach( (t) -> {
//			System.out.println(t);
//		});
//		sages.forEach( t -> System.out.print(t) );
		
		//Ex1. 짝수만 출력
		//boolean java.util.function.Predicate.test( T t )
		// (t) -> { true/false 조건식 }
		sages.filter( t -> t%2 == 0 ) // 26 18
			 .forEach( t -> System.out.print(t + " ") );
//		sages.filter(t-> t%2==0).forEach( System.out::print );
		
		System.out.println();
		//Ex2. 평균값 처리 (숫자들을 더해서 연산) mapToInt
		// (t) -> { return }
		//int java.util.function.ToIntFunction.applyAsInt( T value )
		sages = Arrays.stream(ages); 			// 일회용
		double aver = sages.mapToInt(age->age) 	// IntStream로 변환
						   .average()			// 집계 연산)	max(최대), min(최소), sum(합), count(개수)
						   .orElse(0.0);		// 값 없으면 0.0으로 출력
		System.out.println(aver);
		
		//Ex3. 제일 나이가 많은 사람
		sages = Arrays.stream(ages);
		int max = sages.mapToInt(age->age)
					   .max()			// 집계 연산)	max(최대), min(최소), sum(합), count(개수)
					   .orElse(-1);		// 값 없으면 -1으로 출력
		System.out.println(max);
		
		//Ex4. 나이 정렬해서 리스트로
		/*
		List<Integer> list = Arrays.asList(ages);
		Stream<Integer> alist = list.stream();
		
				//void java.util.function.Consumer.accept( T t )
				//(t)->{}
		alist.sorted()
			 .collect(null)
			 .forEach( System.out::println );
		*/
		List<Integer> j = Arrays.stream(ages)
								.sorted()
								.collect(Collectors.toList());
		System.out.println("정렬된 리스트: " + j);
		
		//Ex5. 20살 이상만 필터링해서 리스트로 수집
//		sages.filter(t-> t>20)
		List<Integer> j1 = Arrays.stream(ages)
								 .filter(t-> t>=20) // boolean java.util.function.Predicate.test(T t)
								 .sorted()
								 .collect(Collectors.toList());
		System.out.println("정렬된 리스트: " + j1);
		
		// 내림차순
		List<Integer> j2 = Arrays.stream(ages)
							 	 .filter(t-> t>=20)
							 	 .sorted()
//							 	 .
							 	 .collect(Collectors.toList());
//		System.out.println("정렬된 리스트(내림차순): " + j2);
	}
}
