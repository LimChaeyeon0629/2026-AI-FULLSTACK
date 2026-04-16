package com.the703.basic009_ex;

public class MethodEx003 {

	public static void test1(int num1) {
		System.out.println(num1);
	}
	
	public static void test2(double num2) {
		System.out.println(num2);
	}
	
	public static void hap(int num3, int num4) {
		int hap = 0;
		for(int i = num3; i <= num4; i++) { // 3 4 5
			hap += i;
		}
		System.out.println(hap);
	}

	public static void disp(int num5, char star) {
		for(int i = 1; i <= num5; i++) {
			System.out.print(star);
		}
	}
	
	
	
	public static void main(String[] args) {
		test1(10);    //10 출력
	    test2(1.2);   // 1.2 출력
	    hap(3,5);     // 3+4+5한값  12 출력
	    disp(7, '*');  // *******출력
	}

}

//		다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.
//
//		public static void main(String[] args) {
//		    // public static  리턴값 메서드명(파라미터)
//		    test1(10);    //10 출력
//		     test2(1.2);   // 1.2 출력
//		     hap(3,5);     // 3+4+5한값  12 출력
//		     disp(7, '*');  // *******출력
//		}