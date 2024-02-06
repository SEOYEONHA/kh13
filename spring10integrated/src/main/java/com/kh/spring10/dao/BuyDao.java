package com.kh.spring10.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BuyDto;
import com.kh.spring10.mapper.BuyMapper;

@Repository
public class BuyDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BuyMapper buyMapper;
	
	public void insert(BuyDto buyDto) { 
		String sql = "insert into buy("
						+ "buy_serial, member_id, item_no, item_name, buy_qty, buy_total) "						
						+ "values(buy_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {
				buyDto.getMemberId(), buyDto.getItemNo(), buyDto.getItemName(), 
				buyDto.getBuyQty(), buyDto.getBuyTotal()
		};
		jdbcTemplate.update(sql, data);
	}
}
