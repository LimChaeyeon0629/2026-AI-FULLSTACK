package com.the703.basic012_ex;

/* Q1. 상속
	Object 	#3. { 					 } #4.
		↑
	Parant7 #2. { x=100;	method() } #5.
		↑
	Child7  #1. { x=200;   @method() } #6.
	
*/

class Parent7 extends Object{
	int x = 100;
    public Parent7() { super(); }
    void method() { System.out.println("Parent Method"); }
} 

class Child7 extends Parent7 {
    int x = 200;
    public Child7() { super(); }
    @Override void method() { System.out.println("Child Method"); }
}

public class PolyEx002 {
	public static void main(String[] args) {
		// Q3. Parent7 p 보장하는 범위 - { x=100;	method() }
		Parent7 p = new Child7(); // 부모 = 자식 (업캐스팅)
	    // Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7() 
	    Child7 c = new Child7(); // 1번지 : { x=200, @method } - { x=100, method }
	    						 // 		Child7()		→	Parent7()			→ Object()
	    
	    System.out.println("p.x = " + p.x); // Q5. 출력되는 내용 - 100
	    p.method(); // Q6. 출력되는 내용 - Child Method ( → 오버라이드 해서 덮어쓰기 )
	    // { x=100;	method() } = 1번지 : { x=200, @method } - { x=100, ------ }
	    System.out.println("c.x = " + c.x); // Q7. 출력되는 내용 - 200
	    c.method(); // Q8. 출력되는 내용 - Child Method ( → 오버라이드 해서 자식에 맞게 사용 )
	}
}