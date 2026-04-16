package com.the703.basic008_ex;

public class Array2Total {
   public static void main(String[] args) {
      // 변수 + 입력
      int arr [] = new int[5];
      String name [] = { "아이언맨", "헐크", "캡틴", "토르", "호크아이" };
      int kor [] = { 100, 20, 90, 70, 35 };
      int eng [] = { 100, 50, 95, 80, 100 };
      int math [] = { 100, 30, 90, 60, 100 };
      int avg [] = new int[5];
      int top [] = new int[5]; // 등수
      String pnp [] = new String[5]; // 합격여부
      String j [] = new String[5]; // 장학생
      String rank [] = new String[] {"" , "", "", "", ""}; // 랭킹 (String : *)
      
      int data = 0;

      // 처리
      for (int i = 0; i < arr.length; i++) {
         avg[i] = (kor[i] + eng[i] + math[i]) / 3;
         pnp[i] = avg[i] < 60 ? "불합격" : "합격";
          j[i]   = avg[i] >= 95 ? "장학생" : "";
      }
      
//          rank[i] = (avg[i] / 10); // 랭킹
      //  1)   avg[i] / 10 갯수만큼    * 누적
      //  2)   for( 시작; avg[i] / 10 갯수만큼; 변화   ) {* 누적}
      for (int i = 0; i < arr.length; i++) {   
         for (int a = 0; a < 10; a++) {
            rank[i] += "*";
         }
         
          
      }
      
      for (int i = 0; i < arr.length; i++) {             
           for (int k = 0; k < arr.length; k++) {
              //top[k] =
              }
          
          arr[i] = data;
          data += 1;
          System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", name[i], kor[i], eng[i], math[i], avg[i], top[i], pnp[i], j[i], rank[i]);
      }

      System.out.println("이름\t국어\t영어\t수힉\t평균\t등수\t합격여부\t장학생\t랭킹");
      
   } 
}

//          switch (avg[i]/10) { 
//               case 10: rank[i] = "**********"; break; 
//               case 9: rank[i] = "*********"; break; 
//               case 8: rank[i] = "********"; break; 
//               case 7: rank[i] = "*******"; break; 
//               case 6: rank[i] = "******"; break; 
//               case 5: rank[i] = "*****"; break; 
//               case 4: rank[i] = "****"; break; 
//               case 3: rank[i] = "***"; break; 
//               case 2: rank[i] = "**"; break; 
//               case 1: rank[i] = "*"; break;
//          }