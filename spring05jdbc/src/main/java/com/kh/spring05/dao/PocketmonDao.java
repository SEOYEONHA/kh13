package com.kh.spring05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring05.dto.PocketmonDto;
import com.kh.spring05.mapper.PocketmonMapper;

//DAO도 이제부터는 등록을 해야 한다
//- @Repository는 파일이나 데이터베이스와 같이 영속성 개체를 제어하는 도구
//- 등록된 도구끼리는 주세요(@AutoWired)가 가능

@Repository
public class PocketmonDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PocketmonMapper mapper;
	
	public void insert(PocketmonDto dto) {
		String sql = "insert into pocketmon("
						+ "pocketmon_no, pocketmon_name, pocketmon_type"
						+ ") values (?, ?, ?)";
		Object[] data = {
				dto.getPocketmonNo(), dto.getPocketmonName(), dto.getPocketmonType()
		};
		jdbcTemplate.update(sql, data);
	}
}
