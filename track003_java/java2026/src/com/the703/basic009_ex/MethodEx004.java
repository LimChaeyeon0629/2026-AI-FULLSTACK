package com.the703.basic009_ex;

public class MethodEx004 {
	
	public static int return_num() { return 1; } // 1. 내가 좋아하는 숫자
	
	public static double return_float() { // 2. 10/3.0을 실수로 표현
//		System.out.printf("%d.2f", 10/3.0);
		double float1 = 10/3.0;
		return float1; } 
	
	public static String mycolor() { return "PURPLE"; } // 3. BEST COLOR
	
	public static String jangsu() { // 4. 장수돌침대 별이
		String star = "";
		for(int i = 1; i <= 5; i++) {
			star += "★";
		}
		return star;
	}
	
	public static int myadd(int num1, int num2) { return num1+num2; } // 5. 10+20
	
	public static String myban(char ch) { // 6. 반(노랑조/주황조)
		if (ch == 'A') { return "노랑조"; }
		else if (ch == 'B') { return "주황조"; }
		else { return ""; }
	}
	
	public static String stdId(int id) { return "G" + id; } // 7. 당신의 학번은?
	
	public static int stdAvg(int avg) { // 8. 당신의 평균은?
		if(avg>=90) { return 'A'; }
		else if(avg>=80) { return 'B'; }
		else if(avg>=70) { return 'C'; }
		else { return 'D'; }
	}
	

	public static void main(String[] args) {
		System.out.println("1. 내가 좋아하는 숫자: " + return_num()); // 1을 결과값으로 줌
		System.out.println("2. 10/3.0을 실수로 표현: " + return_float()); // 3.3333을 결과값으로 줌
		System.out.println("3. BEST COLOR: " + mycolor()); // PURPLE을 결과값으로 줌
		System.out.println("4. 장수돌침대 별이: " + jangsu()); // ★★★★★을 결과값으로 줌  
		System.out.println("5. 10+20= " + myadd(10,20)); // 두숫자를 더한값을 결과값으로 줌  
		System.out.println("6. 반(노랑조/주황조)= " + myban('B')); 	// A이면 노랑조, B이면 주황조
		System.out.println("7. 당신의 학번은? " + stdId(1111)); // G하고 넣어준 학번 나오게
		System.out.println("8. 당신의 평균은? " + stdAvg(88)); // 90점이상이면 A, 80점이상이면 B, 70점이상이면 C, 아니라면 D
	}

}

//		출력결과 :
//		1. 내가 좋아하는 숫자    : 1
//		2. 10/3.0을 실수로 표현 : 3.3333
//		3. BEST COLOR        : PURPLE
//		4. 장수돌침대 별이       : ★★★★★
//		5. 10+20= 30
//		6. 반(노랑조/주황조)= 나는 노랑조
//		7. 당신의 학번은? G1111
//		8. 당신의 평균은? B