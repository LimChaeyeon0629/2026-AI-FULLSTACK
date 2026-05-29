
create database dbdbig;
use dbdbig;
create table mvcboard1 (
	bno int not null auto_increment primary key,
    bname varchar(200) not null,
    bpass varchar(50) not null,
    btitlc varchar(1000) not null,
    bcontent text not null,
    bdate timestamp default current_timestamp,
    bhit int not null default 0,
    bip varchar(50)
);

desc mvcboard1;
alter table mvcboard1 modify bdate timestamp not null default current_timestamp;
alter table mvcboard1 modify bip varchar(50) not null;

delete from mvcboard1 where bno=5;
select * from mvcboard1;
insert into mvcboard1 (bname, bpass, btitlc, bcontent, bip) values ('bname', 'bpass', 'btitlc', 'bcontent', 'bip');









-- mysql> desc users;
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | Field    | Type         | Null | Key | Default           | Extra             |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | uno      | int          | NO   | PRI | NULL              | auto_increment    |
-- | nickname | varchar(20)  | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)  | NO   |     | NULL              |                   |
-- | email    | varchar(100) | NO   |     | NULL              |                   |
-- | mobile   | varchar(50)  | NO   |     | NULL              |                   |
-- | udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bip      | varchar(50)  | NO   |     | NULL              |                   |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- 7 rows in set (0.00 sec)
-- (1) users 라는 테이블 만들기 

use dbdbig;
create table users (
	uno int not null auto_increment primary key,
    nickname varchar(20) not null,
    bpass varchar(50) not null,
    email varchar(100) not null,
    mobile varchar(50) not null,
    udate timestamp not null default current_timestamp,
    bip varchar(50) not null
);
desc users;

-- (2) sql  -  회원가입 sql,  로그인 sql 찾기~!
-- 회원가입 sql
-- insert into users (nickname, bpass, email, mobile, bip) values (?, ?, ?, ?, ?)
insert into users (nickname, bpass, email, mobile, bip) values ('aaa', '1111', 'aaa@gmail.com', '010-111-1111', '127.0.0.1');
select * from users;
delete from users where uno=3;

-- 로그인 sql
-- select count(*) from users where bpass=? and email=?;
-- select       *  from users where bpass=? and email=?;
select       *  from users where bpass='1111' and email='aaa@gmail.com';