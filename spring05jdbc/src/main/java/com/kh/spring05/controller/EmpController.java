package com.kh.spring05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05.dao.EmpDao;
import com.kh.spring05.dto.EmpDto;
import com.kh.spring05.dto.PocketmonDto;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmpDao dao;
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute EmpDto dto) {
		dao.insert(dto);
		return "사원정보 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute EmpDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "사원정보 수정 완료";
		}
		else{
			return "존재하지 않는 사원 번호입니다.";
		}
	}
	
	@RequestMapping("/delete")
	//http://localhost:8080/emp/delete?empNo=22
	public String delete(@RequestParam int empNo) {
		if(dao.delete(empNo)) {
			return "사원정보 삭제 완료";
			}
		else {
			return "존재하지 않는 사원 번호입니다.";
		}
	}
	
	@RequestMapping("/list")
	public String list(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<EmpDto> list;
		if(isSearch) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		StringBuffer buffer = new StringBuffer();
		for(EmpDto dto:list) {
			buffer.append("사원 No.");
			buffer.append(dto.getEmpNo());
			buffer.append(" - ");
			buffer.append(dto.getEmpName());
			buffer.append(" (");
			buffer.append(dto.getEmpDept());
			buffer.append(")");
			buffer.append("<br>"); //HTML의 엔터
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int empNo) {
		EmpDto dto = dao.selectOne(empNo);
		if(dto != null) {
			StringBuffer buffer = new StringBuffer();
//			buffer.append("사원 No.");
//			buffer.append(dto.getEmpNo());
//			buffer.append(" - ");
//			buffer.append(dto.getEmpName());
//			buffer.append(" (");
//			buffer.append(dto.getEmpDept());
//			buffer.append(")");
			buffer.append("사원번호 - " + dto.getEmpNo() + "<br>");
			buffer.append("사원명 - " + dto.getEmpName() + "<br>");
			buffer.append("부서명 - " + dto.getEmpDept() + "<br>");
			buffer.append("입사일 - " + dto.getEmpDate() + "<br>");
			buffer.append("급여 - " + dto.getEmpSal() + "<br>");
			return buffer.toString();
		}
		else {
			return "존재하지 않는 사원 번호입니다.";
		}
	}
	
						
}
