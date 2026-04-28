package com.the703.basic013_ex;

/*
	Animal { sound() }						← ZooKeeper
	↑							↑							↑
	Dog							Cat							Bird
	{ @sound(), playFetch() }	{ @sound(), playFetch() }	{ @sound(), fly() }

*/

interface Animal { public void sound(); }

class Dog implements Animal {
   @Override
   public void sound() {
      System.out.println("멍멍!");
   }
   public void playFetch() {
      System.out.println("강아지가 공을 물어옵니다.");
   }
}

class Cat implements Animal {
   @Override
   public void sound() {
      System.out.println("야옹~");
   }
   public void scratch() {
      System.out.println("고양이가 발톱을 세웁니다.");
   }
}

class Bird implements Animal {
   @Override
   public void sound() {
      System.out.println("짹짹!");
   }
   public void fly() {
      System.out.println("새가 하늘을 납니다.");
   }
}

class ZooKeeper {
	public void show(Animal ani) {
		ani.sound();
		
		if(ani instanceof Dog) {		 // playFetch()
			((Dog)ani).playFetch();
		} else if(ani instanceof Cat) {	 // scratch()
			((Cat)ani).scratch();
		} else if(ani instanceof Bird) { // fly()
			((Bird)ani).fly();
		}
		
	}
}

public class InterfaceEx003 {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		Animal [] anis = { new Dog(), new Cat(), new Bird() };
		//                 anis[0]		anis[1]		anis[2]
		ZooKeeper keeper = new ZooKeeper();

	    while (true) {
	       System.out.println("=== 동물원 메뉴판 ===");
	       System.out.println("1. 강아지");
	       System.out.println("2. 고양이");
	       System.out.println("3. 새");
	       System.out.println("0. 종료");
	       System.out.print("선택: ");
	       int choice = sc.nextInt();

	       if (choice == 0) {
	          System.out.println("동물원 관람을 종료합니다.");
	          break;
	       }

	       Animal animal = null;
	       
	       if(choice>=1 && choice<=3) {
//	    	   anis[choice-1].sound(); // sound()
//	    	   keeper.show(animal);    // playFetch() scratch() fly()
	    	   keeper.show(anis[choice-1]);    // sound() playFetch() scratch() fly()
	       
	       } else { System.out.println("잘못된 선택입니다.\n"); }
	       
	       
//	       switch (choice) {
//	          case 1: animal = new Dog(); break; // 부모 = 자식 (업캐스팅)
//	          case 2: animal = new Cat(); break; // 부모 타입으로 메서드 호출 시 오버라이드 된 최신 자식 메서드가 호출
//	          case 3: animal = new Bird(); break;
//	          default: System.out.println("잘못된 선택입니다.\n"); continue;
//	       }
	       
	       // animal { sound } = [1번지] { @sound(), playFetch() } - { ------ }
	       // animal { sound } = [2번지] { @sound(),   scratch() } - { ------ }
	       // animal { sound } = [3번지] { @sound(),       fly() } - { ------ }

	       // ZooKeeper 클래스의 show() 메서드 호출
//	       ZooKeeper keeper = new ZooKeeper();
//	       keeper.show(animal); // sound() playFetch() scratch() fly()
//	       System.out.println();
	       
	    }
	    sc.close();
	    
		//=== 동물원 메뉴판 ===
		//1. 강아지
		//2. 고양이
		//3. 새
		//0. 종료
		//선택: 1
		//멍멍!
		//강아지가 공을 물어옵니다.
		//
		//선택: 2
		//야옹~
		//고양이가 발톱을 세웁니다.
		//
		//선택: 3
		//짹짹!
		//새가 하늘을 납니다.
		//
		//선택: 0
		//동물원 관람을 종료합니다.

	}
}