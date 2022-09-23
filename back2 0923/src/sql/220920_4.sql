

use market_db;
drop table if exists dc_category;

-- 카테고리테이블
create table dc_category(
	c_no int auto_increment primary key,
	c_category varchar(10)
);
select * from dc_category;


-- 게시판테이블
drop table if exists c_talent;
create table c_talent(
	t_category int,
    t_no int auto_increment primary key,
	t_writer varchar(10),
    t_pw int,
    t_title varchar(10),
    t_content text,
    foreign key( t_category ) references dc_category( c_no )
);
select * from c_talent;

-- 댓글테이블
drop table if exists dc_talent_review;
create table dc_talent_review(
	c_category int,
	r_no int auto_increment primary key,
	r_writer varchar(10),
    r_pw int,
    r_content text,
    foreign key( t_category ) references c_talent( t_no )
);
select * from dc_talent_review;