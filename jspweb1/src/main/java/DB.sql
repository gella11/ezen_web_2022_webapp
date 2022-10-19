drop database if exists jspweb;
create database jspweb;
use jspweb;

create table member(
	mno			int auto_increment primary key,
	mid 		varchar(100),
    mpassword 	varchar(100),
    mname		varchar(100),
    mphone		varchar(100),
    memail		varchar(100),
    maddress	varchar(100),
    mdate		datetime default now(),	-- default 레코드 추가시 기본으로 들어가는 값 설정
										-- datetime default now() 현재 시스템(DB)의 자동 날짜
	mpint		int default 0
);
-- 특정 필드 삽입 : insert into
-- 모든 필드 삽입 : insert into
insert into member values( null , "aa" , "aa", "aa" , "aa" , "aa" , "aa" , null , 0 );
insert into member values( null , "a" , "b", "c" , "d" , "e" , "f" , null , 0 );
insert into member values( null , "1" , "2", "3" , "4" , "5" , "aa" , null , 0 );
select * from member;

drop table if exists category;
create table category(
	cno int auto_increment primary key,
    cname varchar(100)
);

drop table if exists board;
CREATE TABLE board(
	bno			int auto_increment primary key,  -- 번호  	
    btitle		varchar(1000), 		-- 제목 		
    bcontent	longtext ,			-- 내용
    bfile		longtext ,			-- 첨부파일 [ 게시물 1개당 첨부파일 1개 ]
    bdate 		datetime default now()	,	-- 작성일 : 기본값 현재 DB서버 시스템 날짜 
    bview		int default 0 ,				-- 조회수 : 기본값 0 
    cno			int ,				-- 카테고리번호 FK 
    mno 		int	,				-- 작성자 
    constraint bcno_fk foreign key (cno) references category(cno) ,
    constraint bmno_fk foreign key (mno) references member(mno) 
);
select * from board;
-- foreign key (mno) reference member(mno)
alter table board modify bdate date;
select * from board;
insert board(bcontent) value('asdf');
insert into board(btitle,bcontent,mno) value(1, 2, 3);

-- 1. 한개 테이블 검색 
select * from member;
-- 2. 두개 테이블 검색  [ 1번테이블 레코드수 x 2번테이블 레코드수 ]
select * from member , board;
-- 3. 조건 [ pk-fk 일치 한 경우만 표시 ]
select * from member , board where member.mno = board.mno;
-- 4. 표시할 필드 선택 
select b.bno , b.btitle , b.bcontent , b.bfile , b.bdate , b.bview , b.cno , b.mno , m.mid from member m , board b where m.mno = b.mno;
-- 5. 모든 글출력 
select b.* , m.mid from member m , board b where m.mno = b.mno;
-- 5. 개별 글출력 
select b.* , m.mid from member m , board b where m.mno = b.mno and bno = 1; -- 게시물번호 
select b.* , m.mid from member m , board b where m.mno = b.mno;

select count(*) from board;
select * from board limit 0,3;
select * from board order by bdate desc;
select * from board order by bdate desc limit 0,3;
select b.* , m.mid from member m , board b where m.mno = b.mno order by b.bdate desc limit 3 , 3;
select b.* , m.mid from member m , board b where m.mno = b.mno and  m.mid like 'q' order by b.bdate desc limit 0,3;
select count(*) from member m , board b where m.mno = b.mno;



drop table if exists reply;
create table reply(
	rno			int auto_increment,
    rcontent 	varchar(1000) not null,
    rdate 		datetime default now(),
    rindex		int default 0,	-- [ 0 상위댓글 , 숫자 : 상위댓글의 번호  들여쓰기 정도 ]
    mno			int not null, -- 회원번호
    bno			int not null,
    constraint rno_pk primary key(rno),
    constraint rmno_fk foreign key(mno) references member(mno) on delete cascade, -- 회원 탈퇴시, 댓글도 같이 삭제
    constraint rbno_kf foreign key(bno) references  board(bno) on delete cascade -- 게시물 삭제시 댓글도 같이 삭제
);
select * from reply;
select r.rcontent , r.rdate, m.mid from reply r, member m where r.mno = m.mno;
select r.rcontent , r.rdate, m.mid from reply r, member m where r.mno = m.mno and r.bno = 4 ;
-- 댓글만 출력
select * from reply where rindex = 0;
select * from reply where rindex = 1;
-- 해당 게시물의 1번의 대댓글
select r.rcontent , r.rdate, m.mid, r.rno from reply r, member m where r.mno = m.mno and r.bno = 6 and r.rindex = 1 order by r.rdate desc;
