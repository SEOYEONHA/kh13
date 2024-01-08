/*
	게시판 테이블 생성 문제
	다음 조건을 만족하는 테이블을 생성하고 샘플 데이터를 등록하시오
	
	게시판 테이블(table board)
	게시글 번호(board_no)
	필수 항목이며 중복이 불가한 숫자
	게시글 제목(board_title) 
	한글 100자 이내로 설정 가능하며 필수 항목
	게시글 내용(board_content)
	가능한 최대의 문자열 크기로 설정하며 필수 항목
	게시글 작성자(board_writer)
	게시글 작성한 사람의 아이디(영문숫자8~20자)
	작성자가 탈퇴한 경우 null로 설정됨
	게시글 조회수(board_readcount)
	0 이상의 숫자로 설정되는 항목
*/

-- 테이블 생성
create table board(
board_no number primary key,
board_title varchar2(300) not null, 
	--check(regexp_like(board_title, '^[ㄱ-ㅎ가-힣 ]+$')),
board_content varchar2(4000) not null,
board_writer varchar2(20) 
	check(regexp_like(board_writer, '^[A-Za-z0-9]{8,20}$')),
board_readcount number not null check(board_readcount >= 0)
);


-- 테이블 삭제
drop table board;

-- 샘플데이터
insert into board(board_no, board_title, board_content, board_writer, board_readcount)
values(1, '너무 어려워요', '흑흑','SEOYEONHA', 3);
insert into board(board_no, board_title, board_content, board_writer, board_readcount)
values(2, '제목은 한글만 되는건가요', '글 내용입니다.',null, 30);
insert into board(board_no, board_title, board_content, board_writer, board_readcount)
values(3, '특수문자나 숫자는 안되는건가용', '글 내용2입니다.','SEOYEONHA', 300);

-- 데이터조회
select * from board;
