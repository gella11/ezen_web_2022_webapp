-- db 삭제
-- drop database market_db;			-- market_db 데이터베이스 삭제 오류 [없으니까]
drop database if exists market_db;	-- 만약 market_db가 존재하면 우선 삭제한다.

create database market_db;

use market_db;						-- usb db명 : 해당 db사용[선택]
create table member(				-- ( 필드명 1 자료형 속성 , 필드명2 자료형 속성 , 필드명3 자료형 속성);
	mem_id char(8) not null primary key,
    -- char(길이) : 길이만큼 문자 저장
    -- not ull 	 : 공백 저장 불가능 [ 만일 공백이 있으면 저장 실패 ]
    -- primary key : *(기본키) 식별키[필드] , 필드내 데이터 중복 불가능 (주민번호 , 학번 , 회원번호 , 사번 등)
    mem_name varchar(10) not null,
    -- varchar vs char
    -- 가변길이 : varchar(8) : 에서 'abc' 저장시 5칸 메모리 자동 제거 [저장된 만큼 메모리 할당]
    -- 고정길이 : char(8) : 에서 'abc' 저장시 8칸 메모리 고정 [ 3칸 : abc 5칸:빈공간] 선언된 길이 만큼 고정 메모리 할당, 
    mem_number int not null,
    -- int : 정수 +-20억 까지 저장
    addr char(2) not null,
    phone1 char(3),
    phone2 char(8),
    height smallint,
    -- smallint : 정수 +-3만 정도 가능
    debut_date date
    -- date : 날짜
);				

select * from member;


create table buy(
	num int auto_increment not null primary key,		-- 1. 순번 
    -- auto_increment : 레코드 추가시 자동번호 부여
    mem_id char(8) not null,							
    prod_name char(6) not null,
    group_name char(4),
    price int not null,
    amount smallint not null,
    foreign key( mem_id ) references member( mem_id )		-- member테이블의 mem_id(pk) 필드와 연결 (관계라고 함)	-- pk를 다르게 해도 되지만 구분하는 걸 쉽게하기 위해 동일하게 하는 편
    -- 참조(references) : 다른 것과 참조[ 본다 / 연결한다 / 가져온다] 한다.
    -- 외래키(foreign key) : references 테이블명(기본키)
);
/*
	관계 : 서로 다른 테이블끼리 연결
    
    member테이블					buy 테이블
		mem_id [pk 필드]				mem_id [pk 필드]
	만일 '트와이스' 가 제품 구매할 경우
		1) member테이블의 mem_id가 '트와이스'존재한다는 가정하에
        2) '트와이스'가 제품 구매시 buy테이블의 mem_id가 '트와이스' 추가
	만일 '트와이스' 가 제품 3개 구매할 경우
		member테이블					buy 테이블
			mem_id : '트와이스'			mem_id : '트와이스'	지갑
										mem_id : '트와이스'	냉장고
										mem_id : '트와이스'	가방
*/

select * from buy;


INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

/*----------------------예제-----------------------*/
select * from buy;
use market_db;

select * from member;
	-- select : 테이블에서 데이터 검색할 때 사용되는 키워드
    -- *(별) : '와일드카드' 라고 모든 것을 의미 = 모든 필드
    
select mem_name from member; 					 							  -- 2-1 특정 필드 검색 [ member테이블에서 mem_name 검색 ]
select addr , debut_date , mem_name from member; 							  -- 2-2 [ member테이블에서 addr , debut_date , mem_name 검색 ]
select addr as 주소 , debut_date as '데뷔 일자' , mem_name as 회원_명 from member; -- 2-3 '별칭' [결과의 필드명 바꾸기 (원본 필드명은 그대로 유지) ] [띄어쓰기 하려면 '' 쓰고 띄어쓰기보단 언더바 사용 권장]
																					-- 필드명 as 별칭명
																					-- 필드명 별칭명
																					-- 필드명 as "별칭 명"
																					-- 필드명 as 별칭_명
                                                                                    
select * from member where mem_name = '블랙핑크';								-- 3. 특정 조건만 조회하기
																			-- select 필드명 from 테이블명 where 조건식
select * from member where mem_number = 4;
select mem_id , mem_name from member where height <=162;
select mem_name , height , mem_number from member where height >= 165 and mem_number > 6;	-- 평균키가 165 이상 , 멤버수 6 초과 인 필드 검색
select mem_name , height , mem_number from member where height >= 165 or mem_number > 6;	
select mem_name , height , mem_number from member where height between 163 and 165;			-- between ~ and 
select mem_name , height , mem_number from member where height >= 163 and height <= 165;
select mem_name , addr from member where addr = '경기'  or addr ='전남' or addr ='경남';		-- in : 하나라도 포함된 [ or뜻 ]
select mem_name , addr from member where addr in('경기' , '전남' , '경남');
select * from member where mem_name = '우주소녀';
select * from member where mem_name like '우%'; 												-- mem_name이 '우' 시작하는 레코드 검색
select * from member where mem_name like '__핑크%'; 											-- mem_name이 '4글자' 이면서 '핑크'로 끝나는 레코드 검색
-- % : 모든 문자 대증
-- 		김% : 김으로 시작하는 모든 글자
-- 		%김% : 김이 포함된 모든 글자
-- 		%김 : 김으로 끝나는 모든 글자
-- _ : 개수만큼 문자 대응
-- 		김_ : 김으로 시작하는 2글자
-- 		_김_: 2번째 글자가 '김' 인 3글자
-- 		_김 : 김으로 끝나는 2글자

-- p.125
-- order by : 정렬
	-- select * from 테이블명 order by 기준필드 asc/desc;	[asc : 오름차순 (생략시 기본값) desc : 내림차순	[asending descending] [ ★★★★★모든 명령어 마지막에 들어감 정렬을 마지막에 하니께 ] ]
	select mem_id , mem_name , debut_date from member order by debut_date;									-- 검색결과를 데뷔일자 기준으로 오름차순
	select mem_id , mem_name , debut_date from member order by debut_date desc;								-- 검색결과를 데뷔일자 기준으로 내림차순

	-- select * from 테이블명 where 조건식 order by 기준필드 asc/desc;
    select mem_id , mem_name , debut_date , height from member order by height desc where height >= 164;	-- 오류
    select mem_id , mem_name , debut_date , height from member where height >= 164 order by height desc;	-- 오류 해결
    
    -- select * from 테이블명 order by 기준필드 1 desc , 기준필드2 asc; 다수정렬
    -- 1차 정렬 ★★★★내에서★★★★ , 2차 정렬 
    select mem_id , mem_name , debut_date , height from member where height >= 164 order by height desc , debut_date asc;
  
-- p.128
-- limit : 출력의 개수 제한
	-- limit 시작(1) , 개수 [시작 생략시 0부터]
	select * from member limit 3;				 							 -- 전체중 앞에서 3개 레코드만 출력
    select * from member limit 0, 3;
    select * from member limit 0, 4;
    select * from member limit 1, 3;										 -- 전체중 2번째 부터 3개 레코드만 출력
    select mem_name , height from member order by height desc;
    select mem_name , height from member order by height desc limit 3, 2;

-- p.129
-- distinct : 결과에서 중복 데이터 제거
	select addr from member;
    select distinct addr from member;			 -- 중복 제거
    
-- p.131
-- group by : 특정 필드 묶기
	select * from buy order by mem_id;
	select mem_id , amount from buy order by mem_id;
    select sum(amount) from buy;											-- sum(필드명) 'buy' 테이블의 'amount' 의 데이터 총합
    select avg(amount) from buy;											-- amount 평균
	select min(amount) from buy;											-- amount 최솟값
    select max(amount) from buy;											-- amount 최댓값
    select count(amount) from buy;											-- amount 의 레코드 수	[ 해당 페이지가 null 이면 제외 ]
    select count(*) from buy;												-- 모든 레코드 개수		[ null 포함 ]
	select count(distinct amount) from buy;  								-- 레코드 개수 [ 중복 제거 ]

	select mem_id , sum(amount) from buy;									-- group by 를 안하면 이상하게 나옴
	select mem_id , sum(amount) as 수량합계 from buy group by mem_id;
	select mem_id as 회원_아이디 , sum(price*amount) as 총_구매금액 from buy group by mem_id;
    select mem_id , avg( amount ) as 수량평균 from buy group by mem_id;		-- 회원아이디 별 수량 평균
    select mem_id , count( phone1) as 연락처 from member  group by mem_id;	-- 회원 아이디 별 연락처가 있는 회원수 [ null 제외 ]
    select mem_id , count( * ) as 회원수 from member group by mem_id;			-- 회원 아이디 별 회원수 		   [ null 포함 ]	[ 인원수와 회원수 다름 ]
    
-- p.132
-- having 절 : 그룹 조건
	-- where  : 일반 조건
	-- having : 그룹 조건
    select mem_id as 회원아이디 , sum( price * amount ) as 총구매금액
    from buy
    where sum( price * amount ) > 1000										-- 오류 발생 : sum() : 집계함수 이므루 그룹 후에 조건 사용 가능
    group by mem_id;
    
	select mem_id as 회원아이디 , sum( price * amount ) as 총구매금액
    from buy
    group by mem_id
	having sum( price * amount ) > 1000
    order by 총구매금액 desc;
    -- order by sum( price * amount) desc;