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
