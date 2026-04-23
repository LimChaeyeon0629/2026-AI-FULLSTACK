package com.the703.basic010;

// 1. final 변경 하지마
// 1-1) 클래스는 부품객체
// 1-2) 클래스(상속: x)는 상태(멤버 변수: 상수)와 행위(멤버 함수)
// final class 재사용하지마 - 상속 x

class FinalEx extends Object {
	static final String child="5-5"; // 클래스 변수 - method area - new x - this x
	String name; // 인스턴스 변수 - heap area - new o - 생성자() - this
	/* final */ void show() { System.out.println(child + "\t" + name); } // 인스턴스 메서드
}

class FinalExSon extends FinalEx { // 부모클래스 상속
	@Override void show() { System.out.println("나한테 맞게 수정"); }
}

// class Test extends Color { }
public class Class006_Final {
	public static void main(String[] args) {
//		FinalEx.child = "5-12"; // The final field FinalEx.child cannot be assigned
//		System.out.println(FinalEx.child);
	}
}


/*
final (하지마)

1) class => 재사용 x / 상속 x / extends 사용 못함
2) 멤버변수 => 상수 o / 재할당 x 값 변경 x
3) 멤버함수 => 부모 메서드를 @override x (부모 기능 수정 x)

*/