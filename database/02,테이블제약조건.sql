/* 여러 줄 주석(자바와 동일)
	
	테이블 제약조건(table constraint)
	- 테이블에 추가되는 데이터에 대한 조건을 설정할 수 있다
	- 종류는 null, 중복, 값의범위or조건 등이 있다
	- null을 허용하지 않으려면 컬럼 옆에 not null 키워드를 추가한다
	- 중복을 허용하지 않으려면 컬럼 옆에 unique 키워드를 추가한다
	- 허용되는 값을 지정하려면 컬럼 옆에 check 키워드를 추가한다
*/

CREATE TABLE menu(
menu_name varchar2(60) NOT NULL UNIQUE
	CHECK(regexp_like(menu_name, '^[가-힣]+$')),
menu_type varchar2(9) NOT NULL CHECK(menu_type IN ('디저트', '음료')),
menu_price NUMBER NOT NULL CHECK(menu_price >= 0),
-- menu_event char(1) NOT NULL CHECK(menu_event = 'Y' OR menu_event = 'N')
menu_event char(1) NOT NULL CHECK(menu_event IN ('Y', 'N'))
);
DROP TABLE menu;

INSERT INTO menu(menu_name, menu_type, menu_price, menu_event)
values('아메리카노', '디저트', 3000, 'N');

SELECT * FROM menu;
