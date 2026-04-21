package com.the703.basic010_ex;

class Coffee {
	String name;
	int price, num;
	
	public Coffee() { // 기본생성자
		this.name = "아메리카노";
		this.num = 1;
		this.price = 2000;
	}

	// Coffee a1 = new Coffee("카페라떼", 2, 4000);
	public Coffee(String name, int num, int price) { // 생성자 (초기값 잡기)
		super(); 
		this.name = name; 	// "카페라떼"
		this.num = num; 	// 2
		this.price = price; // 4000
	}

	void show() { // 출력
		System.out.println("=====커피");
		System.out.println("커피명: " + name);
		System.out.println("커피잔수: " + num);
		System.out.println("커피가격: " + price*num);
	}
}

public class ClassEx003 {
	public static void main(String[] args) {
		Coffee a1 = new Coffee("카페라떼", 2, 4000); // 생성자
		a1.show();

		Coffee a2 = new Coffee(); // 기본생성자
		a2.show();
	}
}

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Coffee.class, ClassEx003.class
------------------------------------
[HEAP:동적]           							 |  [STACK:지역]

2번지 { name=null,     num=0, price=0 }			←	a2[2번지]
1번지 { name="카페라떼", num=2, price=4000 }		←	a1[1번지]
													main
------------------------------------
*/
//////////////////////////////////////////////////////


//-- 생성자 작성하시오.
//class Coffee{
//  멤버변수 : String name;  int  price, num;
//  멤버함수 : void show(){}   //커피정보출력
//}
//public class Class003 {
//   public static void main(String[] args) {
//   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  a1.show();
//   Coffee a2 = new Coffee();                    a2.show();
//  }
//}
//출력내용 :
//=====커피
//커피명 : 까페라떼
//커피잔수 : 2 
//커피가격 : 8000
//=====커피
//커피명 : 아메리카노
//커피잔수 : 1
//커피가격 : 2000