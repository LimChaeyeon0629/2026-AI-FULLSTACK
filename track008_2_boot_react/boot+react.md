
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

