package com.the703.basic015;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004 {
	public static void main(String[] args) {
		// (t)->{}	★ accept 받는용도
		// void java.util.function.Consumer.accept( T t )
		Consumer<String> consumer = (t) -> {
			System.out.println("Hello :) " + t);
		};
		
		// ver-1 람다식 정리
		Consumer<String> consumer1 = t -> System.out.println("Hello :) " + t);
		// ver-2 참조형 표현
		Consumer<String> consumer2 = System.out::println;

		consumer2.accept("lambda");
		consumer2.accept("뚜비");
		

		
		// ()->{return}	★ get 주는용도
		// T java.util.function.Supplier.get()
		Supplier<String> supplier = () -> {
			return "Hello~";
		};
		
		// ver-1 람다식 정리
		Supplier<String> supplier1 = () -> "Hello~~";
		
		System.out.println(supplier1.get());
		
		
		
		// (t) -> { return true; } 	★ test 판단용도
		// boolean java.util.function.Predicate.test( T t )
		Predicate<Integer> predicate = (t) -> {
			return t<0; // true
		};
		
		// ver-1 람다식 정리
		Predicate<Integer> predicate1 = t -> t<0;
		
		System.out.println(predicate.test(10));
		System.out.println(predicate.test(-10));
		
		

		// (t) -> { return }
//		R java.util.function.Function.apply( T t )
		Function<String, Integer> function = (t) -> {
			return Integer.parseInt(t);
		};

		// ver-1 람다식 정리
		Function<String, Integer> function1 = t -> Integer.parseInt(t);
		
		System.out.println( function1.apply("10") + 3 );	// 13
		
		
		
		// (int left, int right) -> { return }
//		int java.util.function.IntBinaryOperator.applyAsInt( int left, int right )
		IntBinaryOperator operator = (left, right) -> {
			return left>right ? left : right;
		};
		
		// ver-1 람다식 정리
		IntBinaryOperator operator1 = (left, right) -> left>right ? left : right;
		
		System.out.println( operator1.applyAsInt(10, 3) );
		System.out.println( operator1.applyAsInt(3, 10) );
	}
}

/*
자바의 api 함수형인터페이스
1.   Consumer  받는용도 
2.   Supplier  제공용도   
3.   Predicate 판단용도
4.   Function  처리용도
5.   Operator  연산용도
*/