
### ■1. 

진행2. board 에 이미지 업로드 추가
0) 테이블에 이미지 경로추가
    bfile varchar(500) 기본값 the703.png

- 테이블수정
- dto 수정
- board-mapper.xml 수정

1) 글삽입에서 이미지 업로드 추가
2) 글수정에서 이미지 업로드 추가
3) 상세보기 이미지가 있다면 - 글수정 안올리면 이전이미지
                            이미지가 없다면 the703.png 이미지가 나오게




3. Paging
진행1. paging?
cmd)
    insert into mvcboard2 (bname, bpass, btitle, bcontent, bdate, bhit, bip, bfile)
    select bname, bpass, btitle, bcontent, bdate, bhit, bip, bfile from mvcboard2;

    100개 이상

bno	        int	            NO	    PRI		            auto_increment
bname	    varchar(20)	    NO			
bpass	    varchar(50)	    NO			
btitle	    varchar(1000)	NO			
bcontent	text	        NO			
bdate	    timestamp	    NO		CURRENT_TIMESTAMP	DEFAULT_GENERATED
bhit	    int	            NO		0	
bip	        varchar(50)	    NO			
bfile	    varchar(500)	YES		the703.png


진행2. Paging 컴포넌트 만들기

Paging 1 - Model 1) Mapper
    1) 최신글을 기준으로 10개씩 가져오기
    select * from mvcboard2 order by bno desc limit 0, 10;   -- 어디서부터, 몇 개
    select * from mvcboard2 order by bno desc limit 10, 10;  -- 그 다음 10개부터, 10개
    select * from mvcboard2 order by bno desc limit 20, 10;

    2) 전체 게시글 갯수
    select count(*) from mvcboard2


Paging 2 - Model 2) PagingUtil

Paging 3 - Controller) BoardController 사용

Paging 4 - JSP) View 사용







---
### ■3.  복습문제
