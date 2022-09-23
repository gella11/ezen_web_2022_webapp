

use market_db;
create table hongong1(
	toy_id int,
    toy_name char(4),
    age int
);

-- 1. insert
-- insert into 테이블명 ( 필드명1, 필드명2, 필드명3 ) valuse( 값1 , 값2 , 값3);
-- 필드 개수와 값의 개수와 동일한 경우 필드명 생략
select * from hongong1;
insert into hongong1 values(1, '우디' , 25);
insert into hongong1 ( toy_id , toy_name ) values (2,'버즈');
insert into hongong1 ( toy_name, age, toy_id ) values ('제시' , 20, 3 );

-- 2. auto_increment 자동번호 부여 ★★★중복[x] [ primary key 와 같이 사용 ]
-- 자동번호는 삭제되면 해당 삭제된 번호 다음부터 생성
-- ex ) 3번 게시물이 삭제되었다면 >>> 1 2 4 5 6
create table hongong2(
	toy_id int auto_increment primary key,
    toy_name char(4),
    age int
);
select * from hongong2;
insert into hongong2 values (null, '보핍', 25);
insert into hongong2 values (null, '슬링키', 22);
insert into hongong2 values (null, '렉키', 21);
select last_insert_id();
-- ▶▶▶ last_insert_id(); 마지막으로 추가된 자동번호 검색
alter table hongong2 auto_increment = 100;
insert into hongong2 values ( null, '재남', 35);
-- 자동증가를 100부터 시작
set @@auto_increment_increment =1;
-- ▶▶▶ @@auto_increment_increment =x; 
-- 증가값을 1이 아닌 x씩 증가
-- ★★★모든 테이블에 적용됨으로 주의
-- set @@auto_increment_increment =3;
-- set @@auto_increment_increment =1;
-- 써보고 돌려놓기
insert into hongong2 values(null, '재남2', 30) , (null, '재남3', 40);
-- 여러 values 값 한번에 작성 가능

-- 3. insert into select
-- select 한 것을 insert 한다.
create table member_addr(mem_id char(8) not null , addr char(2));
select * from member_addr;
select count(*) from member;												-- member table 줄 확인
select * from member limit 5;												-- member 위에서 5줄 확인
select mem_id, addr from member limit 5;									-- member 위에서 5줄 mem_id addr 출력	
insert into member_addr select mem_id, addr from member limit 5;			-- 위의 값을 member_addr table에 입력

-- 4. update
-- update 테이블명 set 수정필드명=새로운값, 수정필드명2=새로운값 where 조건식;
-- ex) 회원 중 주소가 '서울' 이면 'Seoul' 변경
select * from member;
update member set addr = 'Seoul' where addr = '서울'; 						-- 오류 2가지 [ 1. addr char(2) 이기때문 ] [ 2. 워크벤치 설정 변경(update / deleter) ]
update member set addr = 'Se' where addr = '서울';				
update member set addr = '수도' , phone1 = '032' where addr = '경기';			-- ex) 회원 중 주소가 '경기' 이면 '수도' 변경 // phone1 '032' 변경
update member set addr = '안산';												-- ex) 조건 없는 수정 [ 모든 addr이 '안산'으로 변경]
update member set mem_number = mem_number/3;								-- ex) 조건 없는 수정 [ 모든 멤버수가 멤버수/3 으로 변경 ]

-- 5. delete
-- delete from 테이블명 where 조건
-- ex) member 테이블 중 mem_name 필드에 핑크가 포함된 
select * from member;
select * from member where mem_name like '%핑크%';
delete from member where mem_name like '%핑크%';								-- 에러, [수정/삭제할 경우,, pk <----> fk (foreign key) 연결 상태에서 pk값을 지우면 fk가 문제생김
delete from member where mem_name = '잇지';									-- 잇지 는 삭제가 가능, 값이 없어서 연결이 안되어있기 때문? 테이블(buy)에 존재하지 않기 때문 존재하지 않은 이유는 구매하지 않아서
select * from buy;








