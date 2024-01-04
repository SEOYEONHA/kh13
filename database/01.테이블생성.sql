-- soccer 테이블 생성 구문
create table soccer(
rank number(2),
name varchar2(21),
win number(2),
draw number(2),
lose number(2)
);
drop table soccer;

-- account 테이블 생성 구문
create table account(
owner varchar2(21),
base_rate number(5,2),
plus_rate number(5,2),
monthly number,
period number(3)
);

DROP TABLE accout;

-- player 테이블 생성 구문
create table player(
name varchar2(21),
event varchar2(60),
type char(6),
gold number(3),
silver number(3),
bronze number(3)
);

drop table player;

-- 테이블을 만들고 데이터를 추가하도록 코드 작성
CREATE TABLE student(
name varchar2(21),
score number(3)
);

-- 데이터 추가
-- insert into 테이블이름(형식들) values(값들);
-- (주의) 오라클에서 문자열은 외따옴표를 쓴다
INSERT INTO student(name, score) VALUES ('홍길동', 85);

-- 데이터 조회
-- select * from 테이블이름;
SELECT * FROM student;

CREATE TABLE carrier (
company char(2),
product varchar2(15),
price number(6),
gb number(3),
calling number(4),
message number(4)
);


-- 데이터추가
INSERT INTO carrier(company, product, price, gb, calling, message) 
VALUES ('SK', '5G 언택트 52', 52000, 200, 1000, 2000);
INSERT INTO carrier(company, product, price, gb, calling, message) 
VALUES ('KT', '5G세이브', 45000, 100, 900, 1500);
INSERT INTO carrier(company, product, price, gb, calling, message) 
VALUES ('LG', '5G 시그니처', 130000, 500, 2000, 2500);

SELECT * FROM CARRIER;

