package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
//		1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//		   정수를 하나 입력받아 다음 조건에 따라 성적을 출력하는 프로그램을 작성하시오.
//		    90점 이상 → "A 학점"
//		    80점 이상 → "B 학점"
//		    70점 이상 → "C 학점"
//		    그 외 → "F 학점"
//
		Scanner sc = new Scanner(System.in);
		int num = -1;
		
		System.out.print("점수 입력: ");
		num = sc.nextInt();
		
		if (num >= 90) {
			System.out.println("A학점");
		} else if (num >= 80) {
			System.out.println("B학점");
		} else if (num >= 70) {
			System.out.println("C학점");
		} else {
			System.out.println("F학점");
		}
		
//		2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//		   위의 문제를 switch 로
//		  
//		    int avg=0;
//		    Scanner scanner = new Scanner(System.in);
//		    System.out.print("평균입력 > ");  avg = scanner.nextInt();

		int avg = -1;
		
		System.out.print("평균 입력: ");
		avg = sc.nextInt();
		
		switch (avg/10) {
		
		case 10: case 9:
			System.out.println("A학점");
			break;
			
		case 8: 
			System.out.println("B학점");
			break;
			
		case 7:
			System.out.println("C학점");
			break;
			
		default:
			System.out.println("F학점");
		}
		
//		3. for, while, do while 버젼으로  문제를 풀으시오!  
//		    1 2 3
		
		// for
		for(int i = 1; i <= 3; i++) {
			System.out.print(i + " ");
		}
		
		// while
		System.out.println();
		int i = 1;
		while(i <= 3) {
			System.out.print(i + " ");
			i++;
		}
		
		// do while
		System.out.println();
		int j = 1;
		do {
			System.out.print(j + " ");
			j++;
		} while (j <= 3);
		
//
//		4. 이중 for를 이용해서 다음문제를 풀으시오.
//		  ★★★★
//		  ★★★★
//		  ★★★★
//		  ★★★★

		// ver-1
//		System.out.println();
//		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
//		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
//		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
//		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		
		// ver-2 (행)
//		System.out.println();
//		for(int l = 1; l <= 4; l++)
//		{
//			System.out.print("#");
//		}
//		System.out.println();
		
		// ver-3 (열)
		System.out.println();
		for (int k = 1; k <= 4; k++) {
			for (int l = 1; l <= 4; l++) {
				System.out.print("★");
			}
			System.out.println();
		}
		    
		
	}

}
