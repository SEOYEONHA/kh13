package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.ReplyDto;
import com.kh.spring10.mapper.ReplyMapper;

@Repository
public class ReplyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	//댓글은 전체 목록이 없습니다 (게시글마다 조회)
	public List<ReplyDto> selectList(int replyOrigin) {
		String sql = "select * from reply "
						+ "where reply_origin=? "
						+ "order by reply_no asc";
		Object[] data = {replyOrigin};
		return jdbcTemplate.query(sql, replyMapper, data);
	}
	
}