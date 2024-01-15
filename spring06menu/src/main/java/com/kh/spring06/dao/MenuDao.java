package com.kh.spring06.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.MenuDto;
import com.kh.spring06.mapper.MenuMapper;

@Repository
public class MenuDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MenuMapper mapper;
	
	public void insert(MenuDto dto) {
		String sql = "insert into menu("
						+ "menu_no, menu_name_kor, menu_name_eng, menu_type, menu_price"
						+ ") values(menu_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {dto.getMenuNameKor(), dto.getMenuNameEng(), 
				dto.getMenuType(), dto.getMenuPrice()
				};
		jdbcTemplate.update(sql, data);
	}
	
	public boolean update(MenuDto dto) {
		String sql = "update menu "
						+ "set menu_name_kor = ?, menu_name_eng = ?, menu_type = ?, "
						+ "menu_price = ? where menu_no = ?";
		Object[] data = {dto.getMenuNameKor(), dto.getMenuNameEng(), dto.getMenuType(), 
							dto.getMenuPrice(), dto.getMenuNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}
}
