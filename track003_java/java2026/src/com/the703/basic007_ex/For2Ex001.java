package com.the703.basic007_ex;

public class For2Ex001 {

	public static void main(String[] args) {
//		####
//		####
//		####
//		####
		
		// 눈에 보이는 그대로
		System.out.println(1 + "층");
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		
		System.out.println(2 + "층");
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		
		System.out.println(3 + "층");
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		
		System.out.println(4 + "층");
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		
		
		
		System.out.println();
		// 칸 정리 (행)
		System.out.println(1 + "층");
		for (int i = 1; i <= 4; i++)
		{ System.out.print("#"); }
		System.out.println();

		System.out.println(2 + "층");
		for (int i = 1; i <= 4; i++)
		{ System.out.print("#"); }
		System.out.println();
		
		System.out.println(3 + "층");
		for (int i = 1; i <= 4; i++)
		{ System.out.print("#"); }
		System.out.println();
		
		System.out.println(4 + "층");
		for (int i = 1; i <= 4; i++)
		{ System.out.print("#"); }
		System.out.println();
		
		
		
		System.out.println();
		// 층 정리 (열)
		for (int j = 1; j <= 4; j++)
		{ for (int i = 1; i <= 4; i++)
		{ System.out.print("#"); }
		System.out.println(); }
	}

}
