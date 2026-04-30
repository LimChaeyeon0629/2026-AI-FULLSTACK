package com.the703.days;

//## 📝 문제: OOP 개념(1)
//다음 코드를 보고 질문에 답하시오.

//Q1. OOP란 무엇인가?
// - Object Oriented Programming 객체 지향(틀) 프로그램
/*
	부품객체(클래스) 조립해서 프로그래밍을 구성하는 방법
	클래스는 부품객체
	객체는 상태(멤버변수:인스턴스변수&클래스변수)와 행위(멤버함수:인스턴스메서드&클래스메서드)
*/

//Q2. OOP의 핵심 개념은 무엇인가?
// 캡다상추 - 캡슐화 다형성 상속 추상화
/*
	캡슐화: 외부에서 직접 접근하지 못하게 보호
	다형성: 하나의 타입으로 여러 개의 타입을 관리
	상속  : 클래스의 재사용 혹은 재활용
	추상화: 일반화 시켜서 복잡한 구현을 숨기고 핵심적인 기능을 단순화 하는 설계 기법 (abstract, interface)
*/

//Q3. 상속도를 그리시오.
/*
	Object #3. {			  	  } #4.
	↑
	Parent #2. { x=100;  method() } #5.
	↑
	Child  #1. { x=200; @method() } #6.
	
*/

//Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.
// - Parent 멤버변수: x=100, 멤버함수: method()  = Parent method
// - Child  멤버변수: x=200, 멤버함수: @method() = Child method

//Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오.
// 객체 생성: new, 초기화(null or 0): Child(), 참조값(주소 저장): p

//Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오.
// Parent 멤버변수: x=100, 메서드종류: method()

//Q7. 출력 결과를 쓰시오.
//- p.x의 값은? - 100
//- p.method() 실행 시 어떤 메서드가 호출되는가? - Child method
//- c.x의 값은? - 200
//- c.method() 실행 시 어떤 메서드가 호출되는가? - Child method

//Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오.
// @Override는 메서드명 동일, 파라미터(재료)만 다름. @Override 사용 시 덮어쓰기 당함
/* 
	상속 시 부모클래스의 메서드를 자식클래스에서 재정의
	Parent method()가 Child 에서 오버라이딩
*/


//Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.
// (생성자 호출 순서와 객체 순서는 위 Q3. 상속도에 기재)
/*
	타입 사용할 수 있는 범위: { x=200; @method() } - { x=100; method() }
	생성자 호출 순서: Child() → Parent() → Object()
	객체 생성 순서  : Object → Parent → Child
*/

class Parent {
    int x = 100; // 인스턴스변수 - heap area - new o - 생성자 o - 각각 this
    void method() { System.out.println("Parent method"); } // 인스턴스 메서드
}

class Child extends Parent {
    int x = 200;
    @Override void method() { System.out.println("Child method"); }
}

public class Day017 {
	public static void main(String[] args) {
		// Q5 - 1. new 객체생성, 주소 / child() 초기화 / p (주소값)
		/*
			method area (정보, static, final) - Parent.class, Child.class, Day017.class #1
			
			heap									stack
#4) Child() → Parent() → Object()
Object()	{								   }
Parent()	{ x=100;  method() → Parent method }		
Child()		{ x=200; @method() → Child method  }

#3) new		1번지 Parent { x=100; method() }		← p [1번지] #5
													[main] #2
		 */
		Parent p = new Child(); // 부모 = 자식 (부모는 자식을 담을 수 있다)
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
	}
}