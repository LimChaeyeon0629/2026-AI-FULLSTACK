데이터베이스 언어
- DDL : CREATE, ALTER(#), DROP     → CAD
- DML :
- DCL : 

1) alter 문법
https://dev.mysql.com/doc/refman/8.0/en/table.html

help alter
help alter table;


ALTER TABLE 테이블명
    ADD     추가컬럼명  자료형  옵션   [FIRST | AFTER col_name]
    DROP    삭제필드명
    CHANGE  이전필드명  새로운필드명    자료형 옵션
    MODIFY  수정필드명  자료형  옵션
    RENAME  새로운테이블이름

#1) 필드 추가 (userinfo add)
    alter table userinfo  add uno   int;
    alter table userinfo  add uno2  int          first;       -- 맨 앞에
    alter table userinfo  add email varchar(100) after name;  -- name 뒤에

#2) 필드 삭제 (drop)
    alter table userinfo drop uno;
    
    ※ uno2 삭제
    alter table userinfo drop uno2;


#3) 필드 수정 (CHANGE) - 필드명, 자료형/옵션 수정
    > alter table userinfo change oldname newname 자료형 옵션
    alter table userinfo change   email   email2  varchar(50);

    ※ email2 → email
    alter table userinfo change   email2  email   varchar(100);

#4) 필드 수정 (MODIFY) - 자료형/옵션 수정 ( add, drop, change | modify )
    alter table userinfo modify email varchar(20) not null;
    
    ※ email 삭제
    alter table userinfo drop email;

#5) 테이블명 수정 (rename)
    ※ userinfo → users
    alter table userinfo rename users;





ALTER TABLE 테이블명
     ADD        추가필드명     자료형    옵션
     DROP       삭제필드명
     CHANGE     수정할필드명   새로넣을필드명   자료형  옵션
     MODIFY     수정할필드명   자료형  옵션
     RENAME     새로운테이블명

/*
1. 테이블 준비
create table userinfo (
    no int              not null auto_increment primary key,
    name varchar(100)   not null,
    age int             not null
);
*/