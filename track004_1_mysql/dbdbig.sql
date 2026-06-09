
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

use mbasic;
select * from mvcboard2;

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
select * from mvcboard1;
delete from users where uno=3;

-- 로그인 sql
-- select count(*) from users where bpass=? and email=?;
-- select       *  from users where bpass=? and email=?;
select       *  from users where bpass='1111' and email='aaa@gmail.com';

use mbasic;
select * from users;
select * from mvcboard1;





-- src img
use mbasic;
desc mvcboard2;
alter table mvcboard2 add bfile varchar(500) default 'the703.png';
alter table mvcboard2 modify bfile varchar(500) not null default 'the703.png';

alter table mvcboard2 modify bfile varchar(500) default 'the703.png';
desc mvcboard2;


-- paging
insert into mvcboard2 (bname, bpass, btitle, bcontent, bdate, bhit, bip, bfile)
select bname, bpass, btitle, bcontent, bdate, bhit, bip, bfile from mvcboard2;

select * from mvcboard2;

delete from mvcboard2
where bno between 517 and 585;

select * from mvcboard2 order by bno desc limit 0, 10;		-- 어디서부터, 몇 개
select * from mvcboard2 order by bno desc limit 10, 10; 	-- 그 다음 10개부터, 10개
select * from mvcboard2 order by bno desc limit 20, 10;

select count(*) from mvcboard2;


-- 
use mbasic;
show tables;
desc users;
select * from users;
insert into users (nickname, bpass, email, mobile, bip) values ('1', '1', 'first@gmail.com', '010-000-0000', '192.168.40.38');

alter table users modify bpass varchar(500) not null;
desc users;

SET SQL_SAFE_UPDATES =0;
delete from users;

delete from users where uno=5;
-- create table userss select * from users;

create table authorities (
	email varchar(50) not null,
    auth varchar(50) not null
);
desc authorities;

insert into authorities (email, auth) values ('first@gmail.com', 'ROLE_MEMBER');
insert into authorities (email, auth) values ('first@gmail.com', 'ROLE_ADMIN');
-- insert into authorities (email, auth) values (#{email}, #{auth});

update authorities set bpass='1234' where email='first@gmail.com';
select * from authorities;

select u.email, u.bpass, a.auth
from users u left join authorities a on u.email = a.email
where u.email = 'first@gmail.com'