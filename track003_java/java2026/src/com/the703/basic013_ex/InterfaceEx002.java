package com.the703.basic013_ex;

/*
	Vehicle { run() }			← Driver
	↑				↑			  { 	}
	MotorCycle		Car
	{ @run() }		{ @run() }

*/

interface Vehicle { public void run(); }

class MotorCycle implements Vehicle {
   @Override
   public void run() {
      System.out.println("오토바이가 달립니다.");
   }
   public void helmet() {
	   System.out.println("헬멧을 착용합니다.");
   }
}

class Car implements Vehicle {
   @Override
   public void run() {
      System.out.println("자동차가 달립니다.");
   }
   
   public void handle() {
	   System.out.println("운전대를 잡습니다.");
   }
}

//1. Driver 클래스를 작성하시오.  
class Driver {
	public void drive(Vehicle v) { // Vehicle v = car, Vehicle v = mo
		v.run(); // 기본 다형성 동작 - @Override 된 자식 메서드
		
		// 만약에 모터사이클이라면 helmet() 호출
		if(v instanceof MotorCycle) { ((MotorCycle)v).helmet(); }
		
		if(v instanceof Car) { ((Car) v).handle(); }
	}

//	public void drive(Car car) {
//		car.run();
//	}
//
//	public void drive(MotorCycle mo) {
//		mo.run();
//	}
}

public class InterfaceEx002 {
	public static void main(String[] args) {
		Driver driver = new Driver();
	      
		Car car = new Car();
		MotorCycle mo = new MotorCycle();
		
		Vehicle [] vh = { new Car(), new MotorCycle() };
//							vh[0]			vh[1]
		for(int i=0; i<vh.length; i++) {
			driver.drive(vh[i]); // 클래스.메서드명(배열명[배열 순서])
		}
		
//		↑
		// Car
//		vh[0].run();
//		((Car)vh[0]).handle();
		
		// MotorCycle
//		vh[1].run(); 
//		((MotorCycle)vh[1]).helmet();
		
		
		
// 리턴값 	  .메서드명(파라미터) { }
//			   		 car, mo 두 개의 값을 다 담을 수 있는 자료형 (부모 = 자식)
// void 	   drive(Vehicle v)
//		driver.drive(car); // 자동차가 달립니다.
//		driver.drive(mo);  // 오토바이가 달립니다.
		
//		Vehicle [] vh = { new Car(), new MotorCycle() };
//		for( Vehicle v : vh ) {
//			v.run();
//		}
		
		
		
//		4. 실행화면
//		자동차가 달립니다.
//		오토바이가 달립니다.
	}
}

