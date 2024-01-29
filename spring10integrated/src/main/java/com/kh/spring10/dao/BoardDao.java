package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	private BoardMapper boardMapper;
	
	//게시글 작성
	public void insert(BoardDto boardDto) {
		String sql = "insert into board("
						+ "board_no, board_title, board_content, board_writer, "
						+ "board_wtime) values(board_seq.nextval, ?, ?, ?, sysdate)";
		Object[] data = {
			boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriter()};
		
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
		String sql = "select * from board order by board_no asc";
		return jdbcTemplate.query(sql, boardMapper);
	}
	
	public List<BoardDto> selectList(String column, String keyword){
		String sql = "select * from board where instr(" + column + ", ?) > 0 "
								+ "order by " + column + " asc, board_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, boardMapper, data);
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
	public boolean updateReadcount(BoardDto boardDto) {
		String sql = "update board set board_readcount = board_readcount + 1 where board_no = ?";
		Object[] data = {boardDto.getBoardNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//게시물 삭제
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	
}
