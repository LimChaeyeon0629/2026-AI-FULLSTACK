package com.the703.days;

import java.util.ArrayList;

// ## 📝 문제: OOP 다형성
// Q1. 상속도를 그리시오.
/*  		↓생성자호출순서							 ↓객체생성순서
	Obejct #3. { 				   			   } #4.
	↑
	Papa   #2. { money=10; 		    toString() } #5.
	↑
	Son    #1. { money=150; car=2; @toString() } #6.

*/

// Q2. 상속도에서 각 객체에서 사용할 수 있는 멤버변수와 멤버함수를 적으시오.
// - Papa 멤버변수: money=10,		   멤버함수:  toString()
// - Son  멤버변수: money=10, car=2, 멤버함수: @toString()


class Papa{
	int money=10;

	public Papa() { super(); }
	public Papa(int money) { super(); this.money = money; }
	@Override public String toString() { return "Papa [money=" + money + "]"; }
}

class Son extends Papa{
	int money=150;
	int car=2;
	
	public Son() { super(); }
	public Son(int money) { super(money); }
	public Son(int money, int car) { super(); this.money = money; this.car = car; }
	@Override public String toString() { return "Son [money=" + money + ", car=" + car + "]"; }
}

public class Repeat003_oop {
	public static void main(String[] args) {
		
		// Q3. Papa p1 = new Papa(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// 메모리 구조: Papa p1 { money=10; toString() } = 1번지 new { money=10 / toString }
		// System.out.println(p1);의 결과는 무엇인가? - Papa [money=10]
		Papa p1 = new Papa();   
		System.out.println(p1); 
		
		// Q4. Son s2 = new Son(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// System.out.println(s2);의 결과는 무엇인가? - Son [money=150, car=2]
		Son s2 = new Son();
		System.out.println(s2);  
		
		// Q5. Son s3 = (Son) new Papa(); 실행 시 어떤 문제가 발생하는가?
		// Son s3 (3번지) = 		{ money=150, car=2; @toString() } - { money=10 / toString }
		// 					3번지									{ money=10 / toString }
//		Son s3 = (Son) new Papa(); 	// 자식 ≠ 부모 (자식은 부모 못 담음)
									// 타입캐스팅 해도 쓸 수 있는 기능이 없어서 오류
									// → { money=150, car=2; @toString() } 없음
									// 실제로 객체 만든 적이 없음
									// → new Son()이 아니고 new Papa()을 담음
//		Son s31 = s2;
		
		// Q6. Papa p4 = new Son(); 실행 시 메모리 구조와 출력 결과를 설명하시오.
		// Papa p4 (4번지) = 	{ money=150, car=2; @toString() } - { money=10; toString() }
		//					4번지				  [ @toString() } - { money=10; ---------- ] 사용
		// System.out.println(p4);의 결과는 무엇인가? - Son [money=150, car=2]
		// System.out.println(p4.money);의 결과는 무엇인가? - 10
		Papa p4 = new Son(); // 부모 = 자식 (부모는 자식 담음)
		System.out.println(p4); 
		System.out.println(p4.money); 

		// Q7. p4에서 Son의 money를 사용하는 방법은?
		// { money=150, car=2; @toString() } - { money=10; toString() }
		System.out.println( ((Son)p4).money ); // 타입캐스팅 사용해서 150 출력
		
		// Q8 오버로딩 / 오버라이딩이란?
		// 오버로딩	: 메서드명 동일, 파라미터(재료)로 구분
		// 오버라이딩	: 생성자 호출하고 객체 생성할 때 @Override 덮어쓰기
		 
	}
}

 
		
		
/*
📘 답: OOP 다형성
A1.
Object
   ↑
 Papa
   ↑
 Son


A2.
Papa: money=10, toString()
Son: money=150, car=2, toString() (Papa의 toString을 오버라이딩)


A3.
Papa p1 = new Papa(); → Papa 객체 생성, money=10
출력: Papa [money=10]

A4.
Son s2 = new Son(); → Son 객체 생성, money=150, car=2
출력: Son [money=150, car=2]

A5.
Son s3 = (Son) new Papa(); → 런타임 에러(ClassCastException) 발생
이유: 실제 생성된 객체는 Papa인데, 이를 Son으로 강제 형변환하려 했기 때문


A6.
Papa p4 = new Son(); → Son 객체 생성, 참조 타입은 Papa
System.out.println(p4); → Son [money=150, car=2] (오버라이딩된 toString 호출)
System.out.println(p4.money); → 10 (참조 타입이 Papa이므로 Papa의 money 사용)

A7.
다운캐스팅 필요:

Son s4 = (Son) p4;
System.out.println(s4.money); // 150

A8.
오버로딩(Overloading): 같은 이름의 메서드를 매개변수 타입/개수로 구분하여 여러 개 정의하는 것.
오버라이딩(Overriding): 부모 클래스의 메서드를 자식 클래스에서 재정의하여 다른 동작을 수행하는 것.

*/