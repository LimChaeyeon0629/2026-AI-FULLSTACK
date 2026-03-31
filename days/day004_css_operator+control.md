
### ■2. Todo: CSS 기본
- 5. CSS(1)
1. 배경: background
2. 글자: color
3. 글자크기: font-size
4. 정렬: text-align
5. 밑줄: text_decoration
6. 글꼴: font-family
7. 굵게: font-weight
8. 가로: width / 높이: height
9. 바깥여백: margin
10. 안쪽여백: padding
11. 선: border
12. 둥근모서리: border-radius
13. 그림자효과: box-shadow

※ 여백 가운데 위치 - margin: auto;
※ 밑줄 제거: text_decoration: none;

※ 페이지 가운데 정렬 → margin: auto;
※ 텍스트 가운데 정렬 → text-align: center;
※ 원형 이미지 50% → border-radius: 50%
※ margin: 0 auto; (0 = 위아래, auto= 좌우)

※ background: linear-gradient(135deg, #color, #color) no-repeat;
※ background-image: url(./)



### ■3. Todo: JAVA




### ■4. 복습문제

- 1. css(1)
1. 배경 :  background
2. 글자 :  color
3. 글자크기 :  font-size
4. 정렬 :  ( text-align )
5. 밑줄 :  ( text-decoration )
6. 글꼴 :  font-family
7. 굵게 :  ( font-weight )
8. 가로 :  width / 세로 : height
9. 바깥쪽여백:  margin
10. 안쪽여백:  padding
11. 선 : border
12. 둥근모서리 :  border-radius
13. 그림자효과 :  box-shadow

- 2. java
  1. 자바의 자료형 분류( 기본형 / 참조형 )
  2. 기본형 : 값
    2-1 논리형 : boolean  - true/false (1byte)   
    2-2 정수형 : byte(1) - short(2) - int(4) - long(8, L)
    2-3 실수형 : float(4, f) - double(8)
    2-4 문자형 : char 저장할 때 문자 / int 출력시 숫자
  3. 자동형변환은 ( boolean )  빼고  ( byte, short, int, long, char ) 기본형


- 3. java [실습]
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int ) 

  Scanner sc = new Scanner(System.in);
  int num1 = -1, num2 = -1;
  double result;

  System.out.print("num1 입력: ");
  num1 = sc.nextInt();
  System.out.print("num2 입력: ");
  num2 = sc.nextInt();

  result = (double)num1 / num2;

  System.out.printf("%.2f", result);
   
   10 / 3 = 3.33

주어진조건 : 
      //변수
      int num1, num2;
      double result;
      Scanner scanner = new Scanner(System.in);