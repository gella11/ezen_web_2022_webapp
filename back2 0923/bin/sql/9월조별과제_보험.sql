drop database if exists Insurance_DB;
create database Insurance_DB;
use Insurance_DB;



create table member( -- 회원가입
	
    name char(6) not null,
    pw varchar(10) not null,
    phone varchar(15) not null primary key,
    ssn varchar(14) not null

);



create table board( -- 게시판

	b_num int primary key auto_increment,
    b_pw varchar(10) not null,
    b_title varchar(30) not null,
    b_content varchar(100) not null,
	phone varchar(15) not null,
    foreign key (phone) references member(phone)
);

 

-- --------------------------------------------------보험사--------------------------------------

create table list( -- 보험종류 카테고리
	c_num int auto_increment primary key,
    c_title varchar(10)
    
); 

create table sublist( -- 보험 종류 세부내역
 
 s_num int auto_increment primary key,
 s_name varchar(10),
 s_text text,
 c_num int , 
 foreign key (c_num) references list(c_num)

);

create table worker( -- 상담사 카테고리 리스트

w_num int auto_increment primary key,
w_name varchar(10) 

);
create table subworker( --  상담직원 상세내용 

w_num int,
phone varchar(15),
foreign key (w_num) references worker(w_num),
foreign key (phone) references member(phone)
);
create table mypage( -- 나의 페이지

c_num int,
s_num int,
foreign key (c_num) references list(c_num),
foreign key (s_num) references sublist(s_num)
);