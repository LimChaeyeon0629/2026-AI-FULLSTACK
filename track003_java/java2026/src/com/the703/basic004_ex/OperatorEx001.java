package com.the703.basic004_ex;

public class OperatorEx001 {

	public static void main(String[] args) {
		// () → 산술연산 → 비교(> <) → 조건(&& || ?:) → 대입(=)
		
	    int a=3, b=10;
	    System.out.println(  b+=10 - a-- );
	    // 1) a-- (; 끝나고 계산 → 맨 마지막에)  // a=3, b=10
	    // 2) 10 - a = 7
	    // 3) b+=10 	→ 	b + 7 = 17
	    // 4) ; 후							// a=2, b=17
	    System.out.println(  a+=5 ); // 2+5 = 7
	    System.out.println(  a>=10 || a<0 && a>3);
	    // 1) a >= 10 			→	7 >= 10 	→ 	false
	    // 2) a < 0 && a > 3	→	false && 	→	false
	    // 3) false || false 	→	false
	}

}
