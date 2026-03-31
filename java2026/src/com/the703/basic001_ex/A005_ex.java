package com.the703.basic001_ex;

public class A005_ex {

	public static void main(String[] args) {
		
//		println, print, printf 3가지 버젼으로 출력
//		아리랑 아리랑 아라리요      ←  println   
//		아리랑 고개를 넘어간다      ←  print
//		나를 버리고 가시는 님은     ←  print  
//		십리(4km)도 못 가서 발병난다  ←  printf   숫자(4) 출력서식
		
		System.out.println("아리랑 아리랑 아라리요");
		System.out.print("아리랑 고개를 넘어간다");
		System.out.print("\n나를 버리고 가시는 님은");
		System.out.printf("\n십리(%dkm)도 못 가서 발병난다", 4);
		//System.out.printf("\n십리(%d%s)도 못 가서 발병난다", 4, "km");
	}

}
