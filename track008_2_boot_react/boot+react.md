
1. CSR vs SSR
- SSR : 서버가 웹페이지에 렌더링, 초기속도 빠름 / 서버 부하가 커지고 깜빡임
- CSR : 브라우저가 웹페이지를 렌더링, 초기속도 느림 / 부드러운 화면, 화면바뀜이 빠름

2. 기술스택 - SSR + CSR
[PROJECT]                           mybatis에서 서브쿼리 < 조인
ㄴ BACK :   boot  + jpa  + oracle + (mybatis) + jwt + redis
ㄴ FRONT :  react + next + antd

### 1. BACK
1. JAVA 17
2. SPRING BOOT (gradle)
3. security + jwt + redis + oauth2.0 + jpa + mybatis + oracle

1) spring boot     - 애플리케이션 기반의 프레임워크 / 내장 tomcat / 자동설정
2) spring security - 인증(본인 맞는지 확인), 인가(접근권한 어디까지 허용)
                    / 필터체인의 요청 보호 / oauth2.0(외부인증 - 카카오, 네이버, 구글)와 쉬운 연동
3) mybatis         - xml sql 복잡한 쿼리 작성
4) jwt             - json web token / 토큰 기반의 인증방식
                     토큰 안에 사용자의 정보와 권한을 담아서 전달,
                     서버가 세션을 직접 관리하지 않고,
                     클라이언트가 토큰을 보관
5) redis           - 캐시/세션을 관리 , refresh token을 저장,
                     캐싱처리(자주사용하는 값을 redis에 미리 넣어놓고 요청 시 서버 거치지 않고 빠르게 제공)에 활용

                        사용자 화면
                          redis
                     a      b       c

6) jpa             - sql 작성없이 객체 중심의 데이터 처리


1.  SPRING boot  → 애플리케이션 실행기반
2.  SPRING security + jwt/oauth2.0   → 인증/인가 처리
3.  redis   →  토큰/세션/캐시관리
4.  jpa + mybatis  → 데이터베이스 접근 (orm + sql mapper 병행)


##### [실습]  1. 스프링부트 프로젝트 
- [ ] 1. 개발개요안내
- [ ] 2. java.sun.com - JAVA 17 다운로드 - 설치
- [ ] 3. SPRING BOOT   - https://spring.io/ - 다운로드 - 설치
  > 이전버젼 (다운로드)
  https://github.com/spring-projects/spring-tools/wiki/Previous-Versions
- [ ] 4. SPRING BOOT 프로젝트 만들기
- [ ] 5. lombok

##### [실습]  2. docker 설치
1. docker 설치 (AMD.ver)
- https://www.docker.com/products/docker-desktop/
- 다운로드 및 설치 → 1. window 업데이트 / 2. USE WSL 2 instead.... 체크확인

```bash
wsl -- update
```
```
docker --version
docker ps
```

```spring
dynamic 사라짐 => spring starter project
name - boot0
java 버전 - 17
패키지명 - com.thejoa703
spring web / lombok 다운로드
```

```cmd
dir
C:\>java -jar lombok-1.18.18.jar
C:\>java -jar lombok-1.18.32.jar
```


2. redis 설치
```
docker ps
```

```
docker pull  redis
docker run   -d  --name  my-redis  -p 6379:6379   redis

docker  exec  -it  my-redis  redis-cli
docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```

```필기
docker pull  redis
-- 최신버전 redis 다운로드

docker run      -d          --name  my-redis    -p 6379:6379   redis
-- 생성 및 실행   백그라운드    생성될 이름         내컴퓨터6379 번호로 내부에 6379로 연결

docker  exec    -it                     my-redis  redis-cli
--      실행    i:표준입력, t:가상터미널

docker  exec  -it  my-redis  redis-cli  FLUSHALL
keys *
get  저장이름
```


1. JWT  VS  세션
- 세션 : 서버 메모리에 사용자 상태를 저장 →  서버확장시 부담  
                                    (서버에서 출입명단 직접 들고 있는 것)
- JWT(Json Web Token) : 토큰 자체에 인증정보를 포함  → 확장성
                                    (사용자가 출입증을 직접 들고다니기)

2.  Access  Token vs  Refresh Token 
1) Access  Token :  짧은 기간 유효(출입증)    → api 호출 시 사용    
2) Refresh Token :  긴   기간 유효(장기체류증) →  redis 냉장고에 안전보관   

3. Redis 사용이유?
- 토큰냉장고 → 장기체류증 안전하게 보관, 필요시 꺼내 씀
- Refresh Token 중앙에서 관리
- TTL(만료 시간)로 자동 만료처리
- 로그아웃 시 즉시 삭제



##### [실습]  3. oracle 유저만들기
id: boot / pass: react   

```sql
-- cmd
-- sqlplus
-- conn system/1234
-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user boot  identified by react;

-- 권한부여
grant  connect , resource  to boot;

ALTER USER boot DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to boot;
-- conn boot/react
```


##### [실습]  4. Boot + React  - ver1 (기본게시판 + 회원가입)

1. board
- [ ] 1. project
- [ ] 2. 부품객체 () : gradle
  ※ https://mvnrepository.com/
- [ ] 3. application.yml
```
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521/XE      # jdbc url 설정
    username: boot                                # 사용자계정
    password: react                               # 비밀번호
    driver-class-name: oracle.jdbc.OracleDriver   # oracle, mysql, h2 ,,,

  jpa:
    hibernate:
      ddl-auto: update      # 엔티티 변경사항 db테이블 자동으로 변경사항반영
                            # update: 수정반영, 기존데이터 유지 / create-drop: 생성 후 삭제, 매번 초기화
                            # 배포할 때는 none (기본), validate
    properties:
      hibernate:
        format_sql: true    # 콘솔 및 로그에 출력되는 sql 들여쓰기 속성
        show_sql: true      # sql 쿼리 문장을 그대로 로그 출력

  servlet:
    multipart:
      enabled: true           # 파일업로드처리 기능 활성화
      max-file-size: 10MB     # 업로드하는 최대허용용량
      max-request-size: 20MB  # 한번에 전송되는 총 용량

  data:
    redis:
      host: localhost         # redis 연결주소 
      port: 6379              # 서버포트
      timeout: 2000           # 서버와 연결 대기시간

  config:
    import: 
      - optional:application-oauth.yml    # api 설정관련
      - optional:file:.env[.properties]   # .env 파일 실제 보관키


mybatis:
  config-location: classpath:mybatis-config.xml   # 전역설정파일
  mapper-locations: classpath:mapper/**/*.xml     # 맵퍼 경로패턴
  type-aliases-package: com.thejoa703.domain      # 도메인설정

jwt:
  issuer: thejoa703                     # jwt 토큰 발행한 주체자
  secret: ${JWT_SECRET}                 # 사용할 비밀키 - 외부환경변수에서 불러와서 설정
  access-token-exp-seconds: 900         # 유효시간
  refresh-token-exp-seconds: 1209600
  header: Authorization                 # 토큰 전달 시 http요청헤더 이름 지정
  prefix: Bearer                        # 토큰 앞에 붙는 이름 (접두사)

file:
  upload-dir: uploads   # 업로드된 파일설정경로

#server:
#  port: 8484
```

  ※ (oracle db:table) → mapper → dto → service → controller → view
  @Entity → repository → dto → service → controller → view
- [ ] 4. entity  ( 테이블을 객체로 처리 )
  back1
    ㄴsrc/main/java
      ㄴcom.thejoa703.entity
        - AppUser
        - Post

  A. JPA
    - ORM(Object-Relational Mapping)
    부품객체(자바클래스)와 RDB(관계형데이터베이스)의 불일치 해결하려고
    SQL중심이 아니라 객체중심으로 데이터를 다룰 수 있게 해주는 기술

    - 1. @Entity   DB의 테이블과 맵핑
    - 테이블컬럼변경 시 SQL을 일일히 수정할 필요없이 엔티티클래스만 수정
    - 데이터베이스 방언(Dialect) 지원 - oracle(sequence), mysql(auto increment) 특정데이터에 종속x

    - 2. JpaRepository - db에 접속해서 crud 작업을 처리하는 인터페이스
    - 3. 외래키설정
      > 한 사람이 여러 글을 쓸 수 있다

      > AppUser
      @OneToMany

      > Post
      @ManyToOne


- [ ] 5. Repository (mapper)
  back1
    ㄴsrc/main/java
      ㄴcom.thejoa703.repository
        - AppUserRepository
        - PostRepository

  https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

- [ ] 6. Dto - RequestDto / ResponseDto 한 클래스 안에 묶어서 작성
  back1
    ㄴsrc/main/java
      ㄴcom.thejoa703.dto
        - UserDto
        - PostDto

- [ ] 7. Service
  back1
    ㄴsrc/main/java
      ㄴcom.thejoa703.service
        - UserService
        - PostService

7-1. 클래스 명   : UserService (package com.thejoa703.service;)
  메서드 명
- createUser   (회원가입 / 사용자 등록 기능)
- getUser      (사용자 단건 조회 기능)

7-2. 클래스 명   : PostService
- getAllPosts  (모든 글)
- getPostById  (단건 조회)
- getPostPaged (오라클 네이티브 페이징 조회)
- createPost   (게시글 생성)
- updatePost   (게시글 수정)
- deletePost   (게시글 삭제)

- [ ] 8. Controller
  back1
    ㄴsrc/main/java
      ㄴcom.thejoa703.controller
        - UserController
        - PostUserController

  1. User Api    - 사용자 관련 API
  - POST    /api/users        회원가입
  - GET     /api/users/{id}   사용자 단건조회

  2. Post API     - 게시글 관련 API
  - GET     /api/posts/{id}   게시글 단건 조회   ※ getPostById
  - PUT     /api/posts/{id}   게시글 수정       ※ updatePost
  - DELETE  /api/posts/{id}   게시글 삭제       ※ deletePost
  - GET     /api/posts        전체 게시글 조회   ※ getAllPosts, getPostPaged
  - POST    /api/posts        게시글 작성       ※ createPost



- [ ] 9. View

1. 회원가입
    ↓
2. 마이페이지
    ↓
3. 글쓰기
    ↓
4. 글수정
    ↓
5. 글삭제



front/
├── .next/                  # Next.js 빌드 결과물 (자동 생성, 배포 시 사용) ## 빼고
├── components/             # 재사용 가능한 UI 컴포넌트 폴더
│   └── AppLayout.js           # 페이지 공통 레이아웃 컴포넌트
├── node_modules/           # 설치된 npm 패키지들                         ## 빼고
├── pages/                  # Next.js 라우팅 기반 페이지 폴더
│   ├── posts/             
│   │  └──new.js            # 글쓰기 파일
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── join.js             # 회원가입
│   ├── mypage.js           # 마이페이지
│   └── index.js            # 메인 페이지
├── reducers/               # Redux 리듀서 폴더
│   ├── __tests__/       
│   │  ├── post.test.js     # 게시판 테스트 코드 
│   │  └── user.test.js     # 리듀서 테스트 코드
│   ├── index.js            # 루트 리듀서 (combineReducers)
│   ├── authReducer.js      # 사용자 관련 리듀서
│   └── postReducer.js      # 게시판 관련 리듀서 
├── sagas/                  # Redux-Saga 폴더
│   ├── __tests__/       
│   │  ├── post.test.js     # 게시판 사가 테스트 코드
│   │  └── user.test.js     # 유저 사가  테스트 코드
│   ├── index.js            # 루트 사가
│   ├── authSaga.js         # 사용자 관련 사가
│   └── postSaga.js         # 게시판 관련 사가 
├── store/                  # Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
├── styles/                 # CSS 스타일 폴더
│   └── globals.css         # 글로벌 스타일
├── .babelrc                # Babel 설정 파일
├── .eslintrc               # ESLint 설정 파일
├── package-lock.json       # npm 의존성 잠금 파일
├── package.json            # 프로젝트 메타 정보 및 의존성
└── setupTests.js           #  테스트 환경 설정 파일


Step1) 프로젝트만들기
```
mkdir front
rmdir front - 리눅스
mkdir front1
cd front1
npm init
```

Step2) 기본셋팅 (store)
```
ls
package.json 셋팅
```

```
npm install
```



Step3) reducer
Step4) saga
Step5) view
1. Layout
2. 경로
```
├── pages/                  # Next.js 라우팅 기반 페이지 폴더
│   ├── posts/             
│   │  └──new.js            # 글쓰기 파일
│   ├── _app.js             # 전체 앱의 공통 설정 (Redux Provider, 글로벌 스타일 등)
│   ├── signup.js           # 회원가입
│   ├── mypage.js           # 마이페이지
│   └── index.js            # 메인 페이지
```
<Link href="/">             index.js        # 메인 페이지
<Link href="/mypage">       mypage.js       # 마이페이지
<Link href="/signup">       signup.js       # 회원가입
<Link href="/posts/new">    posts/new.js    # 글쓰기 파일
````


## (1): 회원가입 + board (crud)
## (2): 멤버기능 + board (이미지업로드, 해시태그, 좋아요)
boot2  - 프로젝트만들기
- table   → mapper      → service   → controller
- @Entity → repository  → service   → controller

1) 유저는 많은 글을 쓸 수 있다.
<AppUser>   →   <Post>

<AppUser>
@OneToMany( mappedBy = "user" ,cascade = CascadeType.ALL, orphanRemoval = true )
private List<Post> posts = new ArrayList<>(); 

<Post>
@ManyToOne   //1. 다대일 (테이블필드명)
@JoinColumn(name="APP_USER_ID" , nullable = false)
private AppUser user; 

2) 글은 많은 이미지를 갖는다.
<Post>      →   <Image>
```
  <Post>
  @OneToMany

  <Image>
  @ManyToOne
```

3) 글은 많은 해시태그를 갖는다.   / 해시태그는 많은 글을 갖는다.
  1) 다:다
  2) 중간테이블
<Post>      →   <Hashtag>
@ManyToMany

<Hashtag>   →   <Post>

<Post>            <Hashtag>
content           1 test123
deleted            like

      <Post_Hashtag>

          1   1
          1   2
          2   1
          2   2
        1번글 test123
        1번글 like

4) 글은 많은 좋아요를 갖는다.
<Post>                                <POST_LIKE>
@OneToMany List<POST_LIKE> likes;     @ManyToOne AppUser user;
@OneToMany List<POST_LIKE> likes;     @ManyToOne Post    post;


        좋아요번호  글번호    유저번호
        1         1         1
        2         1         2
        3         1         3
        4         2         2
        5         2         3


5) 리트윗
5) 팔로우


front2 - 프로젝트복사하기

/////////////////////////////////////////////////////////////////////////
■ 과정명   : [취업기업확대]AI활용 풀스택(프론트엔드,백엔드)부트캠프(자바,파이썬,플러터)
■ 훈련과목 : (비NCS)프로젝트(완성된 웹서비스 플랫폼 프로젝트 리뉴얼)
> boot + security + jwt + redis / jpa( mybatis ) +oracle / react + next     → aws

[4] Dto / Service
- table     → mapper      (dto)     → service     → controller
- @Entity   → repository  (dto)     → service     → controller

■ 멤버관리
회원가입  (이메일중복검사, 닉네임중복검사)
  ↓
로그인    (로그아웃)
  ↓
마이페이지 (닉네임변경, 프로필이미지변경, 회원탈퇴, 로그아웃)   ※ 팔로워 / 팔로잉

1) UserDto: userRequestDto / userResponseDto
userRequestDto  < email, password, nickname, ☆image(ufile: MultiPart 빠짐)  /  provider, mobile, mbtiTypeId >
userResponseDto < email, role,     nickname,   ufile  /  provider, mobile, mbtiTypeId >

2) LoginRequest < email, password, provider,  />



■ 게시글관리
게시글작성
  ↓
게시글목록 ( 전체글 / 좋아요한글 / 내글+리트윗 )
※ 1. 각 세부내용, 수정, 삭제
※ 2. 좋아요, 리트윗, 댓글



[5] RestController

> Ver2, frontend

1. 프로젝트 만들기 (npm init)
```
mkdir front2
cd    front2
npm init
```

2. 프로그램 설치 (npm install)
```
npm install
```

3. 개발
1) reducer
2) saga
3) page



##### [실습]  5. Boot + React + 세션/쿠키  - ver2 (기본게시판 + 회원가입 + 이미지 / 해시태그 / 좋아요 / 팔로우)


※ entity → repository → service → controller

1. boot - 두번째
  1) 포폴1 - 옮기기 (리뉴얼)
          1. 프로젝트
          2. 테이블구성 @Entity
          3. repository / mybatis 셋팅
          4. service (재활용)
          5. RestController

  2) 포폴2 - 새롭게 구성되는 파트





##### [실습]  6. Boot + React + jwt + security + redis  - ver3 (기본게시판 + 회원가입 + 이미지 / 해시태그 / 좋아요 / 팔로우)

STEP1)
```
[사용자]
   ├─▶ 로컬 회원가입/로그인
   │       - 이메일/비밀번호(local) → DB 저장
   │       - 로그인 성공 시 JWT 발급
   │
   └─▶ 소셜 로그인(OAuth2)
           - 구글/카카오/네이버 인증
           - OAuth2SuccessHandler 실행
             • 사용자 정보 추출
             • DB 저장/조회
             • Access Token 발급 (출입증)
             • Refresh Token 발급 (장기체류증) → Redis 저장 + 쿠키
```

STEP2)
```
[프론트엔드]
   └─▶ Access Token localStorage 저장
        API 호출 시 Authorication 헤더에 Bearer 붙임
```

STEP3)
```
[Spring Boot 서버]
   ├─▶ JwtAuthenticationFilter
   │       - 토큰 검증 (출입증 검사)
   │       - SecurityContext에 사용자 정보 저장
   │
   └─▶ Controller/Service
           - userId 기반 DB 조회
           - 응답 반환 (사원증 스캔)
```

◈ 핵심정리
1. JWT  VS  세션
  - 세션 : 서버 메모리에 사용자 상태를 저장 → 서버 확장 시 부담
  (서버에서 출입명단을 직접 들고 있기)
  - JWT (Json Web Token) : 토큰 자체에 인증 정보를 포함 →
  (사용자가 직접 출입증을 들고 다니기)

2. Access Token   vs  Refresh Token
  - Access Token  : 짧은 기간 유효(출입증) → api 호출 시 사용
  - Refresh Token : 긴 기간 유효(장기체류증) → redis 냉장고에 안전보관

3. Redis 사용
  - 토큰냉장고 → 장기체류증 안전하게 보관, 필요 시 꺼내쓰기
  - Refresh Token 중앙에서 관리
  - TTL (만료시간)로 자동만료처리
  - 로그아웃 시 즉시 삭제

4. 구조확인)
1) security + jwt + redis
  - JwtProperties : 토큰
    * secret, issuer, expSeconds 기본속성
  - JwtProvider : 토큰 발급/검증
    AccessToken (출입증)
    Refresh Token (장기)
  - TokenStore : 토큰 저장소
    Redis 저장소, Refresh Token
  - JwtAuthenticationFilter : 보안 게이트
    * 매 요청마다 Authentication 헤더 확인 → 토큰 검증 → SecurityContext에 사용자 정보 저장
    * api 사용 시 신분증을 검사하는 게이트

2) oauth2.0
  - OAuth2  : 입국 심사대
  - UserInfoOAuth2 / UserInfoNaver , UserInfoKakao , UserInfoGoogle
  - CustomOAuth2User
  - OAuth2SuccessHandler

3) 설정파일
  - SecurityConfig
  - WebConfig
  - RedisConfig
  - SwaggerConfig



1. Header → 토큰의 머릿말 ( 이 토큰은 HS256 알고리즘으로 서명했어!  정보 )
```json
   { "alg": "HS256", "typ": "JWT" }
```
2. Payload(Claims)   →  토큰의 몸통 ( 누가, 어떤권한, 언제까지  사용자의 신분증정보)
```json
   {
     "iss": "thejoa703",   // 발급자
     "sub": "12345",       // 사용자 ID
     "role": "USER",       // 권한
     "email": "user@test.com",
     "exp": 1737000000     // 만료 시간
   }
```
3. Signature     →  토큰의 도장 ( 서버만 아는 비밀키로 찍은 도장 → 위변조 방지)
```json
   HMACSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
```




  1) 부분수정 > 지난시간
  2) 게시판리스트 > boot - List<PostResponseDto>
  3) 이미지-캐로셀 >
  4) 해시태그 >

4. 보안 + 시큐리티
1) 설정파일: build.gradle 시큐리티 / .env (필요한 설정파일)
  각종설정파일 : WebCongif ( 세션, 쿠키 - false / jwt )

2) security : Jwt + Redis
  com.thejoa703.security
    ㄴ JwtAuthenticationFilter  (4) 출입증 검사
    ㄴ JwtProperties  (1) Jwt 토큰
    ㄴ JwtProvider    (2) 발급
    ㄴ TokenStore     (3) redis 보관 / RedisConfig / SecurityConfig

3) oauth2 : 소셜처리 (구글/카카오/네이버 인증)
  com.thejoa703.oauth2
    ㄴ UserInfoOauth2 (1) 공통속성 추출
    ㄴ UserInfoGoogle / UserInfoKakao / UserInfoNaver (2) 각 소셜마다 처리

    ㄴ CustomOAuth2User (3) Security: local + Oauth2: 소셜 - 유저정보
    ㄴ OAuth2SuccessHandler (4) 소셜 로그인 시 - redis / jwt 설정 (유저저장, 토큰 설정)

4) service    - 기존활용
    ㄴ AuthUserJwtService (유저정보활용)
5) controller
    ㄴ UserController (로그인 시 - access Token, refresh Token / cookie 설정)
    ㄴ post에서 AuthUserJwtService 활용해서 가져오기

6) react
  1) 폴더만들기
  2) 프로젝트 설치
  3) reducer → saga → page
  4) ssr (server side rendering)
  4) jwt 사용
  front3
    ㄴ api/axios.js
    ㄴ pages
        ㄴ signup.js
        ㄴ login.js
        ㄴ mypage.js

3. social 개발자 사이트 - 키 찾기
> kakao 개발자, google 개발자, naver 개발자
> boot의 .env 파일 바꾸기


  ```
  mkdir front3      -- 폴더만들기
  cd    front3      -- 폴더이동

  front2 프로젝트 .next / node_module 빼고 안에 콘텐츠 넣기
  npm install
  ```