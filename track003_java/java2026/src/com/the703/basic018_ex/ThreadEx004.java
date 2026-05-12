package com.the703.basic018_ex;

import java.util.Scanner;
import javax.swing.JOptionPane;

//■문제명: Thread.interrupt()를 이용한 카운트 중단 스레드 구현
//Thread를 상속받은 Count 클래스를 만들고, 10부터 1까지 1초 간격으로 숫자를 출력하는 스레드를 구현하세요.  
//main()에서는 사용자 입력을 받아 "y"를 입력하면 스레드를 중단합니다.  
//이때 interrupt() 메서드를 사용하여 스레드를 안전하게 종료하도록 구현하세요.

class Count extends Thread {
    @Override public void run() {
    	for(int i=10; i>0; i--) { //#####1. ... 10~1까지 카운트
    		System.out.println(i);
    		
    		// 중단요청 확인
//    		if ( Thread.currentThread().isInterrupted() ) {
//    			System.out.println("판매 중단!");
//    			break;
//    		}
    		
    		try { Thread.sleep(1000); }
    		catch (InterruptedException e) { break; } //#####2. 오류시 break
		}
    }
}

public class ThreadEx004 {
    public static void main(String[] args) {
    	
    	String info = "계속 카운트 합니다.";
        Thread count = new Count();
        count.start();

        //##### 3. 입력받기
        String answer = JOptionPane.showInputDialog("count stop?  y/n");
        
        if(answer.toLowerCase().equals("y")) {
        	count.interrupt();
        	info="카운트를 멈춥니다.";
        }
        System.out.println(info);
        System.out.println("> main end....");
    }
}

//■ 힌트
//- Thread.sleep() 중 interrupt()가 호출되면 InterruptedException이 발생합니다.
//- catch 블록에서 break를 사용하면 반복문을 빠져나와 스레드를 종료할 수 있습니다.
//
//■ 출력 예시
//10
//count stop?  y/n
//9
//8
//y
//count를 멈춥니다.
//> main end....
//
//※ "y"를 입력한 시점 이후부터는 숫자 출력이 멈춥니다.
