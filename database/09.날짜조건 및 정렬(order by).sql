drop table product;
create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕')),
price number,
made date,
expire date
);

insert into product values(1, '스크류바', '아이스크림', 1200, '2020-05-01', '2020-10-01');
insert into product values(2, '마이쮸', '사탕', 900, '2020-01-01', '2021-01-01');
insert into product values(3, '초코파이', '과자', 3000, '2020-01-01', '2021-01-01');
insert into product values(4, '맛동산', '과자', 2200, '2020-02-01', '2020-10-20');
insert into product values(5, '참이슬', '주류', 1000, '2020-01-05', '2020-04-05');
insert into product values(6, '처음처럼', '주류', 1000, '2020-03-15', '2020-08-15');
insert into product values(7, '바나나킥', '과자', 1500, '2020-05-03', '2020-06-03');
insert into product values(8, '빠삐코', '아이스크림', 1000, '2019-12-01', '2020-06-01');
insert into product values(9, '멘토스', '사탕', 1200, '2020-03-20', '2020-12-31');
insert into product values(10, '오레오', '과자', 2100, '2019-06-01', '2020-06-01');

-- 날짜 조건
-- -특정 항목을 검사하거나 기간으로 검색하는 경우가 많다
select * from product;

-- 2020년에 제조된 상품 조회
select * from product where extract(year from made) = 2020;
select * from product where to_char(made, 'YYYY') = '2020';

select * from product where 
	made >= to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	and
	made <= to_date('2020-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');

select * from product where 
	made between 
	to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	and
	to_date('2020-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');
	
-- (Q) 여름에 제조한 상품 목록 조회(6,7,8월)
select * from product where extract(month from made) in (6,7,8);
select * from product where extract(month from made) between 6 and 8;
select * from product where to_char(made, 'MM') in ('06', '07', '08');

-- (Q) 2019년 하반기에 제조한 상품 목록 조회(7~12월)
select * from product where 
	extract(year from made) = 2019
	and
	extract(month from made) between 7 and 12;

select * from product where 
	made between 
	to_date('2019-07-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	and
	to_date('2019-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS');

-- (Q) 2020년 이후에 현재까지 제조한 상품 목록 조회
select * from product where 
	made between 
	to_date('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
	and sysdate;

-- (Q) 최근 5년간 제조한 상품 목록 조회
select * from product where 
	made between sysdate - 5*365 and sysdate;
	
-- (Q) 위 문제를 5분으로 바꿀 때
select * from product where 
	made between sysdate - 5/24/60 and sysdate;

-- 정렬(order by)
-- 조건으로 데이터까지 다 골라냈다면 원하는 기준에 맞게 정렬할 수 있다
-- 조회 구문의 마지막에 'order by 항목 asc/desc'를 적는다
-- (중요) 조건보다 뒤에 작성되어야 한다
	
select * from book;
select * from product;

select * from book order by book_id asc; -- 오름차순
select * from book order by book_id desc; -- 내림차순

-- (Q) product 테이블에서 상품을 최근 제조한 순으로 조회 (최신순)
select * from product order by made desc;
select * from product order by made desc, no asc; -- 좀 더 안전한 코드

-- (Q) 상품을 이름순으로 출력
select * from product order by name asc;
select * from product order by name asc, no asc;

-- (Q) 상품을 종류별로 가격이 비싼 순으로 출력
select * from product order by type asc, price desc, no asc;
	
-- (Q) 유통기한이 가장 짧은 상품부터 출력
select * from product order by made - expire desc, no asc;
select * from product order by expire - made asc, no asc;

select product.*, expire - made 유통기한 from product 
	order by 유통기한 asc, no asc;
