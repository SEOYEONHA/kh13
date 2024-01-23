drop table member;
create table member(
member_id varchar2(20) primary key
				check(regexp_like(member_id, '^[a-z][a-z0-9]{7,19}$')),
member_pw varchar2(20) not null
				check(regexp_like(member_pw, '^[A-Za-z0-9!@#$]{6,15}$')),
member_nick varchar2(30) not null
				check(regexp_like(member_nick, '^[가-힣][가-힣0-9]{1,9}$')),
member_birth varchar2(10)
				check(regexp_like(member_birth, '^[0-9]{4}-[0-9]{2}-[0-9]{2}$')),
member_contact char(11)
				check(regexp_like(member_contact, '^010[0-9]{8}$')),
member_email varchar2(60) not null,
member_post varchar(6),
				check(regexp_like(member_post, '^[0-9]{5,6}$')),
member_address1 varchar2(300),
member_address2 varchar2(300),
member_level varchar2(20) default '일반회원'
				 		check(member_level in ('일반회원', '우수회원', '관리자')),
member_point number default 0,
member_join date default sysdate,
member_login date default null
);

select * from member;

INSERT INTO member (member_id, member_pw, member_nick, member_birth, member_contact, member_email, member_post, member_address1, member_address2)
VALUES ('johndoe123', 'P@ssw0rd', '홍길동', '1990-01-15', '01012345678', 'john.doe@example.com', '12345', '서울시 강남구', '123호');
INSERT INTO member (member_id, member_pw, member_nick, member_birth, member_contact, member_email, member_post, member_address1, member_address2)
VALUES ('alicewonder', 'A!1icePwd', '김철수', '1985-05-20', '01098765432', 'alice@example.com', '54321', '서울시 영등포구', '456호');
INSERT INTO member (member_id, member_pw, member_nick, member_birth, member_contact, member_email, member_post, member_address1, member_address2)
VALUES ('adminmaster', 'Master@123', '이영희', '1970-11-03', '01011112222', 'admin@example.com', '98765', '서울시 종로구', '789호');
INSERT INTO member (member_id, member_pw, member_nick, member_birth, member_contact, member_email, member_post, member_address1, member_address2)
VALUES ('user1234', 'User@pass', '박지성', '1982-09-08', '01044445555', 'user@example.com', '67890', '서울시 송파구', '101호');
INSERT INTO member (member_id, member_pw, member_nick, member_birth, member_contact, member_email, member_post, member_address1, member_address2)
VALUES ('vipcustomer', 'Vip@Pass123', '고객1', '1995-03-25', '01077778888', 'vip@example.com', '112233', '서울시 강북구', '202호');
