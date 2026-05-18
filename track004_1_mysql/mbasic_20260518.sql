-- STEP1) 
-- 1.  데이터베이스 언어 - 다음과 같은형식으로 빈칸 채우기
-- DDL( 정의어 )  create, alter, drop					→ cad
-- DML( 조작어 )  delete, insert, update, select 		→ crud
-- DCL( 제어어 )  GRANT , REVOKE


-- STEP2) 
-- Q1. userinfo 테이블을 복사해서 userinfo_ex 테이블을 만드시오.

-- mysql> desc userinfo_ex;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)
use mbasic; -- database 선택
-- create table userinfo_ex select * from userinfo; -- userinfo_ex 테이블 만들기 (userinfo 구조 복사)
show tables; -- 테이블 확인
desc userinfo_ex;  -- 테이블 구조 확인
alter table userinfo_ex modify no int not null auto_increment primary key; -- 숫자 자동 증가 + 기본키
select * from userinfo_ex; -- 전체 데이터 검색


create table userinfo_ex (
	no int 			  not null auto_increment primary key,
	name varchar(100) not null,
	age int			  not null
);
show tables;
desc userinfo_ex;


-- mysql> select * from userinfo_ex;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+
-- insert into userinfo_ex (no, name, age) values (1, 'first', 11);
insert into userinfo_ex values (1, 'first', 11);
insert into userinfo_ex values (2, 'second', 22);
insert into userinfo_ex values (3, 'third', 33);
insert into userinfo_ex values (4, 'fourth', 44);
select * from userinfo_ex;


-- Q2. userinfo_re1 에  다음과 같이 데이터 추가
-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- |  5 | fifth  |  50 |
-- |  6 | six    |  66 |
-- +----+--------+-----+
insert into userinfo_ex values (5, 'fifth', 50);
insert into userinfo_ex value (6, 'six', 66);
select * from userinfo_ex;


-- Q3. userinfo_re1 에 데이터 수정
-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- |  5 | fifth    |  55 |   ← age 55로 수정
-- |  6 | six   |  66 |       ← name sixth로 수정
-- +----+--------+-----+
update userinfo_ex set age=55 where no=5;
-- update userinfo_ex set age=55 where name='fifth';
-- update userinfo_ex set age=55 where no=5 and name='fifth';
update userinfo_ex set name='sixth' where no=6;
-- update userinfo_ex set name='sixth' where age=66;
-- update userinfo_ex set name='sixth' where name='six';
-- update userinfo_ex set name='sixth' where no=6 and age=66;
select * from userinfo_ex;


-- Q4. userinfo_re1 에 데이터 삭제
-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 | 
-- +----+--------+-----+
delete from userinfo_ex where no=5;
delete from userinfo_ex where no=6;
-- delete from userinfo_ex where no>=5;
select * from userinfo_ex;