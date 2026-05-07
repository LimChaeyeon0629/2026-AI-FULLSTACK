package com.the703.basic015;

////////////////////////////////////////////////////////////
interface InterA2{  void   hi(); }
interface InterB2{  void   hi(String name); }
interface InterC2{  String hi(); }
interface InterD2{  String hi(int num , String name); }   
////////////////////////////////////////////////////////////

public class Lambda002 {
	public static void main(String[] args) {
		// interface InterA2{  void   hi(); }
		System.out.println("\n\n[STEP1] 매개변수X, 리턴값X");
		// 1-1. 익명 객체
		InterA2 a1 = new InterA2() {
			@Override
			public void hi() {
				System.out.println("hi");
			}
		};
		a1.hi();
		
		// 1-2. 람다식 () -> {};
		InterA2 a2 = () -> { System.out.println("hi hi"); };
		a2.hi();
		InterA2 a3 = () -> System.out.println("hi hi hi");
		a3.hi(); // 처리 할 일이 1줄이면 { } 생략 가능
		
		
		
		// interface InterB2{  void   hi(String name); }
		System.out.println("\n\n[STEP2] 매개변수O, 리턴값X");
		// 2-1. 익명 객체
		InterB2 b1 = new InterB2() {
			@Override
			public void hi(String name) {
				System.out.println("hi~ " + name);
			}
		};
		b1.hi("채연");
		
		// 2-2. 람다식 (자료형) -> {};
		InterB2 b2 = (String name) -> { System.out.println("hi~~ " + name); };
		b2.hi("채연");
		InterB2 b3 = (name) -> System.out.println("hi~~~ " + name);
		b3.hi("Lcy");
		InterB2 b4 = name -> System.out.println("hi~~~~ " + name);
		b4.hi("Lcy");
		
		
		
		// interface InterC2{  String hi(); }
		System.out.println("\n\n[STEP3] 매개변수X, 리턴값O");
		// 3-1. 익명 객체
		InterC2 c1 = new InterC2() {
			@Override
			public String hi() {
				return "1Good day";
			}
		};
		System.out.println( c1.hi() );
		
		// 3-2. 람다식 (자료형) -> {};
		InterC2 c2 = () -> { return "2Good day"; }; System.out.println(c2.hi());
		c2.hi();
		InterC2 c3 = () -> "3Good day"; System.out.println(c3.hi());
		
		//interface InterD2{  String   hi(int num , String name); }
        System.out.println("\n\n[STEP4] 매개변수O, 리턴값O");
        //4-1. 익명객체      hi sally ★ 
        InterD2 d1 = new InterD2() {
			@Override
			public String hi(int num, String name) {
				String star="";
				for(int i=0; i<num; i++) { star+="★"; };
				return "hi " + name + star;
			}
        };
        System.out.println(d1.hi( 1, "sally" ));  //hi sally ★ 
        System.out.println(d1.hi( 2, "sally" ));  //hi sally ★★
        
        //4-2. 람다식  ()-> {}
        InterD2 d2 = (int num, String name) -> { 
        	String star="";
        	for(int i=0; i<num; i++) { star+="★"; }
        	return "hi " + name + star; };
        System.out.println(d2.hi( 3, "sally" ));
        System.out.println(d2.hi( 4, "sally" ));

        InterD2 d3 = (num, name) -> { // int, String 자료형 줄이기
        	String star="";
        	for(int i=0; i<num; i++) { star+="☆"; }
        	return "hi " + name + star;
        };
    	System.out.println(d3.hi( 5, "sally" ));
    	
    	InterD2 d4 = (num, name) -> "hi " + name + "☆".repeat(num);
    	System.out.println(d4.hi( 6, "sally" ));
	}
}
