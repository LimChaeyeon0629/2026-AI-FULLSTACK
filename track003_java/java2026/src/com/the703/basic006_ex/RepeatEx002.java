package com.the703.basic006_ex;

public class RepeatEx002 {

	public static void main(String[] args) {
//		for , while , do while 3가지 버젼으로 
//		1~10까지 3의 배수의 합 : 18
		int hap = 0, hap1 = 0, hap2 = 0;
		
//		3 6 9 18
//		0 + 3 = 3 // hap + i = hap
//		3 + 6 = 9 // hap + i = hap
//		9 + 9 = 18 // hap + i = hap
		
//		ver-1 말로 풀어쓰기
//		만약 1이 3의 배수의 누적합
//		만약 2이 3의 배수의 누적합
//		만약 3이 3의 배수의 누적합
//		
//		ver-2 구조 - 제어, 반복
//		if (만약 1이 3의 배수의) { 누적합 }
//		if (만약 2이 3의 배수의) { 누적합 }
//		if (만약 3이 3의 배수의) { 누적합 }
//	
//		ver-3 코드
//		int hap = 0;
//		if (1%3 == 0) { hap += 1; }
//		if (2%3 == 0) { hap += 2; }
//		if (3%3 == 0) { hap += 3; }
//					 ↓
//		if (i%3 == 0) { hap += i; }
		
		// for
		System.out.println("for");
		for(int i = 1; i <= 10; i++) {
			if(i%3 == 0) {
				hap += i;
			}
		}
		System.out.println(hap);
		
		// while
		System.out.println("\nwhile");
		int i = 1;
		
		while ( i <= 10 ) { 	// i = 1 ~ 10
			if(i%3 == 0) {		// i = 3 6 9
				hap1 += i; 		// hap = hap + i
			}
			i++;				// 조건 끝나고 i → 1개씩+
		}
		System.out.println(hap1);
		
		// do while
		System.out.println("\ndo while");
		int i1 = 1;
		
		do {
			if(i1%3 == 0) {
				hap2 += i1;
			}
			i1++;
		} while(i1 <= 10);
		System.out.println(hap2);
		
		
		
//
//
//		힌트)
//		ver-1)
//		1이  3의 배수라면  합을더해주변수에누적
//		2가  3의 배수라면  합을더해주변수에누적
//		3이  3의 배수라면  합을더해주변수에누적
//
//		ver-2)
//		if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
//		if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
//		if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }
	}

}
