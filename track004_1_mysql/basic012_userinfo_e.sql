use mbasic;
show tables;

desc userinfo;
create table userinfo_e select * from userinfo;
desc userinfo_e;

alter table userinfo_e add email varchar(100) not null;
alter table userinfo_e drop email;

alter table userinfo_e add age int;
alter table userinfo_e drop age;
alter table userinfo_e modify no int not null auto_increment primary key;

desc userinfo_e;
select * from userinfo_e;


show tables;
create table mvcboard2 (
	bno int not null auto_increment primary key,
    bname varchar(20) not null,
    bpass varchar(50) not null,
    btitle varchar(1000) not null,
    bcontent text not null,
    bdate timestamp not null default current_timestamp,
    bhit int not null default 0,
    bip varchar(50) not null
);