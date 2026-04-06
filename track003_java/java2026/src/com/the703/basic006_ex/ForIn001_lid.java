package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_lid {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 변수
		int kor = -1, eng = -1, math = -1, total = -1;
		double avg;
		String no = "", pass = "", level = "", jang = "";
		
		// 입력
		System.out.println("학번 입력>");
		no = sc.next();
		
		
		for (;;) {
		    System.out.println("국어점수 입력>");
		    kor = sc.nextInt();
		    if (kor >= 0 && kor <= 100) break;
		    System.out.println("다시 입력하세요");
		    }
		    
		    
		for (;;) {
		    System.out.println("영어점수 입력>");
		    eng = sc.nextInt();
		    if (eng >= 0 && eng <= 100) break;
		    System.out.println("다시 입력하세요");
		    }
		    
		for (;;) {
		    System.out.println("수학점수 입력>");
		    math = sc.nextInt();
		    if (math >= 0 && math <= 100) break;
		    System.out.println("다시 입력하세요");
		    }
		    
		    
		
		
		// 처리
		total = kor + eng + math;
		avg = total / 3f;
		
		pass = avg >=60 && kor >= 40 && eng >= 40 && math >= 40 ? "합격" : "불합격" ;
		
		level = avg >= 90 ? "수"
			:   avg >= 80 ? "우"
			:	avg >= 70 ? "미"
			:	avg >= 60 ? "양" : "가" ;
		
		jang = avg >= 95 ? "장학생" : "장학생 아니다" ;
		
		
		
		// 출력
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.printf("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s", no, kor, eng, math, total, avg, pass, level, jang);
	}

}


/*
연습문제1)   
패키지명 : com.company.java004_ex
클래스명 :   ForIn001
출력내용 :  성적처리 프로그램입니다.

0. 국어,영어, 수학(0~100만입력받기)  
1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100  
수학점수 입력 > 100
영어점수 입력 > 99
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생

*/