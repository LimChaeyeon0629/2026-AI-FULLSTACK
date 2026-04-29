package com.the703.basic013;

/*
원칙   설명
S - SRP (단일 책임 원칙)  	 클래스는 하나의 책임만 가져야 함. 즉, 변경의 이유가 하나여야 함.
O - OCP (개방-폐쇄 원칙)  	 확장에는 열려 있고, 변경에는 닫혀 있어야 함.
						 기존 코드를 수정하지 않고 기능을 추가할 수 있어야 함.
L - LSP (리스코프 치환 원칙)    하위 클래스는 상위 클래스의 기능을 대체할 수 있어야 함. 즉, 다형성을 지켜야 함.
I - ISP (인터페이스 분리 원칙)  클라이언트는 자신이 사용하지 않는 메서드에 의존하면 안 됨. 인터페이스는 작고 명확하게 분리해야 함.
D - DIP (의존 역전 원칙)  	 고수준 모듈은 저수준 모듈에 의존하면 안 되고, 추상화에 의존해야 함. 즉, 인터페이스에 의존하라는 뜻.

1. S : 한 클래스는 하나만 (한 가지 일만 / 쿠키 반죽 class = 반죽만, 쿠키 굽기 class = 쿠기 굽기만)
2. O : (수정말고 추가만) 새로운 쿠키 쉽게 추가
3. L : (다형성: 같은 방식으로 처리) 모든 쿠키는 같은 방식으로 만들기

*/



// 1. s: 단일 책임 원칙
class CookieMaker {
	public void bakeCookie(String type) {
		System.out.println(type + "쿠키를 구워요");
	}
}

// 2. o: 개방 폐쇄 (새로운 쿠키 추가 가능, but 기존 코드 건들지 말기)
interface Cookie { void make(); }

class ChocoCookie implements Cookie {
	@Override public void make() { System.out.println("초코쿠키"); }
}
class DeepChocoCookie implements Cookie {
	@Override public void make() { System.out.println("딥초코쿠키"); }
}
class ChocoBananaCookie implements Cookie {
	@Override public void make() { System.out.println("초코바나나쿠키"); }
}

// 3. L : 리스코프 치환 (어떤 쿠키든 Cookie 인터페이스로 바꿔 써도 문제 없음) 부모 = 자식
class CookieFactory { // Cookie cookie 각종 쿠키 종류
	public void makeCookie (Cookie cookie) { // 어떤 쿠키든 여기서 만들 수 있어요
		cookie.make();
	}
}

// 4. I : interface - 너무 많은 기능을 강요하지 말 것! 꼭 필요한 기능 (절차)
interface SimpleCookie {
	void make1();
//	void make2();
//	void make3();
}

// 5. D : 의존 역전 - 어떤 쿠키든 가게에서 팔 수 있어요
//					CookieFactory는 구체적인 쿠키가 아니라 Cookie에 의존
class CookieShop {
	private Cookie cookie; // interface Cookie 설계도 (interface는 실체화 x - { } 구현부 x)

	public CookieShop() { super(); }
	public CookieShop(Cookie cookie) {
		super();
		this.cookie = cookie;
	} // 쿠키 종류는 외부에서 넣어주기 (의존)
	
	public void sell() {
		System.out.println("cookie 가게에서... ");
		cookie.make();
	}
}



public class SolidBasic {
	public static void main(String[] args) {
		// 1. s: 단일 책임 원칙
		System.out.println("1. s: 단일 책임 원칙");
		CookieMaker maker = new CookieMaker();
		maker.bakeCookie("초코");
		maker.bakeCookie("오트밀");
		maker.bakeCookie("라즈베리");
		
		// 2. o: 개방-폐쇄의 원칙 + 3. L : 리스코프 치환
		System.out.println("\n2. o: 개방-폐쇄(레시피 추가) + 3. l : 리스코프(공장 - 어떤 쿠키든지 굽기 가능) 치환");
		CookieFactory factory = new CookieFactory();
		factory.makeCookie(new ChocoCookie());
		factory.makeCookie(new DeepChocoCookie());
		factory.makeCookie(new ChocoBananaCookie());
		
		// 4. i : 인터페이스 분리
		
		// 5. d : 의존 역전 - 어떤 쿠키든 가게에서 팔 수 ㅇㅇ
		System.out.println("\n5. 의존 역전");
		CookieShop shop = new CookieShop( new DeepChocoCookie() );
		shop.sell();
	}
}
