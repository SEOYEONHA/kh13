package com.kh.spring10.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.AttachDto;
import com.kh.spring10.mapper.AttachMapper;

@Repository
public class AttachDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private AttachMapper attachMapper;
	
	public int getSequence() {
		String sql = "select attach_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(AttachDto attachDto) {
		String sql = "insert into attach("
							+ "attach_no, attach_name, attach_type, attach_size"
							+ ") values(?, ?, ?, ?)";
		Object[] data = {
				attachDto.getAttachNo(), attachDto.getAttachName(), 
				attachDto.getAttachType(), attachDto.getAttachSize()
		};
		jdbcTemplate.update(sql, data);
	}
}
