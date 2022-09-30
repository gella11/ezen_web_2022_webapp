
-- p.255
-- 1. 데이터베이스 생성
drop database if exists naver_db;
create database naver_db;
use naver_db;
drop table if exists member;
create table member(
	mem_id 		char(8) not null primary key,
    mem_name 	varchar(10) not null,
    mem_number	tinyint not null,							-- not null : 공백이면  레코드가 생성이 안됨 [ x ] 
    addr		char(2) null,								--     null : 공백이여도 레코드가 생성이 됨  [ o ]
    phone1		char(3) null,
    phone2		char(8) null,
    height		tinyint unsigned null,						-- unsigned : tinyint(-128~127)인데 음수제거가 됨 >> (0~128)
    debut_date	date null
);
select * from member;

drop table if exists buy;
create table buy(
	num 		int auto_increment not null primary key,
    mem_id 		char(8) not null,
    prod_name 	char(6) not null,
    group_name	char(4) null,
    price 		int unsigned not null,
    amount		smallint unsigned not null,
    foreign key( mem_id ) references member( mem_id )		-- member 테이블이 없는데 buy테이블을 생성한다는 것은 성립이 안됨. 삭제 또한 buy 테이블이 있는데 member 테이블을 삭제할 수 없음
);
select * from buy;

-- 데이터 입력.
-- 1. 회원가입한다.
insert into member values('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
-- 2. 동일한 아이디로 회원가입한다. 불가 [ 아이디 충돌 pk <---> 식별키 (식별용도 고유한 값) ]
-- insert into member values('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015-10-19');
-- 3. TWC 회원이 지갑을 구매한다.
insert into buy values( null, 'TMC', '지갑', null, 30, 2);
