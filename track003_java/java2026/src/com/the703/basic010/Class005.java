package com.the703.basic010;

import java.net.MulticastSocket;

// 1. 클래스는 부품객체
// 2. 클래스는 상태(멤버 변수)와 행위(멤버 함수)

class Farm {
	// 멤버 번수 (인스턴스 변수)
	String name; // heap area 위치 - new 관련 O - 생성자 호출
	int age;
	
	static String 	FarmName = "(주) 동물농장"; 	// 클래스 변수 - 클래스명.변수명 Farm.FarmName
	static int 		FarmNum; // method area 위치 - new 관련 X - 생성자 X
	static String	FarmBoss;
	static { FarmNum=2; FarmBoss="신동엽"; } 		// 초기화 블록
	
	// 멤버 함수						// static에서는 this 사용 불가
	static void numPlus() { FarmNum++; /* this.age++; */ } // 클래스명.메서드 - method area - static
	void show() { 										   // 인스턴스 메서드 - heap area - new 관련 O - 생성자 관련 O
		System.out.println("\n\n");
		System.out.println("이름: " + this.name);
		System.out.println("나이: " + this.age);
		System.out.println("동물농장 인원: " + Farm.FarmNum);
	}
}

public class Class005 {
	public static void main(String[] args) {
		System.out.println("\n\n0. 동물농장");
		System.out.println(": 회사이름 > " + Farm.FarmName);
		System.out.println(": 회사사장 > " + Farm.FarmBoss);
		System.out.println(": 회사인원 > " + Farm.FarmNum);
		
		System.out.println("\n\n1. 동물식구 - this - 각각");
		Farm cat = new Farm();  // 1. 객체 만들기 	// 2. Farm() 초기화 	// 3. cat 번지
		cat.name = "kitty";		
		cat.age = 3;
		Farm.numPlus();
		cat.show();				
		
		Farm dog = new Farm();
		dog.name = "뽀비";
		dog.age = 5;
		Farm.numPlus();
		dog.show();
		 
		Farm.numPlus(); // 클래스명으로 접근하려면 static 필요
	}
}

//////////////////////////////////////////////////////
/*
	초기화		기본값	명시적초기화 		초기화블록			생성자
	FarmName	null	(주) 동물농장		(주) 동물농장		x
	FarmNum		0		0				2				x
	FarmBoss	null	null			신동엽			x
----------------------------------------------------
	cat		name=null	→				→				→
			age=0
	dog		name=null	→				→				→
			age=0
	
 */

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
----------------------------------------------------------------------
[METHOD:정보] Farm.class, Class005.class #1
	Farm.FarmName="(주) 동물농장";		Farm.FarmNum=2;		
	Farm.FarmBoss="신동엽";			Farm.numPlus();
----------------------------------------------------------------------
[HEAP:동적]           				 |  [STACK:지역]

2번지: { name="뽀비",   age=5 }			←	dog(2번지)
1번지: { name="kitty", age=3 }			←	cat(1번지)
										main #2
----------------------------------------------------------------------
*/
//////////////////////////////////////////////////////