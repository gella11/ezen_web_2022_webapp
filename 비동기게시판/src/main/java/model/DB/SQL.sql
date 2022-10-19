drop database if exists board;
create database board;
use board;

create table board(
	bno			int auto_increment primary key,
	btitle 		varchar(100) ,
    bcontent 	varchar(100) ,
    bname		varchar(100) ,
    bpassword	varchar(100) ,
    mdate		datetime default now(),	-- default 레코드 추가시 기본으로 들어가는 값 설정
										-- datetime default now() 현재 시스템(DB)의 자동 날짜
	view int default 0
);
-- 특정 필드 삽입 : insert into
-- 모든 필드 삽입 : insert into
select * from board;

create table comment(
    bno int ,
    cno int,
    cindex int,
    cname varchar(100),   
    ccontent varchar(100),
    cpassword varchar(100),    
    foreign key ( bno ) references board ( bno )   
);

