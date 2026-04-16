package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx005 {

	public static int process_total(int kor, int eng, int math) { return kor+eng+math; } 
	
	public static float process_avg(int total) { return total/3; }

	public static String process_pass(float avg, int kor, int eng, int math) {
		String pass = "";
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
		for(int i=1; i<= avg/10; i++) {
			star += "*";
		}
		return star;

//		switch((int)avg/10) {
//		case 10: System.out.println("***********");
//		case 9: System.out.println("**********");
//		case 8: System.out.println("*********");
//		}
	}
	
	public static void line() {
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public static void process_show(String name, int kor, int eng, int math, int total, float avg, String pass, String jang, String star) {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n", name, kor, eng, math, total, avg, pass, jang, star);
		return;
	}

	
	
	public static void main(String[] args) {
		// 변수
		String name  = ""; 
		int kor, eng, math, total;
		float avg = 0.0f; 
		String pass = "";
		String jang = "";
		String star= "";  
		Scanner sc = new Scanner(System.in);

		// 입력
		System.out.println("이름 입력: ");
		name = sc.next();
		System.out.println("국어 입력: ");
		kor = sc.nextInt();
		System.out.println("영어 입력: ");
		eng = sc.nextInt();
		System.out.println("수학 입력: ");
		math = sc.nextInt();
	
		// 처리
		total = process_total(kor, eng, math); // 총점
		avg = process_avg(total); // 평균
		pass = process_pass(avg, kor, eng, math); // 3. pass 평균이 60 이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
		jang = process_scholar(avg); // 4. 평균이 95점 이상이면 장학생
		star = process_star(avg); // 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 

		// 출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t패논패\t장학생\t랭킹");
		line();
		process_show(name, kor, eng, math, total, avg, pass, jang, star);
		line();
		
	} // end main	
} // end class