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
board_readcount number default 0
								check (board_readcount >= 0) -- 작성 시점에 0으로 설정, 0 이상만 설정가능  
);

drop table board;
INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime)
VALUES (board_seq.nextval, '제목1', '내용1', 'adminuser1', SYSDATE);

select * from board;

select * from board where board_no = board_seq.nextval from dual;

select board_seq.nextval from dual;
select board_seq.currval from dual;
