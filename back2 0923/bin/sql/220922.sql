
-- 매머드 카페 키오스크 
drop database if exists mmth;
create database mmth;
use mmth;
create table menu(
	mno tinyint auto_increment primary key ,	-- 메뉴번호 [ 자동번호 ] PK
	mname varchar(10) 							-- 메뉴이름
);
create table product(
	pno int auto_increment primary key , 		-- 제품 번호 [ 자동번호 ] PK
	pname varchar(50), 							-- 제품명
    pprice int , 								-- 제품가격
    pcomment varchar(1000),						-- 제품소개
    pamount smallint,							-- 제품재고 
    mno tinyint , 								-- 메뉴 이름 [ 대체 -> 이름 번호 ] 
    foreign key( mno ) references menu( mno ) 
);
create table porder(
	pono int auto_increment	primary key,	 		-- 주문 번호 [ 자동번호 ] PK
    podate datetime 								-- 주문 날짜/시간
);
create table porder_detail( 
	podeno int auto_increment primary key ,			-- 주문 상세 번호 PK
    poamount int,									-- 제품 수량 
    pono 	int	,									-- 주문 번호 
    pno		int ,									-- 제품 이름 [ 대체 -> 제품 번호 ] 
    foreign key( pono ) references porder( pono ),	-- 주문 번호를 	FK로 설정
    foreign key( pno ) references product( pno )	-- 제품 번호를 	FK로 설정
);

insert into menu values( null, '커피');
select * from menu;
insert into product values(null, '아이스아메리카노', 2000 , '시원해' , 20, 1);
select * from product;
