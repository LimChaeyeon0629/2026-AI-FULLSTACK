package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001_lcy2 {

	public static void main(String[] args) {
//		1. 총점 구하기
//		2. 평균 구하기
//		3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
//		4. 평균이 95점이상이면 장학생
//		5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
//
//		학번 입력 > std111
//		국어점수 입력 > 100  
//		수학점수 입력 > 100
//		영어점수 입력 > 99
//		=================================================================================== 
//		학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
//		=================================================================================== 
//		std111   100   100   99   299   99.67   합격   수   장학생

		// 변수
		// 자료형: 기본형 & 참조형
		// 기본형 - 정수 : byte - short/char - int - long
		//		  실수 : float - double ( boolean은 타입캐스팅 불가능 )
		// 참조형 : String 주솟값 보관
		Scanner sc = new Scanner(System.in);
		int kor = -1, eng = -1, math = -1, total;
		String num = "", pnp = "불합격", i = "", lv = "가";
		double avg = -1;

//		0. 국어, 영어, 수학 ( 0 ~ 100만 입력받기 )  
		// 문자열 : next();
		// 정수형 : nextInt();
		// 실수형 : nextDouble();
		// 문자 : next().charAt();
		System.out.print("학번 입력: ");
		num = sc.next();
		
		for(; !(kor >= 0 && kor <= 100); ) {
			System.out.print("국어 점수 입력: ");
			kor = sc.nextInt();
			}
			
		for(; !(eng >= 0 && eng <= 100); ) {
			System.out.print("영어 점수 입력: ");
			eng = sc.nextInt();
			}
		
		for(; (math < 0 || math > 100); ) {
			System.out.print("수학 점수 입력: ");
			math = sc.nextInt();
			}
		
		// 처리
		// 연산자 - () → 값(++ -- + - * / %) → 비교 (> <) → 조건(&& || ?:) → 대입(=)
		// 제어문 - ( if / switch ) ( for / for while / do while )
		total = kor + eng + math;
		avg = (double)total/3;
		// avg = total/3.0;
			
		pnp = avg < 60 ? "불합격" : kor < 40 || eng < 40 || math < 40 ? "불합격" : "합격";
		
		i = avg < 95 ? "" : "장학생";
			
		switch ((int)avg/10) {
			case 9: case 10: lv = "수"; break;
			case 8: 		 lv = "우"; break;
			case 7: 		 lv = "미"; break;
			case 6: 		 lv = "양"; break;
		}
		
//		lv = avg >= 90 ? "수"
//				: avg >= 80 ? "우"
//						: avg >= 70 ? "미"
//								: avg >= 60 ? "양"
//										: "가";
									
		System.out.println("============================================"
						+ "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생"
						+ "============================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",
						num, kor, eng, math, total, avg, pnp, lv, i);
	}
}