package com.the703.basic013_ex;

/*
1) 상속도
           Object
             ↑
           Robot { abstract charge(), move(), speak() }
	   ↑              ↑               ↑ 
   	CleaningRobot   SecurityRobot   CookingRobot   
	{@charge() ,    {@charge() ,    {@charge() ,
	 @ move() ,      @move() ,       @move() , 
	 @ speak() }}    @speak() }}     @speak() }}

*/

abstract class Robot {
	String model;
	int battery;
	abstract void charge();
	abstract void move();
	abstract void speak();
}

class CleaningRobot extends Robot {
	@Override void charge() { System.out.print(super.model + " 청소로봇 충전 중..."); }
	@Override void move()   { System.out.println(" 배터리 " + super.battery + "%"); }
	@Override void speak()  { System.out.println(super.model + "청소로봇: 먼지를 제거합니다!"); }
}

class SecurityRobot extends Robot {
	@Override void charge() { System.out.print(super.model + " 경비로봇 태양광 충전 중..."); }
	@Override void move()   { System.out.println(" 배터리 " + super.battery + "%"); }
	@Override void speak()  { System.out.println(super.model + " 경비로봇: 이상 없음. 안전 확보!"); }
}

class CookingRobot extends Robot {
	@Override void charge() { System.out.print(super.model + " 요리로봇 인덕션 충전 중..."); }
	@Override void move()   { System.out.println(" 배터리 " + super.battery + "%"); }
	@Override void speak()  { System.out.println(super.model + " 요리로봇: 오늘의 메뉴는 파스타입니다!"); }
}


public class AbstractEx001 {
	public static void main(String[] args) {
		//Robot robot  = new Robot();  // Q1.why? 오류이유? - abstract 클래스
		
	    System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
	    Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
	    int [] levels = { 50, 70, 95 };
	    int cnt = 0;
	    		
//	    bots[0] = 1번지 CleaningRobot {				   @charge(), @move(), @speak() } -
//	    					   Robot { model; battery; ---------, -------, -------- }
//	    bots[1] = 2번지 SecurityRobot {				   @charge(), @move(), @speak() } -
//	    					   Robot { model; battery; ---------, -------, -------- }
//	    bots[2] = 3번지  CookingRobot {				   @charge(), @move(), @speak() } -
//	    					   Robot { model; battery; ---------, -------, -------- }
	    
	    /* 1번지 
	    bots[0].model = "Robo" + cnt++; // Robo1
	    bots[0].battery = levels[0];	// 50
	    
	    bots[0].charge();
	    bots[0].move(); // { System.out.println( bots[0].battery + "%" ); };
	    bots[0].speak();
		*/
	    
//	    for ( Robot a : bots ) { // bots 배열의 클래스 Robot을 a로 명시
	    	for(int i=0; i<bots.length; i++) {
	    		bots[i].model = "Robo" + (i+1); // Robo1 Robo2 Robo3
	    		bots[i].battery = levels[i];	// 50	 70	   95
	    		
	    		bots[i].charge();
	    		bots[i].move();
	    		bots[i].speak();
	    	}
//	    	a.charge();
//	    	a.move();
//	    	a.speak();
//	    }
	    
//	    출력화면 :  
//    	--- 로봇 배열 시뮬레이션 ---
//    	Robo1 청소로봇 충전 중... 배터리 50%
//    	Robo1 청소로봇: 먼지를 제거합니다!
//    	Robo2 경비로봇 태양광 충전 중... 배터리 70%
//    	Robo2 경비로봇: 이상 없음. 안전 확보!
//    	Robo3 요리로봇 인덕션 충전 중... 배터리 95%
//    	Robo3 요리로봇: 오늘의 메뉴는 파스타입니다!
	}
}
