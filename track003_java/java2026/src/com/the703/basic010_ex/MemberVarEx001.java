package com.the703.basic010_ex;

class Sawon3 {
	int pay             = 10000; 		// 인스턴스 변수 / heap area  - new O - 생성자 - this (각각)
	static int su       = 10;    		// 클래스 변수  / method area - new X - 공용  - 클래스명.su
	static int basicpay = pay;  		// 클래스 변수 = 인스턴스 변수   - static은 인스턴스 변수 불가
										// static은 먼저 메모리에 들어가 있음 / 인스턴스 변수는 new 구동 될 때 사용
	static int basicpay2;    	 		// 클래스 변수  / method area - new X - 공용  - 클래스명.basicpay2 
  
	public static void showSu () { System.out.println(su);       } // 클래스 메서드
	public static void showPay() { System.out.println(this.pay); } // 클래스 메서드인데 인스턴스에서만 사용 가능한 this 써서?   

	public void showAll001() {   		 // 인스턴스 메서드 (static X => this 사용 가능)
		System.out.println(su);  		 // 10 출력
		System.out.println(this.pay);  	 // new 객체를 만들어서 사용
	} 
	public static void showAll002() {	 // 클래스 메서드 (static O => this 사용 불가)
		showAll001(); 					 // 인스턴스 메서드 - this 사용 불가
		System.out.println(this.pay);	 // 10000 출력, 클래스 메서드 - this 사용 불가
	} 
}

// 오류 나는 이유: 클래스 메서드에 인스턴스 메서드(this)를 사용해서...

public class MemberVarEx001 {
	public static void main(String[] args) {
		Sawon3 sola = new Sawon3(); // new 객체 생성, Sawon3 생성자, sola (1번지)
	    sola.showAll001();
	}
}

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
----------------------------------------------------------------------
[METHOD:정보] Sawon3.class, MemberVarEx001.class #1
	Sawon3.su=10; Sawon3.basicpay2; Sawon3.basicpay; Sawon3.showSu(); Sawon3.showPay();
----------------------------------------------------------------------
[HEAP:동적]        		   		|  [STACK:지역]
1번지: { pay=10000,					
 		showAll001() }			← 	sola[1번지] 1) new 2) 생성자 3) sola 1번지 할당 - new 객체 생성 후 사용가능
									main #2						( 인스턴스 변수 pay는 new 객체 만들어서 사용 )
----------------------------------------------------------------------
 */
//////////////////////////////////////////////////////
/*
초기화		기본값	명시적초기화 		초기화블록			생성자
pay			10000		0							x
su			10			0							x
basicpay											x
basicpay2											x
----------------------------------------------------
*/
//////////////////////////////////////////////////////


//1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
//2. 인스턴스메서드, 클래스메서드 구분하시오.
//3. 오류나는 이유는?

//class Sawon3{ 
//    int pay      =10000;    
//    static int su=10;     
//    static int basicpay=pay;    
//    static int basicpay2;    
//    
//    public static void showSu() {   System.out.println(su);  }          
//    public static void showPay() {   System.out.println(this.pay);  }    
//  
//    public  void  showAll001() {   
//       System.out.println(su);  
//       System.out.println(this.pay);  
//    } 
//    public static  void  showAll002() {   
//        showAll001();    
//       System.out.println(this.pay);
//    } 
//} 
//public class MemberVarEx001{
//  public static void main(String[] args) {
//   Sawon3   sola = new Sawon3();  
//   sola.showAll001();
//  }
//}     