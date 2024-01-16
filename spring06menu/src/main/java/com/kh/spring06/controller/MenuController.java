package com.kh.spring06.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.MenuDao;
import com.kh.spring06.dto.MenuDto;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MenuDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute MenuDto dto) {
		dao.insert(dto);
		return "메뉴정보 등록 완료";
	}
	
	@RequestMapping("/change")
	public String change(@ModelAttribute MenuDto dto) {
//		boolean result = dao.update(dto);
//		if(result) {
//			return "메뉴정보 수정 완료";
//		}
		if(dao.update(dto)) {
			return "메뉴정보 수정 완료";
		}
		else {
			return "존재하지 않는 메뉴 번호입니다.";
		}
	}

	@RequestMapping("/delete")
	//http://localhost:8080/menu/delete?menuNo=21
	public String delete(@RequestParam int menuNo) {
		if(dao.delete(menuNo)) {
			return "메뉴정보 삭제 완료";
		}
		else {
			return "존재하지 않는 메뉴번호 입니다";
		}
	}
	
	@RequestMapping("/list")
	//http://localhost:8080/menu/list?column=menu_name_kor&keyword=라떼
	public String list(
				@RequestParam(required = false) String column, 
				@RequestParam(required = false) String keyword
			) {
		boolean isSearch = column != null && keyword != null;
//		List<MenuDto> list;
//		if(isSearch) {
//			list = dao.selectList(column, keyword);
//		}
//		else {
//			list = dao.selectList();
//		}
		List<MenuDto> list = isSearch ? dao.selectList(column, keyword) : dao.selectList();
		
		DecimalFormat fmt = new DecimalFormat("#,##0");
				
		StringBuffer buffer = new StringBuffer();
		for(MenuDto dto:list) {
			buffer.append("[");
			buffer.append(dto.getMenuType());
			buffer.append("] ");
			buffer.append(dto.getMenuNameKor());
			buffer.append(" (");
			buffer.append(dto.getMenuNameEng());
			buffer.append(") : ");
			buffer.append(fmt.format(dto.getMenuPrice()));
			buffer.append("원");
			buffer.append("<br>"); //HTML의 엔터
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int menuNo) {
		MenuDto dto = dao.selectOne(menuNo);
		if(dto != null) {
			DecimalFormat fmt = new DecimalFormat("#,##0");
			StringBuffer buffer = new StringBuffer();
			buffer.append("[");
			buffer.append(dto.getMenuType());
			buffer.append("] ");
			buffer.append(dto.getMenuNameKor());
			buffer.append(" (");
			buffer.append(dto.getMenuNameEng());
			buffer.append(") : ");
			buffer.append(fmt.format(dto.getMenuPrice()));
			buffer.append("원");
			buffer.append("<br>");
			return buffer.toString();
		}
		else {
			return "존재하지 않는 메뉴 번호입니다.";
		}
	}
}
