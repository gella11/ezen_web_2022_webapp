

use market_db;
drop table if exists hongong4;		-- 테이블 존재하면 삭제
create table hongong4(
	tinyint_col 	tinyint,		-- 1바이트 +- 128
    smallint_col 	smallint,		-- 2바이트 +- 3만  정도
    int_col 		int,			-- 4바이트 +- 21억 정도
    bigint_col		bigint,			-- 8바이트 +- 21억 이상
    char_col 		char(10),		-- char(1~255) 		문자 고정 길이
    varchar_col 	varchar(10),	-- varchar(1~16383) 문자 가변 길이
    text_col		text,			-- text		1~65535
	longtext_col	longtext,		-- longtext 1~42억
    blob_col		blob,			-- blob 	1~65535 글자가 아닌 이미지 / 동영상 의 데이터 >> 이런 것을 '이진(Binary)' 데이터라고 부른다.
    longblob_col	longblob,		-- longblob 1~42억
    float_col		float,			-- float 소수점 7자리
    double_col		double,			-- double 소수점 15자리
    date_col		date,			-- date 날짜저장	[ yyyy-mm-dd ] 
    time_col		time,			-- time 시간저장	[ hh:mm::ss ]
    datetime_col	datetime		-- datetime 날짜시간 저장[ yyyy-mm-dd hh:mm:ss ]    
);
select * from hongong4;