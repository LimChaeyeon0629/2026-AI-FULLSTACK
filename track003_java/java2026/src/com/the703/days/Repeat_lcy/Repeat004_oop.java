package com.the703.days;

/*
📝 문제: OOP 개념(4) — 추상화 / 인터페이스

Q1. abstract란 무엇인가?
 - Abstract Class는 IS - A "~이다"
 - 공통기능을 일반화 하여 자식클래스가 구체적으로 구현하도록 강제
		 - abstract class 는 선언만 하고 하위클래스에서 사용
		 - 하위 클래스에게 구체적으로 메서드 구현하는 @Override 강제성
 ex) Animal, Plant, Human

Q2. interface란 무엇인가?
 - Interface는 HAS - A "~을 할 수 있는"
 - 구현 객체를 통해서 특정 기능을 수행할 수 있다고 약속
		 - 설계도 없음, { } 구현부 없음	
 ex) Talkable, Programmable, Eatable

	※ extends, implements 상속 시
	 - class  	  - extends    ->  class
	 - interface  - implements ->  class
	 - interface  - extends    ->  interface

Q3. abstract와 interface의 공통점과 차이점을 설명하시오.
 - 공통점:	자식 클래스를 통해서 설계 부분을 구현
 - 차이점: 	추상화정도가 인터페이스가 더 높다
 		추상클래스: 일반클래스 + 설계, 멤버변수					  / 멤버함수
 		인터페이스: 			설계, 상수(public static final) / 추상메서드(public abstract)


Q4. 다음과 같이 출력되게 코드를 작성하시오.
1) 출력 화면:
사과는 빨갛다. 	- @Override public void myfruit() { System.out.println("사과는 빨갛다."); }
바나나는 노랗다.	- @Override public void myfruit() { System.out.println("바나나는 노랗다."); }
코코넛은 코코하다. 	- @Override public void myfruit() { System.out.println("코코넛은 코코하다."); }

2) 상속도:
	Fruit { myfruit() }
	↑				↑				↑
	Apple			Banana			Coconut
	{ @myfruit() }	{ @myfruit() }	{ @myfruit() }

*/

abstract class Fruit {
	@Override public String toString() { return "Fruit"; }
	public abstract void myfruit(); // 추상 메서드
}

class Apple extends Fruit{ 
	@Override public void myfruit() { System.out.println("사과는 빨갛다."); }
}
class Banana extends Fruit{ 
	@Override public void myfruit() { System.out.println("바나나는 노랗다."); }
}
class Coconut extends Fruit{ 
	@Override public void myfruit() { System.out.println("코코넛은 코코하다."); }
}

public class Repeat004_oop {
	public static void main(String[] args) {
		// 부모			= 자식들
	 	Fruit [] fruits = { new Apple() , new Banana() , new Coconut() };
	 	
	 	// 다형성: 한 개의 타입으로 여러 개의 타입들을 관리
	 	// 추상 클래스를 통해 객체를 직접 생성하려 하면 컴파일 오류 발생
//	 	Fruit fruit = new Fruit(); // 오류 (abstract - new x)
	 	
	 	// 한 개의 자료형(부모)으로 여러 개의 객체들(자식들)을 관리
	 	Fruit fruit1 = new Apple();
	 	Fruit fruit2 = fruits[0];
	 	
	 	System.out.println(fruit1); // Fruit (@Override)
	 	
//	 	for(int i=0; i<fruits.length; i++) {
//	 		fruits[i].myfruit();
//	 	}
	 	
	 	for(Fruit f : fruits) { // 향상된 for(클래스명 변수 : 배열)
	 		f.myfruit(); 
	 	}
	}
}



/*
📘 답: OOP 개념(3) — 추상화 / 인터페이스
A1.
abstract: 추상 클래스, 공통 기능을 일반화하여 자식 클래스가 구체적으로 구현하도록 강제한다.
“IS-A” 관계: 고양이는 동물이다.

A2.
interface: 구현 객체를 통해 특정 기능을 수행할 수 있다는 약속을 정의한다.
“CAN-DO” 관계: ~할 수 있다.

A3.
공통점: 자식 클래스를 통해 설계 부분을 구현한다.
차이점:
추상 클래스: 일반 클래스 + 설계도, 멤버 변수/메서드 포함 가능.
인터페이스: 설계도만, 멤버 변수는 public static final 상수, 메서드는 public abstract 추상 메서드.
추상화 정도는 인터페이스가 더 높다.

A4. 코드 예시:
abstract class Fruit {
    @Override public String toString() { return "Fruit"; }
    public abstract void myfruit();
}

class Apple extends Fruit {
    @Override public void myfruit() { System.out.println("사과는 빨갛다."); }
}

class Banana extends Fruit {
    @Override public void myfruit() { System.out.println("바나나는 노랗다."); }
}

class Coconut extends Fruit {
    @Override public void myfruit() { System.out.println("코코넛은 코코하다."); }
}

public class Abstract005 {
    public static void main(String[] args) {
        Fruit[] fruits = { new Apple(), new Banana(), new Coconut() };
        for (Fruit f : fruits) {
            f.myfruit();
        }
    }
}
*/