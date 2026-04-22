package com.the703.basic010_ex;

// 1. 클래스는 부품객체
// 2. 상태(멤버변수, 인스턴스변수, 클래스변수-static)와 행위(인스턴스메소드, 클래스메서드-static)

class Area1 {
//	Area1.pi 		  (클래스 변수 - static)
//	Area1.reat(10, 5) (클래스 메소드 - static)
	
	static double pi = 3.14159;
	
	// public static 50.0 메소드명(10, 5) { 사각형의 면적 }
	public static double rect(int num1, int num2) { 
		return num1*num2;
	}

	// public static 25.0 메소드명(10, 5) { 삼각형의 면적 }
	public static double triangle(double num1, double num2) { 
		return (num1*num2)/2;
	}
}

public class StaticEx001 {
	public static void main(String[] args) {
		System.out.println("원의 면적   : " + 10 * 10 * Area1.pi); // 원의 면적: 314.159;
	    System.out.println("사각형의 면적: " + Area1.rect(10, 5));  // 사각형의 면적: 50.0;
	    System.out.println("삼각형의 면적: " + Area1.triangle(10, 5)); // 삼각형의 면적 : 25.0;
	}
}