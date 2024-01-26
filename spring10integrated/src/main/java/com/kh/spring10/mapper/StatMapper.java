package com.kh.spring10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kh.spring10.vo.StatVo;

public class StatMapper implements RowMapper<StatVo> {

	@Override
	public StatVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		StatVo statVo = new StatVo();
		statVo.setTitle(rs.getString("항목"));
		statVo.setCount(rs.getInt("개수"));
		return statVo;
	}

}
