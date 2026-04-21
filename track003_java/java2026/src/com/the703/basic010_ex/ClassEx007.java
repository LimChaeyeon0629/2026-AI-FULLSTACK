package com.the703.basic010_ex;

import java.util.Scanner;

class Calc {
	int num1, num2;
	char op;
	double result;
	
	// Calc c1= new Calc(10, 3, '+'); 
	public Calc(int num1, int num2, char op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
	}
	
	public Calc() { }
	
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1 입력: ");
		num1 = sc.nextInt();
		System.out.println("숫자2 입력: ");
		num2 = sc.nextInt();
		System.out.println("연산자 입력: ");
		op = sc.next().charAt(0);
	}

	void opcalc() {
		if(op == '/') {
			result = num1 + num2;
		} else if(op == '-') {
			result = num1 - num2;
		} else if(op == '*') {
			result = num1 * num2;
		} else if(op == '/') {
			result = (double)num1 / num2;
		}
	}

	void show() {
		opcalc();
		System.out.printf("%d%c%d=%.2f\n", num1, op, num2, result);
	}
}

public class ClassEx007 {
	public static void main(String[] args) {
	   Calc c1= new Calc(10, 3, '+'); 
	   c1.show();
	   
	   Calc c2= new Calc();  
	   c2.input();
	   c2.show(); 
	}
}

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]
------------------------------------
[HEAP:동적]            |  [STACK:지역]
------------------------------------
*/
//////////////////////////////////////////////////////

//-- 생성자 작성하시오.
//class Calc{
//   //상태-멤버변수  :  int num1, num2;  char op;  double result;
//   //행위-멤버함수  :  void input()   입력받기
//   //               void opcalc()  +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
//   //               void show()    연산출력   
//}
//public class ClassEx007{
//   public static void main(String[] args) {
//   Calc  c1= new Calc(10,3,'+');  
//   c1.show();
//   
//   Calc  c2= new Calc();  
//   c2.input();   
//   c2.show(); 
//    
//   }
//}
//
//출력내용)
//10+3=3
//
//숫자1> 10
//숫자2> 3
//연산자> /
//10/3=3.33