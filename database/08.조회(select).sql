-- book 테이블
drop sequence book_seq;
create sequence book_seq;

drop table book;
create table book(
book_id number primary key,
book_title varchar2(300) not null,
book_author varchar2(90) 
	check(regexp_like(book_author, '^[^!@#$]+$')),
book_publication_date char(10) 
	check(regexp_like(book_publication_date, '^([0-9]{4})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$')),
book_price number default 0 not null check(book_price >= 0),
book_publisher varchar2(90),
book_page_count number not null check(book_page_count >= 1),
book_genre varchar2(15) not null
);

INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(1, 'Harry Potter 1', 'J.K. Rowling', '2001-06-26', 19.99, 'Scholastic', 320, 'Fantasy');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(2, 'To Kill a Mockingbird', 'Harper Lee', '1960-07-11', 14.99, 'Grand Central Publishing', 336, 'Classic');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(3, 'The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10', 12.99, 'Scribner', 180, 'Classic');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(4, '1984', 'George Orwell', '1949-06-08', 10.99, 'Secker & Warburg', 328, 'Dystopian');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(5, 'Pride and Prejudice', 'Jane Austen', '1813-01-28', 9.99, 'Penguin Classics', 432, 'Romance');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(6, 'The Hobbit', 'J.R.R. Tolkien', '1937-09-21', 15.99, 'Houghton Mifflin Harcourt', 320, 'Fantasy');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(7, 'The Catcher in the Rye', 'J.D. Salinger', '1951-07-16', 11.99, 'Little, Brown and Company', 224, 'Classic');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(8, 'Lord of the Rings', 'J.R.R. Tolkien', '1954-07-29', 29.99, 'Allen & Unwin', 1178, 'Fantasy');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(9, 'To the Lighthouse', 'Virginia Woolf', '1927-05-05', 13.99, 'Harcourt, Brace and Company', 209, 'Modernist');
INSERT INTO BOOK(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre) VALUES(10, 'The Alchemist', 'Paulo Coelho', '1988-06-01', 9.99, 'HarperOne', 208, 'Fiction');

/*
	조회(SELECT)
	- 데이터베이스에 저장된 데이터들을 원하는 기준에 맞게 읽어내는 것
	-SELECT 항목 FROM 테이블
*/

-- 전체 도서 조회
select * from book;
select book. * from book;

-- 도서명만 조회
select book_title from book;

-- 도서명과 페이지 수만 조회
select book_title, book_page_count from book;

-- 항목을 계산하여 추가로 조회할 수 있다
select book_title, length(book_title) from book;
select book_title 도서제목, length(book_title) 제목글자수 from book;
select book_title "도서 제목", length(book_title) "제목 글자수" from book;

-- 도서명과 출간년도를 조회하고 싶은 경우
-- select book_title 도서명, ???? 출간년도 from book;
-- substr(항목, 시작위치, 글자수) : 오라클은 문자열 위치 시작이 1부터임
select 
	book_title 도서명,
	substr(book_publication_date, 1, 4) 출간년도
from book;

-- 조건
-- - 제시한 조건에 부합하는 데이터만 조회(필터링)
-- - 조회구문 뒤에 'where 조건식'을 추가

-- 10달러 미만인 도서만 조회
select * from book where book_price < 10;

-- 10~15 달러 사이의 도서만 조회
select * from book where book_price >= 10 and book_price <= 15;
select * from book where book_price between 10 and 15;

-- 5번 도서 조회
select * from book where book_id = 5;

-- 5번 빼고 조회
select * from book where book_id != 5;

-- 문자 조건
-- [1] 장르가 Fantasy인 도서를 조회 (오라클은 문자도 = 로 비교)
select * from book where book_genre = 'Fantasy';
select * from book where lower(book_genre) = 'fantasy';

-- [2] T로 시작하는 도서 조회
-- like 연산자는 패턴을 지정할 때 사용하며 %는 해당자리는 무관하다는 뜻
-- instr 함수는 지정한 글자가 어느 위치에 있는지 알아내는 명령
-- 시작검사 만큼은 like 연산자가 매우 빠르며 나머지는 전반적으로 instr 함수가 빠르다
select * from book where book_title like 'T%';
select * from book where lower(book_title) like 't%';
select * from book where book_title like 'T%M%';
select * from book where instr(book_title, 'T') = 1;

-- (Q) 대소문자 상관 없이 h가 들어있는 도서를 조회
select * from book where lower(book_title) like '%h%';
select * from book where instr(lower(book_title), 'h') > 0; --추천

-- (Q) 저자명이 J로 시작하는 도서를 조회
select * from book where book_author like 'J%'; --추천
select * from book where instr(book_author, 'J') = 1;

-- (Q) 출판사명이 Company로 끝나는 도서를 조회
select * from book where book_publisher like '%Company'; -- 편하게 이거 추천
select * from book where instr(book_publisher, 'Company') = length(book_publisher) - length('Company') + 1;

-- (Q) 도서명에 숫자가 들어간 도서를 조회
select * from book where regexp_like(book_title, '[0-9]+');

-- (Q) 숫자로만 이루어진 도서를 조회
select * from book where regexp_like(book_title, '^[0-9]+$');
