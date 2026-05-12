package com.the703.basic018_ex;

import javax.swing.JOptionPane;

class QuestionCount extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) { e.printStackTrace(); }

		
		for(int i=10; i>0; i--) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

class SetIsStop extends Thread {
	private boolean isStop;
	public SetIsStop(boolean isStop) { this.isStop = isStop; }
	
	
	while(!isStop) {
		for(long i=0; i<100000000; i++) { } // 시간 지연용
		if(Thread.interrupted()) { break; }
	}
}


public class ThreadEx001 {
	public static void main(String[] args) {
		Thread count = new QuestionCount();
		Thread stop  = new SetIsStop();
		count.start();
		stop.start();

		String answer = JOptionPane.showInputDialog("사과 알파벳을 입력하세요.");
//		if(answer.equals("apple")) { System.out.println("정답입니다."); }
//		else { System.out.println("정답이 아닙니다."); }
		
//		System.out.println( answer.equals("apple")? "정답" : "오답");
		System.out.println( answer.toLowerCase().equals("apple")? "정답" : "오답" );
		// 							다 소문자로 "apple"
	}
}

//연습문제1)  Thread
//패키지명 : com.the703.basic018
//클래스명 : ThreadEx001
//1.  QuestionCount  - 10부터 1까지 
//      카운트 1초에 10 ,
//                2초에 9, 
//                3초에  8.....
//
//2. 사과알파벳을 입력하세요.
//   사과를 입력을받으면 정답입니다 / 정답이 아닙니다.