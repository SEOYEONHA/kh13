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
board_readcount number default 0 not null
								check (board_readcount >= 0), -- 작성 시점에 0으로 설정, 0 이상만 설정가능
-- 계층형 게시판과 관련된 3개의 항목을 추가								
board_group number not null,
board_target references board(board_no) on delete cascade, --자기참조
board_depth number not null check(board_depth >= 0), 

);

drop table board;
INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime)
VALUES (board_seq.nextval, '제목1', '내용1', 'adminuser1', SYSDATE);

select * from board;

select * from board where board_no = board_seq.nextval from dual;

select board_seq.nextval from dual;
select board_seq.currval from dual;



-- 1000개의 샘플 데이터 생성
INSERT INTO board (board_no, board_title, board_content, board_wtime, board_readcount)
SELECT
    board_seq.NEXTVAL,
    '샘플 제목 ' || level,
    '샘플 내용 ' || level,
    SYSDATE - ROUND(DBMS_RANDOM.VALUE(1, 365)), -- 작성일은 최대 1년 전부터 현재까지 랜덤
    ROUND(DBMS_RANDOM.VALUE(0, 100)) -- 조회수는 0부터 100까지 랜덤
FROM
    dual
CONNECT BY
    level <= 1000;
   
update board set board_writer = 'testuser3';
commit;
rollback;
