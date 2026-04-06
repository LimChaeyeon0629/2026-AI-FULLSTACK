package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001khm {
	public static void main(String[] args) {
		// 변수
		Scanner scanner = new Scanner(System.in);
		int kor=-1, eng=-1, mat=-1, total=-1;
		String stdid="", pass="", level="", jang="";
		double avg=-1;
		
		// 입력
		System.out.print("학번 입력 > "); stdid = scanner.next();
		
		for(;;) {
			System.out.print("국어점수 입력 > "); kor = scanner.nextInt();
			if( kor>=0 && kor<=100 ) { break; }
			else { System.out.println("다시입력해주세요."); }			
		}
		
		for(;;) {	
			System.out.print("영어점수 입력 > "); eng = scanner.nextInt();
			if( eng>=0 && eng<=100 ) { break; }			
			else { System.out.println("다시입력해주세요."); }
		}
		
		for(;;) {
			System.out.print("수학점수 입력 > "); mat = scanner.nextInt();
			if( mat>=0 && mat<=100 ) { break; }			
			else { System.out.println("다시입력해주세요."); }
		}
		
		// 처리
		total = kor + eng + mat;
		avg = total/3.0;
		
		pass = avg<60?"불합격" 
				: kor >=40 && eng>=40 && mat>=40 ? "합격":"불합격";
		
		if(avg >=95) { jang="장학생"; }
		
		level = avg >= 90 ? "수"
			:	avg >= 90 ? "우"
			:	avg >= 90 ? "미"
			:	avg >= 90 ? "양" : "가";			
		
		// 출력		
		System.out.println("=====================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=====================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s"
				,stdid,kor,eng,mat,total,avg,pass,level,jang);	

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
국어점수 입력 > 100	 국어점수는 0~100 사이만 입력받게 for(;;){}
수학점수 입력 > 100	 영어점수는 0~100 사이만 입력받게 for(;;){}
영어점수 입력 > 99	 수학점수는 0~100 사이만 입력받게 for(;;){}
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/