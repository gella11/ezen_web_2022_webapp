
use market_db;
drop table if exists c_product;

-- 제품테이블
create table c_product(
	pno int auto_increment primary key,
    pname varchar(100),
    pbrand varchar(100),
    pprice int,
    pimagpth text
);
select * from c_product;


-- 회원테이블
drop table if exists c_member;
create table c_member(
	mno int auto_increment primary key,
    mid varchar(50),
    mpw varchar(50),
    mname varchar(50),
    mphone varchar(13)    
);
select * from c_member;

-- 장바구니테이블
drop table if exists c_basket;
create table c_basket(
	bno int auto_increment primary key,
	pno int,
    mno int,
    amount smallint,
    foreign key( pno ) references c_product( pno ),
    foreign key( mno ) references c_member( mno )
);
select * from c_basket;