/*
 	집계함수와 그룹쿼리
 	- 집계함수는 테이블의 정보를 모아서 하나의 결과로 만드는 함수 
 	- 단일행함수는 테이블 정보만큼의 결과를 만들어내는 함수
 */

--.단일행 함수는 조회 구문에 붙여서 사용할 수 있다
SELECT book_title, upper(book_title), lower(book_title), length(book_title) FROM book;

-- 집계 함수는 데이터 개수와 관계 없이 결과가 하나로 나온다
SELECT sum(book_price) FROM book;
SELECT avg(book_price) FROM book;
SELECT max(book_price) FROM book;
SELECT min(book_price) FROM book;
SELECT count(book_price) FROM book;

-- 집계함수는 조회 구문에 붙여서 사용할 수 없다
SELECT book_title, avg(book_price) FROM book; -- 오류

-- 집계함수를 전체가 아닌 그룹별로 적용할 수도 있다
-- ex) 전체 평균 가격 ---> 장르별 평균 가격
SELECT book_genre FROM book;

SELECT book_genre, sum(book_price), avg(book_price) FROM book GROUP BY book_genre;

-- (Q) product 테이블에서 상품종류별 개수와 최고, 최저가격을 출력
SELECT * FROM product;

SELECT type, count(type), max(price), min(price) FROM product GROUP BY TYPE; 
SELECT count(no) 개수, max(price) 최고가, min(price) 최저가 FROM product

SELECT type FROM product;
SELECT DISTINCT TYPE FROM product; -- 중복제거(그룹아님)
SELECT TYPE FROM product GROUP BY TYPE;

-- 포켓몬스터 속성별 개체수를 구하여 홈페이지에 출력(개수가 많은 순)
SELECT * FROM POCKETMON;
SELECT pocketmon_type, count(*) 개수 FROM pocketmon GROUP BY POCKETMON_TYPE ORDER BY 개수 DESC;
SELECT pocketmon_type count(pocketmon_TYPE) FROM POCKETMON group BY type;

