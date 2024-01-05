/*
	날짜 데이터
	- date 또는 timestamp 형태를 사용
	- date는 초까지, timestamp는 밀리초까지 저장(timestamp가 더 정확한 시간까지 구현)
	- java.sql.Date 클래스와 date 형태가 호환됨
	- java.sql.Timestamp 클래스와 timestamp 형태가 호환됨
	- 연/월/일/시/분/초(+밀리초)가 모두 필요한 경우 사용한다
	- 변환명령은 to_date()
	- 변환 형식 : Y(연도), M(월), D(일), HH/HH24(시간), MI(분), S(초) → 대소문자 노상관
	- 현재시각을 구하는 키워드가 존재 (sysdate/systimestamp)
	- 날짜는 더하기 빼기가 가능(단위 : 일)
*/
drop sequence funding_seq;
create sequence funding_seq;

drop table fuding;
create table funding(
	funding_no number primary key,
	funding_title varchar2(90) not null,
	funding_dest number not null,
	funding_begin date not null,
	funding_end date not null
);

-- 날짜는 문자열로도 설정이 가능하다
insert into funding(
funding_no, funding_title, funding_dest, funding_begin, funding_end
)
values(
funding_seq.nextval, '자바 서적', 500000, '2024-01-10', '2024-01-31'
);
-- 변환 명령을 사용하면 더 정확하게 형식을 지정할 수 있다
-- to_date(값, 형식)
insert into funding(
	funding_no, funding_title, funding_dest, funding_begin, funding_end
)
values(
	funding_seq.nextval, '데이터베이스 서적', 600000, 
	to_date('2024-01-10', 'YYYY-MM-DD'), 
	to_date('2024-01-31', 'YYYY-MM-DD')
);

insert into funding(
	funding_no, funding_title, funding_dest, funding_begin, funding_end
)
values(
	funding_seq.nextval, '웹 개발 서적', 700000, 
	to_date('2024-01-05 10:58:30', 'YYYY-MM-DD HH24:MI:SS'), 
	to_date('2024-01-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS')
);

insert into funding(
	funding_no, funding_title, funding_dest, funding_begin, funding_end
)
values(
	funding_seq.nextval, '클라우드 서적', 700000, 
	sysdate, 
	to_date('2024-01-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS')
);

insert into funding(
	funding_no, funding_title, funding_dest, funding_begin, funding_end
)
values(
	funding_seq.nextval, '한달짜리 펀딩', 750000, 
	sysdate, sysdate+30
);


select * from funding;
