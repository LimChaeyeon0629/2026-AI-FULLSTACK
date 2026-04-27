package com.the703.basic011_ex;

// 1. 클래스는 부품객체
// 2. 부품객체는 상태(멤버변수)와 행위(멤버함수)
// 3. static(공용), final(수정하지마), public(접근)
// 4. 부품객체 재사용(extends, 오버로딩, 오버라이딩 - 다형성을 위해서 사용)

/*
	Object	
	 ↑
	Papa 	{ int brain; /			 sing(이문세 - 붉은노을) } 	※ 생성자: default, field
	 ↑
	Son 	{ int money; / @Override sing(빅뱅  - 붉은노을) }
	
*/

class Papa extends Object {
	int brain;
	
	void sing() { System.out.println("이문세 - 붉은 노을"); }
	
	public Papa() { super(); }
	public Papa(int brain) { super(); this.brain = brain; } // Papa
	
}

class Son extends Papa {
	int money;
	
	// @Override(오버라이딩) 자식에 맞게 수정
	@Override void sing() { 
		System.out.println("빅뱅 - 붉은 노을"); 
		System.out.println("IQ: " + brain); 
		System.out.println("Money: " + money); 
	}
	
	// 생성자 오버로딩 - 파라미터 재료로 구분 (자료형, 알규먼트 등)
	public Son() { super(); }
	public Son(int brain) { super(brain); }
	// public Son(int money) { super(); this.money = money; }
	// ↓ 바로 위에 파라미터 int brain 자료형 같음
	public Son(int brain, int money) { super(brain); this.money = money; }
	
}


///////////////////////////////////////////////////
public class ExtendsEx003 {
	public static void main(String[] args) {
		Son mySon = new Son(148, 100);
		mySon.sing();
	}
}

/*
Son mySon = new Son(148, 100); 	→ 	Papa(brain) this.money = money;

---------------------------------------------------------------
[method] Papa.class, Son.class, ExtendsEx003.class
---------------------------------------------------------------
[heap]													[main(stack)]

	 #3. Object() 		  {					 } #4
	 #2. Papa(148)   	  { brain=148,  sing } #5
1번지 #1. Son(148, 100) 	  { money=100, @sing } #6		← mySon[1번지]
	생성자 호출 순서							객체 만들어지는 순서

*/