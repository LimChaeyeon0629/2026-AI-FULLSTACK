--### ■1. oracle
--
--- 데이터베이스언어
--1) 데이터 정의어(DDL) : create, alter, drop (cad)
--2) 데이터 조작어(DML) : insert, select, update, delete (crud)
--3) 데이터 제어어(DCL) : grant, revoke

--- 1. oracle 설치
--- 2. sql developer 설치 (sql 편집)
--- 3. 사용
--<실습1>
--```sql (cmd)
--sqlplus
--conn system/1234

-- 유저만들기 (오라클 12 이상에서 기존 방식으로 사용자 생성 허용 - c#scott / tiger)
--ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--create user scott identified by tiger;

-- 권한부여
--grant connection, resource to scott;
--grant connect, resource to scott;

--ALTER USER scott DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;  --물리적 공간 이용
--grant create table to scott;
--```

--<실습2> 테이블만들기, dml
-- 드래그 ctrl + enter
conn  scott/tiger;
commit;

create table dept(
    deptno  number   primary key,
    dname   varchar2(14),
    loc     varchar2(13)
);

--SQL> select * from dept;
--
--    DEPTNO DNAME                        LOC
------------ ---------------------------- --------------------------
--        10 ACCOUNTING                   NEW YORK
--        20 RESEARCH                     DALLAS
--        30 SALES                        CHICAGO
--        40 OPERATIONS                   BOSTON

insert into dept (DEPTNO, DNAME, LOC) values (10, 'ACCOUNTING', 'NEW YORK');
insert into dept (DEPTNO, DNAME, LOC) values (20, 'RESEARCH', 'DALLAS');
insert into dept (DEPTNO, DNAME, LOC) values (30, 'SALES', 'CHICAGO');
insert into dept (DEPTNO, DNAME, LOC) values (40, 'OPERATIONS', 'BOSTON');
--
commit;

select * from dept;



-- 3. crud
-- 3-1) 데이터 넣기 -   50  AIDEV   SEOUL
insert into dept values (50, 'AIDEV', 'SEOUL');

-- 3-2) 데이터 수정 -   50  AIDEV   INCHEON
update dept set LOC='INCHEON' where deptno=50;

-- 3-3) 데이터 삭제 -   50번
delete from dept where deptno=50;



-- 4. sequence (숫자 자동증가)
create sequence dept_seq;
insert into dept values (dept_seq.nextval, 'AIDEV', 'SEOUL');

select * from dept;

drop sequence dept_seq;

-- 참고)
CREATE SEQUENCE dept_seq
       START WITH       50  -- 시작할 번호 ( 기존 데이터와 겹치지 않게 )
       INCREMENT BY     10  -- 증가할 값   ( 10개씩 증가 )
       NOCACHE              -- 캐시사용안함 ( 번호 건너뛰기 방지 )
       NOCYCLE;             -- 값이 처음으로 돌아가지 않음.



-- 5. 외래키
-- 부모 삭제 시 자식도 같이 삭제 (cascade)
CREATE TABLE emp1 (
  empno    number   not null   primary key   ,
  ename    varchar2(10)   not null  ,
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   number   references dept(deptno)   on delete cascade
);

-- deptno=1 외래키
INSERT INTO emp1 VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 1);
--
select * from emp1;

delete from dept where deptno=1;
--
select * from dept;
drop table emp1;


-- 부모 삭제 시 자식의 deptno를 null로 변경 (set null)
CREATE TABLE emp2 (
  empno    number   not null   primary key   ,
  ename    varchar2(10)   not null  ,
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   number   references dept(deptno)   on delete set null
);

-- deptno=50 외래키
INSERT INTO emp2 VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 50);
--
select * from emp2;

delete from dept where deptno=50;
--
select * from dept;


-- emp 테이블과 insert 실행반영 ,   cmd 창에서 반영된것 확인 
CREATE TABLE emp (
  empno    NUMBER(4) PRIMARY KEY,
  ename    VARCHAR2(10),
  job      VARCHAR2(9),
  mgr      NUMBER(4),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   NUMBER(2) REFERENCES dept(deptno) ON DELETE CASCADE
);


INSERT INTO emp VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20);
INSERT INTO emp VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30);
INSERT INTO emp VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30);
INSERT INTO emp VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20);
INSERT INTO emp VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30);
INSERT INTO emp VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30);
INSERT INTO emp VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10);
INSERT INTO emp VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000, NULL, 20);
INSERT INTO emp VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10);
INSERT INTO emp VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30);
INSERT INTO emp VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100, NULL, 20);
INSERT INTO emp VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30);
INSERT INTO emp VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20);
INSERT INTO emp VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10);

commit;

select * from emp;
delete from emp;
drop table emp;

--
conn scott/tiger;
--
create table sboard2(
    ID number not null,
    APP_USER_ID number not null,
    BTITLE varchar2(1000) not null,
    BCONTENT clob not null,
    BPASS varchar2(255) not null,
    BFILE varchar2(255) default 'the703.png',
    BHIT number default 0,
    BIP varchar2(255) not null,
    CREATED_AT date default sysdate
);
select * from sboard2;
--
drop table sboard2;

create sequence sboard2_seq;
--
drop sequence sboard2_seq;

commit;

insert into sboard2 (ID, APP_USER_ID, BTITLE, BCONTENT, BPASS, BFILE, BIP)
values ( sboard2_seq.nextval, 1001, 'title', 'content', 'pass', '1.png', '127.0.0.1' );
--
select * from sboard2;

-- 전체 select

-- mysql (오라클에서는 동작안함)
-- select * from sboard2 order by id desc limit 0, 10

-- 전체 select
select * from sboard2 order by id desc;
-- 전체 select (페이징)
select * from sboard2
order by id desc
offset 0 rows fetch next 10 rows only;
-- 전체 select (페이징) oracle version 12 down
select * from(
         select row_number() over(order by id desc)  as rnum, -- 해당하는줄수 cnt
         id, app_user_id, btitle, bcontent, bpass, bfile, bip, bhit, created_at
         from  sboard2
      ) A
      where  A.rnum  between  0  and 10;

-- offset 0 rows 건너뛸 행의 개수 (0부터 시작)
-- fetch next 10 rows only; 가져올 행의 개수
-- 최신글부터 10개 0, 10 / 10, 10 / 20, 10
select count(*) from sboard2;


-- 해당번호의 select
select * from sboard2 where ID = 1;	

-- 해당번호 조회수 올리기
update sboard2 set bhit = bhit + 1 where ID = 1;

-- 해당번호 업데이트
update sboard2 set btitle='new', bcontent='new', bfile='2.png' where ID = 1;

-- 해당번호 삭제
delete from sboard2 where ID = 1;

-- 1) spring + jsp
-- 2) spring boot + thymeleaf ( 권장사항 html )
-- 3) spring boot / react

create table appuser (
    app_user_id number(5) not null,
    email varchar2(100) not null,
    password varchar2(100),
    mbti_type_id number(3),
    created_at date,
    ufile varchar2(255),
    mobile varchar2(50),
    nickname varchar(50),
    provider varchar2(50) not null,
    provider_id varchar2(100)
);
desc appuser;
alter table appuser modify created_at date default 0;

create table authorities (
    auth_id number(5) not null,
    email varchar2(255),
    auth varchar2(255) not null,
    app_user_id number(5)
);
desc authorities;

create sequence appuer_seq;
drop sequence appuer_seq;
--
create sequence appuser_seq;
create sequence authorities_seq;

-- 회원가입
insert into appuser (app_user_id, email, password, mbti_type_id, CREATED_AT, UFILE, MOBILE, NICKNAME, PROVIDER, PROVIDER_ID)
values ( appuser_seq.nextval, 'first@gmail.com', '111', 1, sysdate, '1.png', '01011111111', 'first', 'the703', 't7-1');

select * from appuser;

commit;

-- 로그인 - 이메일로 이메일, 비밀번호, 권한
select u.email, u.password, a.auth
from appuser u left join authrities a on u.email = a.email
where u.email = 'first@gmail.com';

-- 이메일로 유저찾기
select * from appuser where email = 'first@gmail.com';
--
select * from appuser where email = '1@1';

-- 이메일로 중복검사
select count(*) from appuser where email = 'first@gmail.com';

-- 회원수정
update appuser
set password='2222',
    mbti_type_id=2,
    ufile='2.png',
    nickname='second',
    mobile='01022222222',
    provider='naver',
    provider_id='n-1'
where email = 'first@gmail.com';
--
select * from appuser;

commit;

select * from authorities where email = '8@8';
select * from appuser where email = '8@8';

 


select app_user_id from appuser;

-- 회원삭제
delete from appuser where email = 'first@gmail.com';
--
delete from appuser where email = '1@1';
delete from appuser where email = '5@5';
delete from appuser where email = '6@6';
delete from appuser where email = '8@8';

-- 권한삽입
desc authorities;
insert into authorities (AUTH_ID, EMAIL, AUTH)
values (authorities_seq.nextval, 'first@gmail.com', 'ROLE_MEMBER');

insert into authorities (AUTH_ID, EMAIL, AUTH)
values (authorities_seq.nextval, 'second@gmail.com', 'ROLE_ADMIN');

select * from authorities;

SELECT *
FROM appuser
WHERE email = '3@3';

SELECT *
FROM authorities
WHERE email = '3@3';

select u.email, u.password, a.auth
from appuser u
left join authorities a on u.email = a.email
where u.email = '3@3';

-- 권한삭제
delete from authorities where email = 'first@gmail.com';
delete from authorities where email = 'second@gmail.com';
--
delete from authorities where email = '8@8';