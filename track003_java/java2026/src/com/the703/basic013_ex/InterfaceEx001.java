package com.the703.basic013_ex;

// 1. 클래스는 부품객체
// 2. 설계 인터페이스	상태(상수: static final), 행위(abstract 강제성)

/*
	Board { exec() }
	↑				↑				↑				↑
	BoardInsert		BoardSelect		BoardUpdate		BoardDelete
	{ @exec() }		{ @exec() }		{ @exec() }		{ @exec() }

*/

interface Board { void exec(); }

class BoardInsert implements Board { 
	@Override public void exec() { System.out.println("글쓰기"); };
}
class BoardSelect implements Board { 
	@Override public void exec() { System.out.println("글읽기"); };
}
class BoardUpdate implements Board { 
	@Override public void exec() { System.out.println("글수정"); };
}
class BoardDelete implements Board { 
	@Override public void exec() { System.out.println("글삭제"); };
}

public class InterfaceEx001 {
	public static void main(String[] args) {
		Board controller = null; 
        controller = new BoardInsert();  controller.exec();
        controller = new BoardSelect();  controller.exec();
        controller = new BoardUpdate();  controller.exec();
        controller = new BoardDelete();  controller.exec();
        
//	    4.  실행 결과 
//	    글쓰기
//	    글읽기
//	    글수정
//	    글삭제
	}
}

//1. 문제 설명
//다음은 게시판 기능을 인터페이스로 추상화한 프로그램이다. 
//Board 인터페이스는 게시판 기능의 공통 동작을 정의하며, 
//BoardInsert, BoardSelect, BoardUpdate, BoardDelete 클래스는 이를 구현하여 각각의 기능을 수행한다.