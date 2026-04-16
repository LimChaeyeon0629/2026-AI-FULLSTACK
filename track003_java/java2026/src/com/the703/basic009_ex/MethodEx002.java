package com.the703.basic009_ex;

public class MethodEx002 {

	// 1.		 리턴값 메서드명 (파라미터: 재료 ★)
	
	//			 		hello("고양이")
	public static void hello(String name) { // String name = "고양이"
		System.out.println(name);
	}
	
	//					icecream(1)
	public static void icecream(int num) {
		System.out.println(num);
	}
	
	// 			  리턴값 마법상자이름(파라미터 재료)
	public static void info(String str, int score) {
		System.out.printf("%s 최종 %d점\n", str, score);
	}
	
	
	////////////////////////////////////////////
	public static void main(String[] args) {
		hello("고양이");
		hello("강아지");
		icecream(1);
		icecream(2);
		info("sally", 10); // sally 최종 10점
		info("alpha", 9); // alpha 최종 9점
	}
	////////////////////////////////////////////

}
