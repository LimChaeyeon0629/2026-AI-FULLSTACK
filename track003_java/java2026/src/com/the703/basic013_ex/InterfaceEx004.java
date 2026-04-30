package com.the703.basic013_ex;

import java.util.Calendar;

/*
	Launch { Money=10000, eat() } 						← User
	↑										↑
	Burger									KimchiStew
	{ price=3900; @toString(), @eat() }		{ price=4000; @toString(), @eat() }
	
*/

//Launch 인터페이스는 모든 메뉴가 공통적으로 가져야 할 기능을 정의하며, 
interface Launch { 		// interface 공통 규칙 선언
    int MONEY = 10000; 	// 변수	- static final
    void eat();			// 메서드	- abstract
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
    public User() { 
    	this.money = Launch.MONEY;
    	plate = new Launch[3];
    	cnt = 0;
    }
    
	//  주문 시 메뉴 종류에 따라 가격 확인
    void order (Launch a) {
    	int temp = 0;
    	
    	if(a instanceof Burger) {
    		System.out.println("버거하나요~");
    		temp = ((Burger)a).price; // price 접근 → 다운캐스팅
    	}
    	
    	if(a instanceof KimchiStew) {
    		System.out.println("김치찌개하나요~");
    		temp = ((KimchiStew)a).price;
    	}
	
		//  잔액 부족 시 주문 거절
	    if(money<temp) {
	    	System.out.println("잔액 부족! 주문 거절");
	    	return;
	    }
	
	    //  주문 성공 시 배열에 저장
	    plate[cnt++] = a;
	    // System.out.println( money + "-" + Arrays.toString(plate) )
    } // 주문   버거하나요~   김치찌개하나요~  버거하나요~  /  잔액부족 주문불가능

    public void show() { //- show() 메서드로 주문 내역 출력
//    	주문한 메뉴 목록
//    	총 주문 금액
//    	잔액
//    	오늘 날짜
//    	각 메뉴의 eat() 호출
    	String order = "주문    : ";
    	
    	for(int i=0; i<cnt; i++) {
    		order += ((i != 0 ? ", " : "") + plate[i]);
    	}
    	
    	System.out.println("\n\n" + order);
    	System.out.println("주문금액 : " + (Launch.MONEY - money));
    	System.out.println("잔액    : " + money);
    	
    	Calendar today = Calendar.getInstance();
    	System.out.println(today.get(1)    + "년 " +  //년
			              (today.get(2)+1) + "월 " +  //월 0~11 (0 : 1월)
			               today.get(5)    + "일 " ); //일
    	
    	//java.lang.NullPointerException - 공간은 있으나 값이 없다.
    	//for(Launch a : plate){ a.eat(); }   //부모에서 메서드호출시 @Override- 자식메서드 호출
    	
    	for( int i=0; i<cnt; i++ ) { plate[i].eat(); }
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