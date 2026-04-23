package com.the703.basic010_ex;

class Student {
    String name = "홍길동";          // 인스턴스 변수 - heap 명시적 생성자 this
    int kor = 90;                  // 인스턴스 변수
    int eng = 85;                  // 인스턴스 변수
    static int studentCount = 0;   // 클래스 변수   - method
    static int total = kor + eng;  // 클래스 변수 ★ kor과 eng는 인스턴스 변수 / total은 클래스 변수
    							   //			  인스턴스는 객체 필요 	   / 클래스는 객체 없이 가능
    static int maxScore = 100;     // 클래스 변수

    public Student() {  		   // 인스턴스 메서드
        studentCount++;           
    }

    public int getTotalScore() {   // 인스턴스 메서드
        return kor + eng;          
    }

    public static void showStudentCount() {		// 클래스 메서드
        System.out.println("전체 학생 수: " + studentCount);  
    }

    public void showName() {					// 클래스 메서드 → 인스턴스 변수
         System.out.println(name);  			// ★ name은 인스턴스 변수 / showName()은 클래스 변수
    }	  

    public void showInfo() {					// 인스턴스 메서드
        System.out.println("이름: " + name);            
        System.out.println("총점: " + getTotalScore());    
    }
}


public class MemberVarEx002 {
    public static void main(String[] args) {
        Student s1 = new Student();     
        Student s2 = new Student();     

        s1.showInfo();                  
        Student.showStudentCount();    
    }
}

//////////////////////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
--------------------------------------------------------------------
[METHOD:정보] Student.class, MemberVarEx002.class #1
--------------------------------------------------------------------
[HEAP:동적]  			        					  |  [STACK:지역]
		
2번지 { name="홍길동", kor=90, eng=85 } 			←		s2(2번지)
1번지 { name="홍길동", kor=90, eng=85 }			←		s1(1번지)
														main #2
--------------------------------------------------------------------
*/
//////////////////////////////////////////////////////////////////////


//-- class Student 작성해주세요
//
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  
//			( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기