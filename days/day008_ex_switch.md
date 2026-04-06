

### ■2. Todo1: CSS기본
- 7. css(3) 가상선택자

선택자 :
- 일반태그 선택자   : p
- 아이디 선택자     : #id
- 클래스 선택자     : .class
- 가상선택자        :   :hover,    :first-child,   :last-child


### ■3. Todo2: java CONTROL - SWITCH


### ■4. 복습문제
■1. html + css

  1. css 선택자 - 태그선택자, 아이디선택자, 클래스선택자 , (         : 예  :hover, :first-child)
    태그선택자 -> p
    아이디선택자 -> #id
    클래스선택자 -> .class
    가상선택자 -> :hover,   :first-child,   :last-child

  2. 내부적용을 이용해서 다음 css를 적으시오. 
      h1 중앙정렬, 글자색상 : #34495e, 아래쪽여백 : 40px 
      h1{
        text-align: center;
        color: #34495e ;
        margin-bottom : 40px
      }
  
  3. 여러개의 div태그에 .portfolio라는 클래스를 적용하고  
    각각의 배경을다르게 설정하려고 한다.  .p1은 배경 red,    .p2는 gold 
    html 설정에 css를 적용하는 코드를 적으시오
    ```
    .p1 {
    background: red;
    }

    .p2 {
    background: gold;
    }

    <div class="portfolio p1"></div>
    <div class="portfolio p2"></div>
  ```
  
  4.    .portfolio마우스를 올렸을때    확대 + 회전 + 밝기 + 그림자 강조  css를 적으시오.
    .portfolio:hover {
      transform: scale(1.1) rotate(100deg)
      filter: brightness(1.05);
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.5);
    }

  5.   가상선택자의 종류는? 
    5-1.   마우스를 올렸을때 -> :hover 
    5-2.   부모안에서 첫번째 자식요소 -> :first-child
    5-3.   부모안에서 마지막 자식요소 -> :last-child

  6.   .portfolio ul태그의 첫번째 li를 선택해서 좋아하는 배경색으로 넣기
    .portfolio ul :first-child {
      background: skyblue;
    }
  

■2.  java

1. if 버젼
    1을 입력받으면 1이다   / 2를 입력받으면 2이다 / 3을 입력받으면 3이다.
    if (num == 1) {
      System.out.println("1이다")
    } else if (num == 2) {
      System.out.println("2이다")
    } else if (num == 3) {
      System.out.println("3이다")
    }

2. switch 버젼
    위의 내용을 switch 버젼으로
    switch(num) {
      case 1:
            System.out.println("1이다");
            break;

      case 2:
            System.out.println("2이다");
            break;

      case 3:
            System.out.println("3이다");
            break;
    }

3. 다음 무한반복을 빠져나오는 코드를 적으시오
      int a = -1;
      
      for(;;){ 
         System.out.println("빠져나오실래요?  0이면 종료");
         a = scanner.nextInt();
         if(a==0) { break; }
      }
출처: https://hi-sally03915.tistory.com/1954 [:DB:DBIG:티스토리]