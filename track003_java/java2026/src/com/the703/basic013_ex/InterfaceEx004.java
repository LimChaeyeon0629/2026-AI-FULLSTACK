package com.the703.basic013_ex;

import java.util.Scanner;

/*
	Launch { Money=10000, eat() } 						← User
	↑										↑
	Burger									KimchiStew
	{ price=3900; @toString(), @eat() }		{ price=4000; @toString(), @eat() }
	
*/

//Launch 인터페이스는 모든 메뉴가 공통적으로 가져야 할 기능을 정의하며, 
interface Launch {
    int MONEY = 10000;
    void eat();
}

//Burger, KimchiStew 클래스는 이를 구현하여 각각의 메뉴 정보를 제공한다. 
class Burger implements Launch { 
   int price;
   public Burger() { this.price = 3900; }
   @Override public String toString() { return "Burger"; }
   @Override public void eat() { System.out.println("Burger 냠냠!"); } 
}

class KimchiStew implements Launch { 
   int price;
   public KimchiStew() { this.price = 4000; }
   @Override public String toString() { return "KimchiStew"; }
   @Override public void eat() { System.out.println("KimchiStew 냠냠!"); } 
}

//User 클래스는 메뉴를 주문하고, 주문 내역을 출력하는 기능을 담당한다.
class User {  
	int money;
    int cnt;
    Launch [] plate;
//    Launch [] plate = { new Burger(), new KimchiStew(), new Burger() };
//    
//    public void order(Launch a) { //- order(Launch a) 메서드로 메뉴 주문
//    	for(int i=0; i<plate.length; i++) {
//    		plate[i].toString(); 
//    	}
//    	a.eat();
    
    public User() { 
    	this.money = Launch.MONEY;
    	plate = new Launch[3];
    	cnt = 0;
    }
    
	//  주문 시 메뉴 종류에 따라 가격 확인
    void order (Launch l) {
    	if(l instanceof Burger) {
    		System.out.println("버거하나요~");
    		System.out.println( ((Burger)l).price );
    	}
    	
    	if(l instanceof KimchiStew) {
    		System.out.println("김치찌개하나요~");
    		System.out.println( ((KimchiStew)l).price );
    	}
    }
	
	
	//  잔액 부족 시 주문 거절
	
	
	//  주문 성공 시 배열에 저장

    public void show() { //- show() 메서드로 주문 내역 출력
    	System.out.println("주문: " ); 						// 주문한 메뉴 목록
    	System.out.println("주문금액: "); 					// 총 주문 금액
    	System.out.println("잔액: "); 						// 잔액
    }
    
}


public class InterfaceEx004 {
	public static void main(String[] args) {
		User launch_order = new User();
		
		launch_order.order(new Burger());   	// void order(Launch a){}
		launch_order.order(new KimchiStew());   // Launch a = new Kimchi()  부모=자식
		launch_order.order(new Burger());   	// Launch a = new Burger()  부모=자식
		      
		launch_order.show();
// void  		     show  (	  ){}
// 리턴값 		     메서드명(파라미터)
		
		
//		4. 실행 예시 
//		버거하나요~
//		Burger 냠냠!
//		김치찌개하나요~ 
//		KimchiStew 냠냠!
//		버거하나요~ 
//		Burger 냠냠!
//
//
//		주문    : Burger, KimchiStew, Burger
//		주문금액 : 11800
//		잔액    : -1800
//		2025년 9월 30일
//		Burger 냠냠!
//		KimchiStew 냠냠!
//		Burger 냠냠!
//		※ 실제 실행 결과는 날짜 및 주문 순서에 따라 달라질 수 있습니다.
	}
}