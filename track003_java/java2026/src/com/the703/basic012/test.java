package com.the703.basic012;

class Driver {
//    public void drive(Car car) {
//        car.run();
//    }
//    public void drive(MotorCycle mo) {
//    	mo.run();
//    }
    public void drive(Vehicle v) {
    	v.run();

    	if(v instanceof MotorCycle) {
			((MotorCycle)v).helmat();
		}
    }
    
}

interface Vehicle {  public void run();    } 

class MotorCycle implements Vehicle {
    @Override public void run() {   System.out.println("오토바이가 달립니다.");   }
    public void helmat()        {   System.out.println("헬멧을 착용합니다.");     }
}

class Car implements Vehicle {
    @Override public void run() {     System.out.println("자동차가 달립니다.");   }
}

public class test{
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
      driver.drive(car);
      driver.drive(mo);
   }
}
