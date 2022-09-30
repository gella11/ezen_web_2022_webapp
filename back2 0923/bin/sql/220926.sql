use naver_db;
drop table if exists buy,member;
create table member(
	mem_id char(8) not null primary key,
    mem_name varchar(10) not null,
    height tinyint unsigned null									-- unsigned : 음수제거. 제거된 음수만큼 양수로 사용할 수 있기 때문에 메모리 변화가 있을 수 있음
);
-- 생성하는 순서 : pk -> fk
-- 삭제하는 순서 : fk -> pk
describe member;													-- 해당 테이블의 필드 속성 확인
select * from member;


-------------------------------------------------------------------------------------------------------------


drop table if exists member;
create table member(
	mem_id char(8) not null,
    mem_name varchar(10) not null,
    height tinyint unsigned null,
    primary key(mem_id)
    -- constraint primary key member_id_pk (mem_id)					-- pk 여러개 권장 문법 , 제약조선 이름 정의, 필드의 변수명을 정할 수 있음
);
-- 제약조건[constaraint] 추가
   alter table member add constraint primary key(mem_id);				-- primary key를 지정을 안했다는 가정하에, 추가할 수 있음
-- alter table member add constraint +++ primary key(mem_id);		-- 제약조건 이름 정의(쉽게말해 변수명 정의) 는 + 칸에 넣으면 됨
alter table member drop primary key;
select * from member;



-------------------------------------------------------------------------------------------------------------
drop table if exists buy;
create table buy(
	num int auto_increment not null primary key,
    mem_id char(8) not null key,
    prod_name char(6) not null,
    foreign key(mem_id) references member(mem_id)
);




