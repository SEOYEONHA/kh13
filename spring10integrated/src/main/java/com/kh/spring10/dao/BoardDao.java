package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.mapper.BoardListMapper;
import com.kh.spring10.mapper.BoardMapper;
import com.kh.spring10.vo.PageVO;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private BoardMapper boardMapper;
	
	@Autowired
	private BoardListMapper boardListMapper; 
	
	//count, sequence, max, min, sum, avg 처럼 결과가 하나만 나오는 경우
	//그 결과는 객체가 아니라 원시데이터 형태일 확률이 높다
	//게시물 작성 후 디테일로 ..?
//	public int insertBoardNo() {
//		String sql = "select board_seq.nextval from dual";
//		//jdbcTemplate.qureryForObject(구문, 결과자료형); //String.class / doublc.class 전부 됨
//		//.class - 자료형 객체
//		return jdbcTemplate.queryForObject(sql, int.class);
//	}
//	
//	public int redirectDetail() {
//	    String sql = "select board_seq.currval from dual";
//	    return jdbcTemplate.queryForObject(sql, int.class);
//	}
	public int getSequence() {
		String sql = "select board_seq.nextval from dual";
		//jdbcTemplate.qureryForObject(구문, 결과자료형); //String.class / doublc.class 전부 됨
		//.class - 자료형 객체
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	//게시글 작성 - 등록할 대 시퀀스 번호를 생성하면 절!대! 안된다
	public void insert(BoardDto boardDto) {
		
//		String sql = "insert into board("
//						+ "board_no, board_title, board_content, board_writer, "
//						+ "board_wtime) values(?, ?, ?, ?, sysdate)";
		//sysdate에 default 걸려있어서 안써도 됨!
		String sql = "insert into board("
						+ "board_no, board_title, board_content, board_writer)"
						+ " values(?, ?, ?, ?)";
		Object[] data = { boardDto.getBoardNo(), 
			boardDto.getBoardTitle(), boardDto.getBoardContent(), 
			boardDto.getBoardWriter()
			};
		jdbcTemplate.update(sql, data);
	}
	
	//게시글 상세
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] data = {boardNo};
		
		List<BoardDto> boardList = jdbcTemplate.query(sql, boardMapper, data);
		
		return boardList.isEmpty() ? null : boardList.get(0);
	}
	
	//게시글 목록 및 검색
	public List<BoardDto> selectList(){
//		String sql = "select * from board order by board_no desc";
//		return jdbcTemplate.query(sql, boardMapper);
//	}
		String sql = "select board_no, board_title, board_writer, "
						+ "board_wtime, board_etime, board_readcount "
						+ "from board order by board_no desc";
		
		return jdbcTemplate.query(sql, boardListMapper);
	}
	
	public List<BoardDto> selectList(String column, String keyword){
//		String sql = "select * from board where instr(" + column + ", ?) > 0 "
//								+ "order by board_no desc";
//		Object[] data = {keyword};
//		return jdbcTemplate.query(sql, boardMapper, data);
//	}
		String sql = "select board_no, board_title, board_writer, "
						+ "board_wtime, board_etime, board_readcount "
						+ "from board where instr(" + column + ", ?) > 0 "
						+ "order by board_no desc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, boardListMapper, data);
		}

	//목록 + 페이징
	//- page는 현재 조회할 페이지 번호
	//- size는 조회할 페이지의 출력개수
	//- 위 두개를 이용하여 시작행(beginRow)과 종료행(endRow)를 계산
	public List<BoardDto> selectListByPaging(int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size - 1);
		
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select board_no, board_title, board_writer, "
								+ "board_wtime, board_etime, board_readcount "
								+ "from board order by board_no desc"
							+ ")TMP"
						+ ") where rn between ? and ?";
		Object[] data = {beginRow, endRow};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	//검색 페이징
	public List<BoardDto> selectListByPaging(String column, String keyword, 
																int page, int size){
		int endRow = page * size;
		int beginRow = endRow - (size - 1);
		
		String sql = "select * from ("
				+ "select rownum rn, TMP.* from ("
					+ "select board_no, board_title, board_writer, "
					+ "board_wtime, board_etime, board_readcount "
					+ "from board where instr(" + column + ", ?) > 0 "
					+ "order by board_no desc"
				+ ")TMP"
			+ ") where rn between ? and ?";
		Object[] data = {keyword, beginRow, endRow};
		return jdbcTemplate.query(sql, boardListMapper, data);
	}
	
	//통합 페이징
	public List<BoardDto> selectListByPaging(PageVO pageVO){
		if(pageVO.isSearch()) { //검색
			String sql = "select * from ("
					+ "select rownum rn, TMP.* from ("
						+ "select board_no, board_title, board_writer, "
						+ "board_wtime, board_etime, board_readcount, "
						+ "board_group, board_target, board_depth "
						+ "from board where instr(" + pageVO.getColumn() + ", ?) > 0 "
						//+ "order by board_no desc" //옛날방식(최신순)
						+ "connect by prior board_no = board_target "
						+ "start with board_target is null "
						+ "order siblings by board_group desc, board_no asc"
					+ ")TMP"
				+ ") where rn between ? and ?";
			Object[] data = {pageVO.getKeyword(), pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
		else { //목록
			String sql = "select * from ("
								+ "select rownum rn, TMP.* from ("
									+ "select board_no, board_title, board_writer, "
									+ "board_wtime, board_etime, board_readcount, "
									+ "board_group, board_target, board_depth "
									+ "from board "
									//+ "order by board_no desc" //옛날방식(최신순)
									+ "connect by prior board_no = board_target "
									+ "start with board_target is null "
									+ "order siblings by board_group desc, board_no asc"
								+ ")TMP"
							+ ") where rn between ? and ?";
			Object[] data = {pageVO.getBeginRow(), pageVO.getEndRow()};
			return jdbcTemplate.query(sql, boardListMapper, data);
		}
	}
	
	
	//카운트 - 목록일 경우와 검색일 경우를 각각 구현
	public int count() {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public int count(String column, String keyword) {
		String sql = "select count(*) from board "
				+ "where instr(" + column + ", ?) > 0";
		Object[] data = {keyword};
		return jdbcTemplate.queryForObject(sql, int.class, data);
	}
	
	//VO를 이용한 카운트
	public int count(PageVO pageVO) {
		if(pageVO.isSearch()) {//검색
			String sql = "select count(*) from board "
					+ "where instr(" + pageVO.getColumn() + ", ?) > 0";
			Object[] data = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
		else {//목록
			String sql = "select count(*) from board";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
	}
	
	
	//게시글 수정
	public boolean editBoard(BoardDto boardDto) {
		String sql = "update board "
								+ "set board_title = ?, board_content = ?, board_etime = sysdate "
								+ "where board_no = ?";
		Object[] data = { boardDto.getBoardTitle(), boardDto.getBoardContent(), 
								boardDto.getBoardNo()
								};
		
		return jdbcTemplate.update(sql, data) > 0;
		
	}
	
	//조회수 ...?
	public boolean updateReadcount(int boardNo) {
		String sql = "update board set board_readcount = board_readcount + 1 "
							+ "where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//게시물 삭제
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	

	
	
}
