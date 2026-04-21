package com.the703.basic010;

// 1. 클래스는 부품객체
// 2. 클래스는 상태(멤버 변수)와 행위(멤버 함수)

class Car31 extends Object { } // 생성자 Car31() - 1)컴파일러가 기본생성자를 자동생성 	3)컴파일러가 기본생성자 자동생성 취소
class Car32 extends Object { // 생성자는 초기화 역할
	String color; // alt + shift + s - 2, 3, 4

//	public Car32() { color="white"; } // 기본 생성자	- 2)생성자를 개발자가 수동으로 만들 때
	public Car32(String color) { super(); this.color = color; } // 필드있는 생성자
	// 상태 확인
	@Override public String toString() { return "Car32 [color=" + color + "]"; } 
}

public class Class003 {
	public static void main(String[] args) {
		Car31 car1 = new Car31(); // 1. new (객체생성)	2. Car31()초기화			3. car1 번지
		System.out.println(car1); // 번지 @73a28541
		
		Car32 car3 = new Car32("red");
		System.out.println(car3 + "\t" + car3.color);
		
		Car32 car2 = new Car32(); // 1. new (객체생성)	2. Car31()초기화-null		3. car1 번지
		System.out.println(car2 + "\t" + car2.color); // toString 상태
	}
}

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Car31.class, Car32.class(toString), Class003.class (#1)
------------------------------------
[HEAP:동적]            			|  [STACK:지역]
3번지: Car32{ color="red" }		←	car3[3번지]
2번지: Car32{ color=null }		←	car2[2번지]
1번지: Car31{}					←	car1[1번지]
									main (#2)
------------------------------------
*/
//////////////////////////////////////////////////////

/*
1. 생성자 - new 연산자에 의해 호출 [초기화] 담당

2. 기본 생성자
 - 모든 클래스에 생성자가 반드시 존재
 - 생성자 선언 생략 시 컴파일러가 자동으로 기본 생성자 추가 (기본 초기값 문자열 null, 숫자 0)
 - 개발자가 선언할 때 컴파일러가 자동생성 취소
   alt + shift + s 

3. 형식
class A {
	String name;
	
	A(){ }						// 기본 생성자 (null)
	A(String name){ }			// 파라미터, 알규먼트가 있는 생성자
}
 리턴값 메서드명(파라미터 재료) { }
   x 	클래스명 동일
*/