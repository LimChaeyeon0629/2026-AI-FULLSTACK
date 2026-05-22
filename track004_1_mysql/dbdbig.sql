
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

delete from mvcboard1 where bno=3;
select * from mvcboard1;
insert into mvcboard1 (bname, bpass, btitlc, bcontent, bip) values ('bname', 'bpass', 'btitlc', 'bcontent', 'bip');