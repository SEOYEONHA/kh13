-- book 테이블 문제

drop sequence book_seq;
create sequence book_seq;

drop table book;
create table book(
	book_id number primary key,
	book_title varchar(300) not null,
	book_author varchar(90) check(regexp_like(book_author, '^[^!@#$]+$')),
	book_publication_date date,
	book_price number(*,2) default 0 not null check(book_price >= 0),
	book_publisher varchar(90),
	book_page_count number not null check(book_page_count > 0),
	book_genre varchar(90) not null
);

insert into book(
	book_id, book_title, book_author, book_publication_date, book_price, 
	book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '미움받을 용기', '기시미 이치로, 고가 후미타케', 
	to_date('2014-11-17', 'YYYY-MM-DD'), 15.70 , '인플루엔셜', 
	340, '교양심리'
);

insert into book(
	book_id, book_title, book_author, book_publication_date, book_price, 
	book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '나는 메트로폴리탄 미술관의 경비원입니다 
								- 경이로운 세계 속으로 숨어버린 한 남자의 이야기', 
	'패트릭 브링리 (지은이),김희정,조현주 (옮긴이)', 
	to_date('2023-11-24', 'YYYY-MM-DD'), 15.75 , '웅진지식하우스', 
	360, '미술에세이'
);

insert into book(
	book_id, book_title, book_author, book_publication_date, book_price, 
	book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '퓨처 셀프', '벤저민 하디 (지은이),최은아 (옮긴이)', 
	to_date('2023-08-30', 'YYYY-MM-DD'), 15.75 , '상상스퀘어', 
	292, '자기계발'
);

insert into book(
	book_id, book_title, book_author, book_publication_date, book_price, 
	book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '내가 생각한 인생이 아니야', '류시화', 
	to_date('2023-12-21', 'YYYY-MM-DD'), 16.20 , '수오서재', 
	262, '문인에세이'
);

select * from book;
