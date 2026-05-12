package com.the703.basic018_ex;

//문제 설명:  
//	Runnable을 활용하여 멘톨캔디를 1초마다 1개씩 판매하는 스레드를 구현하세요.  
//	Candy 클래스를 기반으로 MentolSeller 클래스를 만들고,
//  Thread를 직접 상속하지 않고 Runnable 인터페이스를 통해 멀티스레드를 구성합니다.

class Candy1 {
	String name;
	public void sell() {
		System.out.println(name + "가 1개 팔렸습니다.");
	}
}

class MentolSeller1 extends Candy implements Runnable {
	@Override
	public void run() {
//		- run() 메서드에서 1초마다 sell()을 호출하여 총 5번 판매합니다.
		for(int i=0; i<10; i++) {
			try { Thread.sleep(1000); }
			catch (InterruptedException e) { e.printStackTrace(); }
			sell();
		}
	}
}

public class ThreadEx003 {
	public static void main(String[] args) {
		System.out.println("..........main start");
		MentolSeller1 seller = new MentolSeller1();  
        seller.name = "멘톨캔디";  
        
        Thread t = new Thread(seller);  
        t.start();  

        for (int i=0; i<5; i++) {  
        	try { Thread.sleep(1000); }
        	catch (InterruptedException e) { e.printStackTrace(); }  
            System.out.println("  손님 기다리는 중.....");
        }  
        System.out.println("..........main end");
	}
}

//■ 힌트:
//- Thread.sleep(1000)은 1초 대기입니다.
//- Thread는 Runnable 구현체를 생성자에 전달받아 실행할 수 있습니다.
//- MentolSeller는 Thread를 상속할 수 없으므로 반드시 Runnable을 구현해야 합니다.