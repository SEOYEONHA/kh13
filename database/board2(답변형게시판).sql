--답변형(계층형) 게시판 테이블과 시퀀스

drop sequence board_Seq;
create sequence board_seq; -- board 시퀀스 생성
-- 게시판(board) 테이블
create table board(
board_no number primary key, --게시글 번호, 시퀀스로 자동부여
board_title varchar2(300) not null, -- 게시글 제목, 필수항목, 한글 100자이내
board_content varchar2(4000) not null, -- 게시글 내용, 필수항목, 허용가능한 최대치
board_writer references member(member_id) on delete set null, -- 게시글 작성자, 회원만 작성가능, 회원이 탈퇴될 경우 null로 변경
board_wtime date default sysdate, -- 작성 시점의 현재시각으로 자동설정
board_etime date default null, --작성 시점에는 null, 변경할 때 현재시각으로 자동설정 
board_readcount number default 0 not null, 
check (board_readcount >= 0), -- 작성 시점에 0으로 설정, 0 이상만 설정가능
-- 계층형 게시판과 관련된 3개의 항목을 추가								
board_group number not null, --그룹번호
board_target references board(board_no) on delete cascade, --자기참조(상위글)
board_depth number not null check(board_depth >= 0) --차수
);


insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(1, '첫 번째 게시글입니다', '첫 번째 게시글의 내용입니다', 1, null, 0);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(2, '두 번째 게시글입니다', '두 번째 게시글의 내용입니다', 2, null, 0);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(3, '세 번째 게시글입니다', '세 번째 게시글의 내용입니다', 3, null, 0);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(4, '네 번째 게시글입니다', '네 번째 게시글의 내용입니다', 3, 3, 1);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(5, '다섯 번째 게시글입니다', '다섯 번째 게시글의 내용입니다', 3, 3, 1);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(6, '여섯 번째 게시글입니다', '여섯 번째 게시글의 내용입니다', 3, 4, 2);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(7, '일곱 번째 게시글입니다', '일곱 번째 게시글의 내용입니다', 3, 5, 2);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(8, '여덟 번째 게시글입니다', '여덟 번째 게시글의 내용입니다', 3, 4, 2);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(9, '아홉 번째 게시글입니다', '아홉 번째 게시글의 내용입니다', 3, 3, 1);
insert into board(board_no, board_title, board_content, board_group, board_target, board_depth) 
values(10, '열 번째 게시글입니다', '열 번째 게시글의 내용입니다', 3, 6, 3);


drop table board;
INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime)
VALUES (board_seq.nextval, '제목1', '내용1', 'adminuser1', SYSDATE);

select * from board;

select * from board where board_no = board_seq.nextval from dual;

select board_seq.nextval from dual;
select board_seq.currval from dual;



commit;
rollback;
