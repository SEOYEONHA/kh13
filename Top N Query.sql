
-- Top N Query
-- 데이터베이스에서 데이터를 일정 구간 불러오기 위한 구문


-- select * from board wehre n페이지에 해당하는 글 order by board_no desc;
-- select * from board where 10*n-9번째 ~ 10*n번째 order by board_no desc;

-- rownum을 조회하면 조회 결과에 순서가 붙어 화면에 출력된다
select rownum, board.* from board;

select rownum, board.* from board order by board_no desc;

-- 구문을 분리하여 진행(선 정렬 후 넘버링)
select * from board order by board_readcount desc; -- 1번
select rownum, 1번 from 1번;

select rownum, TMP.* from(1번)TMP; 

select rownum, TMP.* from (
	select * from board order by board_readcount desc
)TMP where rownum between 1 and 10; -- 1페이지

select rownum, TMP.* from (
	select * from board order by board_readcount desc
)TMP where rownum between 11 and 20; -- 2페이지

select * from (
	select rownum rn, TMP.* from(
		select * from board order by board_readcount desc
		)TMP
) where rn between 11 and 20;

/*
	select * from (
	select rownum rn, TMP.* from(
		원하는 방식으로 정렬하는 조회구문(테이블 무관)
		)TMP
) where rn between 시작행번호 and 종료행번호;

스프링에선
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "원하는 조회방식의 구문"
							+ ")TMP"
						+ ") where rn between ? and ?";

*/
