

/*
------------------------------------------------------------
------------------------------------------------------------
[연습문제]
[001]  다음과 같이 DB와 테이블을 만드시오        >> coffee
커피번호 : cno    int           필수입력     primary key
커피이름 : cname  varchar(50)   필수입력
커피가격 : cprice   int         필수입력
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |    
| cname  | varchar(50) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
create table coffee (
  cno int           not null  auto_increment primary key,
  cname varchar(50) not null,
  cprice int        not null
);



[002] 다음과 같이 DB와 테이블을 만드시오           >> milk
우유번호 : mno      int           필수입력     primary key
우유이름 : mname    varchar(50)   필수입력
우유가격 : mprice   int           필수입력
우유갯수 : mnum     int           필수입력
우유총액 : mtotal   int           필수입력
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| mno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| mname  | varchar(50) | NO   |     | NULL    |                |
| mprice | int(11)     | NO   |     | NULL    |                |
| mnum   | int(11)     | NO   |     | NULL    |                |
| mtotal | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
create table milk (
  mno int           not null auto_increment primary key,
  mname varchar(50) not null,
  mprice int        not null,
  mnum int          not null,
  mtotal int        not null
);



[003] 다음과 같이 DB와 테이블을 만드시오    >> score
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| sno      | int(11)     | NO   | PRI | NULL    | auto_increment |
| sname    | varchar(20) | NO   |     | NULL    |                |
| sjava    | int(11)     | NO   |     | NULL    |                |
| sjsp     | int(11)     | NO   |     | NULL    |                |
| sspring  | int(11)     | NO   |     | NULL    |                |
| sproject | int(11)     | NO   |     | NULL    |                |
| sstotal  | int(11)     | YES  |     | NULL    |                |
| ssavg    | int(11)     | YES  |     | NULL    |                |
| semail   | varchar(50) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
create table score (
  sno int           not null auto_increment primary key,
  sname varchar(20) not null,
  sjava int         not null,
  sjsp int          not null,
  sspring int       not null,
  sproject int      not null,
  sstotal int,
  ssavg int,
  semail varchar(50)
);



[004]  다음과 같이 DB와 테이블을 만드시오      >> emp
mysql> desc emp;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| empno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| ename    | varchar(20) | YES  |     | NULL    |                |
| job      | varchar(20) | YES  |     | NULL    |                |
| mgr      | int(11)     | YES  |     | NULL    |                |
| hiredate | date        | YES  |     | NULL    |                |
| sal      | int(11)     | YES  |     | NULL    |                |
| comm     | int(11)     | YES  |     | NULL    |                |
| deptno   | int(11)     | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)
create table emp (
  empno int          not null auto_increment primary key,
  ename varchar(20),
  job varchar(20),
  mgr int,
  hiredate date,
  sal int,
  comm int,
  deptno int
);



[005]  다음과 같이 DB와 테이블을 만드시오     >> dept
mysql> desc dept;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| deptno | int(11)     | NO   | PRI | NULL    | auto_increment |
| dname  | varchar(20) | NO   |     | NULL    |                |
| loc    | varchar(20) | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
create table dept (
  deptno int        not null auto_increment primary key,
  dname varchar(20) not null,
  loc varchar(20)   not null
);



[006]  다음과 같이 DB와 테이블을 만드시오    >> salagrade
mysql> desc salgrade;
+-------+---------+------+-----+---------+----------------+
| Field | Type    | Null | Key | Default | Extra          |
+-------+---------+------+-----+---------+----------------+
| grade | int(11) | NO   | PRI | NULL    | auto_increment |
| losal | int(11) | YES  |     | NULL    |                |
| hisal | int(11) | YES  |     | NULL    |                |
+-------+---------+------+-----+---------+----------------+
3 rows in set (0.02 sec)
create table salagrade (
  grade int     not null auto_increment primary key,
  losal int,
  hisal int
);
*/







/*
[001]  다음과 같이 DB와 테이블을 만드시오        >> coffee
커피번호 : cno    int           필수입력     primary key
커피이름 : cname  varchar(20)   필수입력
커피가격 : cprice   int         필수입력
+--------+-------------+-------+-----+---------+----------------+
| Field  | Type        | Null  | Key | Default | Extra          |
+--------+-------------+-------+-----+---------+----------------+
| cno    | int(11)     | YES   |     | NULL    |                |    
| cname  | varchar(20) | YES   |     | NULL    |                |
| cprice | int(11)     | YES   |     | NULL    |                |
+--------+-------------+-------+-----+---------+----------------+
create table coffee (
  cno    int,
  cname  varchar(20),
  cprice int
);

 > DDL : CREATE, ALTER, DROP
 > ALTET TABLE 테이블명
    ( 추가: ADD, 삭제: DROP, 수정: CHANGE:MODIFY, 이름변경: RENAME )

1) cno, cname, cprice 필드를 ( not null ) 으로 수정 [TABLE명: coffee]
--  ALTET TABLE coffee change cno cno int       not null;
    ALTET TABLE coffee modify cno int           not null;
    ALTET TABLE coffee modify cname varchar(20) not null;
    ALTET TABLE coffee modify cprice int        not null;

2) 쿠폰필드 cgift 문자열고정(10) 미필수로 추가 → ★ 문자열고정=char (varchar는 CHANGE로 변경가능)
alter table coffee add cgift char(10);

3) 쿠폰필드 cgift를 ccoupon으로 바꾸기
alter table coffee change cgift ccoupon char(10);           // old new 자료형 옵선 이름
alter table coffee modify ccoupon varchar(10) not null;     // 자료형 옵션

4) 쿠폰필드 ccoupon 삭제
alter table coffee drop ccoupon;

5) cno를 cprice 뒤로 이동 ( modify & change )
                          필드명   자료형 옵션
alter table coffee modify cno     int   not null after cprice;
ALTER TABLE coffee change cno cno int   not null after cprice;
                     필드명old new 자료형 옵션

6) cno를 맨 위로 ( modify & change )
alter table coffee modify cno     int not null first;
ALTER TABLE coffee change cno cno int not null first;

7) cno를 primary key 추가
alter table coffee modify cno     int not null primary key;     // primary key 수정 (modify)
alter table coffee change cno cno int not null primary key; 
alter table coffee add  primary key (cno);
alter table coffee drop primary key;

8) alter_coffee 테이블의 이름을 alter_coffee2 로 바꾸기
ALTER TABLE coffee rename coffee2;
ALTER TABLE coffee modify cno int not null auto_increment primary key first;


9) 연습문제9) 다음과 같이 최종본으로 테이블만들기
mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(20) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

*/