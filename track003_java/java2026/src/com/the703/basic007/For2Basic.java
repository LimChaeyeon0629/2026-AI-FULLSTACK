package com.the703.basic007;

public class For2Basic {

	public static void main(String[] args) {
//		1234
//		1234
//		1234
//		1234
		
		// ver-1
		System.out.println(1 + "층");
		System.out.print(1); System.out.print(2); System.out.print(3); System.out.println();
		
		System.out.println(2 + "층");
		System.out.print(1); System.out.print(2); System.out.print(3); System.out.println();
		
		
		System.out.println();
		// ver-2 각 칸 정리 for 정리 	{영역} {변수} for(시작; 종료; 변화)
		System.out.println(1 + "층");
		for(int kan = 1; kan <= 3; kan++)
		{ System.out.print(kan); }
		System.out.println();
		
		System.out.println(2 + "층");
		for(int kan = 1; kan <= 3; kan++)
		{ System.out.print(kan); }
		System.out.println();
		
		
		System.out.println();
		// ver-2 각 층 정리 for 정리
		for(int ch = 1; ch <= 2; ch++)
		{ 
			System.out.println(ch + "층");
			for(int kan = 1; kan <= 3; kan++)
			{ System.out.print(kan); }
			System.out.println();			
		}
		
		
		
//		for(int i = 1; i <= 4; i++) {
//			System.out.print(i); 			// 1234 4번 반복
//			System.out.print(i); 			// 1234 4번 반복
//			System.out.print(i); 			// 1234 4번 반복
//			System.out.print(i); 			// 1234 4번 반복
//		}

//		for(int i = 1; i <= 4; i++) {
//			for(int j = 1; j <= 4; j++) {
//				System.out.print(j);
//				if(j == 4) {
//					System.out.println();
//				}
//			}
//		}
		
	}

}