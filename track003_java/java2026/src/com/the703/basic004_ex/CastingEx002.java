package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx002 {

	public static void main(String[] args) {
		
		// 변수
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total, lv;
		double avg;
		
		// 입력
		System.out.print("국어: ");
		kor = (int)sc.nextInt();
		System.out.print("영어: ");
		eng = (int)sc.nextInt();
		System.out.print("수학: ");
		math = (int)sc.nextInt();
		
		// 처리
		total = kor + eng + math; // 정수 = 정수
		avg = total / 3.0d; // double = 정수/실수(double)
		avg = total / 3f; // double = 정수/실수(float)
		avg = (double)total / 3; // (double)실수/실수
		lv = (int)avg / 10; // (int)99.98/10 = (int)9.998 = 9
		
		// 출력
		System.out.println("국어" + "\t" + "영어" + "\t"+ "수학" +
							"\t" + "총점" + "\t" + "평균" + "\t" + "레벨");
		System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%d", kor, eng, math, total, avg, lv);
	}

}
