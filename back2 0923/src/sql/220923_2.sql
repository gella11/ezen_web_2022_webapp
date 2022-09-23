drop database if exists cal;
create database cal;
use cal;
create table calender(
	cno int auto_increment primary key ,	-- 메뉴번호 [ 자동번호 ] PK
    cdate date not null,
    ccomment varchar(100) not null
);
select * from calender;
-- substring( 문자열, 시작위치[1] , 개수)
select 
	substring( cdate , 1, 4) as 연도,
	substring( cdate , 6, 2) as 월,
    substring( cdate , 9, 2) as 일
from calender;
select 
	substring( cdate , 1, 4) as 연도,
	substring( cdate , 6, 2) as 월,
    substring( cdate , 9, 2) as 일
from calender;
select 
	substring( cdate , 1, 4) as 연도,
	substring( cdate , 6, 2) as 월,
    substring( cdate , 9, 2) as 일
from calender
where substring( cdate , 1, 4) = '2022'
and substring( cdate , 6, 2) = '09';

select *
from calender
where substring( cdate , 1, 4) = '?'
and substring( cdate , 6, 2) = '?';
