package com.the703.basic006_ex;

public class ForEx003_2 {

	public static void main(String[] args) {
//		1~10까지의 합을 구하시오. 55

//		upgrade)  시간나면 도전!
//		1+2+3+4+5+6+7+8+9+10=55
		
		int hap = 0;
		
		// h = h + i;
		
		// 1 = 0 + 1;
		// 3 = 1 + 2;
		// 6 = 3 + 3;
		// 10 = 6 + 4;
		// ...
		// 55 = 45 + 10;
		
		for(int i = 1; i <= 10; i++) {
			System.out.print(i); // 1 2 3 4 ... 10 출력
			
			if(i<=9) { // + 출력
				System.out.print("+");
			}
			
			hap+=i; // hap = hap + i;
		}
		System.out.println("=" + hap); // 55 출력
		
	}
}

		