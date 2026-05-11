package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. Dto 데이터전송목적
class BankDto{
   private String id;
   private String pass;
   private double balance;
   
   public BankDto() { super(); }
   public BankDto(String id, String pass, double balance) { super(); this.id = id; this.pass = pass; this.balance = balance; }
   @Override public String toString() { return "BankDto [id=" + id + ", pass=" + pass + ", balance=" + balance + "]"; }
   
   @Override public int hashCode() { return Objects.hash(balance, id, pass); }
   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      BankDto other = (BankDto) obj;
      return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
            && Objects.equals(id, other.id) && Objects.equals(pass, other.pass);
   }
   
   public String getId() { return id; }
   public void setId(String id) { this.id = id; }
   public String getPass() { return pass; }
   public void setPass(String pass) { this.pass = pass; }
   public double getBalance() { return balance; }
   public void setBalance(double balance) { this.balance = balance; }
}

class Bank {
   List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
   Scanner sc = new Scanner(System.in);
   
   public Bank() { super(); }
   public Bank(List<BankDto> users) { super(); this.users = users; }
   
   // 메뉴 - 안에 내용작성
   public void menu() {
      int menu = -1;
      String id   = "", pass="";
      double balance=-1;
      
      System.out.println("🌟💰 WELCOME TO BANK SYSTEM 💰🌟");

      for(;;) {      // while (menu!=9) {      //for( ;menu!=9; ) {
         System.out.println( id + "\t" + pass + "\t" + balance);  // 계좌의 1명분  확인용
         System.out.print("\n======BANK======\n"
                    + "[1] ➕ 계좌 추가\n"
                    + "[2] 🔍 계좌 조회\n"
                    + "[3] 💵 입금하기\n"
                    + "[4] 💸 출금하기\n"
                    + "[5] 🗑️ 계좌 삭제\n"
                    + "[9] 💀 종료\n"
                    + "👉 번호를 선택하세요: ");
         menu = sc.nextInt();
         
         if (menu == 9) {
            exit();
            
         } else if (menu == 1) {
            add();
            
         } else if (menu >= 2 && menu <= 5) {
        	 if(users.size() == 0) { System.out.println("아직 등록된 유저가 없습니다."); continue; }
        	 
        	 idpwcheck();
            
            switch (menu) {
               case 2: inquiry(); break;
               case 3: deposit(); break;
               case 4: withdraw(); break;
               case 5: userdelete(); break;
            }
         
         } else { System.out.println("메뉴판 숫자 1~5, 9 중에 입력해주세요"); break; }
      }
   }   
   
   // 유저추가  (add)
   public void add() {
      //변수
	  String id = null;
	  String pass = null;
	  Double balance = 0.0;
      
      //입력 - 사용자에게 정보입력받기
      System.out.println("아이디 입력: ");
      id = sc.next();
      System.out.println("비밀번호 입력: ");
      pass = sc.next();
      System.out.println("잔액 입력: ");
      balance = sc.nextDouble();
      
      //처리 
//      users.add( new BankDto("aaa", "pass", 1) );
      users.add( new BankDto(id, pass, balance) );
      
      //출력
      System.out.println("아이디: " + id + "\n비밀번호: " + pass + "\n추가 완료!");
   }
   
   // 조회 (contains)
   public void inquiry() {
      System.out.printf("ID: %s\nPW: %s\n잔액: %d\n", id[find], pass[find], balance[find]);
   }
   
   // 입금   (get)
   public void deposit() {
      System.out.print("입금: ");
      money = sc.nextInt();
      balance[find+1] += money;
      System.out.println("💵 입금완료");
      System.out.println("잔액: " + balance[find]);
   }
   
   // 출금   (get)
   public void withdraw() {
      System.out.print("출금: ");
      money = sc.nextInt();
      System.out.println( money > balance[find] ? "출금불가" : "출금완료! 잔액: " + (balance[find] -= money));
   }
   
   // 유저삭제(remove)
   public void userdelete() {
      System.out.println("계좌를 삭제하시겠습니까? (y/n)");
      answer = sc.next();
      
      if (answer.equals("y")) {
         id[find] = "";
         pass[find] = "";
         balance[find] = -1;
         System.out.println("🗑️ 계좌 삭제 완료");
         break;
         
      } else if (answer.equals("n")) {
         continue;
         
      } else { System.out.println("(y/n)을 입력해주세요.");}
   }
   
   // 종료
   public void exit() {
      System.out.println("프로그램을 종료합니다.");
      return;
   }
   
   // 아이디 확인
   public void idpwcheck() {
	   String tid = "", tpw = "";
	   System.out.print("아이디 입력: "); tid = sc.next();
	   System.out.print("비밀번호 입력: "); tpw = sc.next();
		
	   System.out.println(tid);
	   // tid가 id랑 같지 않음 || tpw가 pass랑 같지 않음
	   if (!tid.equals(id[find]) || !tpw.equals(pass[find]))
	   { System.out.println(tid); System.out.println(tpw);
	   System.out.println(id[find]); System.out.println(pass[find]); // null
	   System.out.println("잘못 입력하셨습니다"); break; }
   }
}

public class BankCollection {
   public static void main(String[] args) {
      List<BankDto>  users = new ArrayList<>();
      Bank      controller = new Bank(users);
      controller.menu();
      
      //테스트용
      //      controller.add();
      //      System.out.println(controller.users);
   }
}




