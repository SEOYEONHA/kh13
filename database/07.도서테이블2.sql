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
select * from book;
