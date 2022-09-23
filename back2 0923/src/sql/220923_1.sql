drop database if exists a_count;
create database a_count;
use a_count;

create table a_count(
	a_no tinyint auto_increment primary key ,	-- 메뉴번호 [ 자동번호 ] PK
    a_date char(10),
    price int,
    content text
);
select * from a_count;
update a_count set price = 9 , content = '1' , a_date = '2' where a_no= 1