
### ■1. oracle

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



### ■2. boot
