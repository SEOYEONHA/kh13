/*
	시퀀스(sequence)
	- 데이터베이스 객체 중 하나
	- 번호 생성기
	- 테이블과 세트로 사용하는 경우가 많으며 "기본키" 를 생성하는 목적으로 주로 사용함
*/

drop sequence product_seq;
create sequence product_seq;
-- create sequence product_seq nocache;
drop table product;
create table product(
product_no number primary key,
product_name varchar2(60) not null,
product_price number not null
);

-- 시퀀스를 이용한 데이터 생성(시퀀스이름.nextval)
insert into product(product_no, product_name, product_price)
values(product_seq.nextval , '30인치 모니터', 250000);
insert into product(product_no, product_name, product_price)
values(product_seq.nextval , 'RTX 3080 ti', 1460000);

select * from product;

-- 시퀀스의 자세한 정보 확인
select * from user_sequences;

