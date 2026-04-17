package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx006 {
	

	public static int process_total(int kor, int eng, int math) { // 총점
		return kor+eng+math;
	}
	
	public static float process_avg(int total) { // 평균
		return total/3;
	}
		
	public static String process_pass(float avg, int kor, int eng, int math) {
		String [] pass = new String[] { "", "", "" };
		pass = avg <= 60 ? "불합격" : kor > 40 && eng > 40 && math > 40 ? "합격" : "불합격";
		return pass;
	}
	
	public static String process_scholar(float avg) {
		String scholar = "";
		scholar = avg >= 95 ? "장학생" : "";
		return scholar;
	}
	
	public static String process_star(float avg) {
		String star = "";
		for(int j=1; j<= avg/10; j++) {
			star += "*";
		}
		return star;
	}
	
	public static void line() {
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public static void process_show(String[] name, int[] kor, int[] eng, int[] math, int[] total, float[] avg, String[] pass, String[] scholar, String[] star) {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n", name, kor, eng, math, total, avg, pass, scholar, star);
		return;
	}

	
	
	public static void main(String[] args) {
		// 변수
		int size = 3;
		int [] arr = new int[size];
	    String [] name = { "", "", "" };
	    int [] kor = new int[size];   
	    int [] eng = new int[size];
	    int [] math = new int[size];
	    
	    int [] total = new int[size]; // 총점
	    float [] avg = new float[size]; // 평균 0.0f
		String [] pass = new String[] { "", "", "" }; // 합불합
		String [] scholar = new String[] { "", "", "" }; // 장학생 or ""
		String [] star = new String[] { "", "", "" };
		Scanner sc = new Scanner(System.in);

		// 입력
		for(int i=0; i<arr.length; i++) { // 0 1 2
			System.out.println(i + "번째 학생 정보 입력");
			System.out.println("이름 입력: "); name[i] = sc.next();
			System.out.println("국어 입력: "); kor[i] = sc.nextInt();
			System.out.println("영어 입력: "); eng[i] = sc.nextInt();
			System.out.println("수학 입력: "); math[i] = sc.nextInt();
		}
	
		// 처리
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t패논패\t장학생\t랭킹");
		line();

		for(int i=0; i<arr.length; i++) { // 0 1 2
			total[i] = process_total(kor[i], eng[i], math[i]); // 총점
			avg[i] = process_avg(total[i]); // 평균
			pass[i] = process_pass(avg[i], kor[i], eng[i], math[i]); // 패논패
			scholar[i] = process_scholar(avg[i]); // 장학생
			star[i] = process_star(avg[i]); // 별표
			
			process_show(name, kor, eng, math, total, avg, scholar, star);
//			line();
		}

	} // end main	
} // end class


//		::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//		이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
//		--------------------------------------------------------------------------------------------
//		아이언맨   100   100   100   300    100.0    합격      장학생   **********
//		아이언맨   100   100   100   300    100.0    합격      장학생   **********
//		아이언맨   100   100   100   300    100.0    합격      장학생   **********
//		--------------------------------------------------------------------------------------------