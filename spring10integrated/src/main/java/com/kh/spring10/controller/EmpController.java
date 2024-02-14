package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.EmpDao;
import com.kh.spring10.dto.EmpDto;
import com.kh.spring10.dto.PocketmonDto;
import com.kh.spring10.vo.PageVO;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	private EmpDao dao;
	
	//등록 페이지
	//@RequestMapping("/insert")
	@GetMapping("/insert") //GET방식 - 일반적인 주소를 이용한 접근
	public String insert() {
		return "/WEB-INF/views/emp/insert1.jsp";
	}
	
	//@RequestMapping("/insert")
	@PostMapping("/insert") //POST방식 - Form을 이용한 데이터 전송 접근
	public String insert(@ModelAttribute EmpDto dto) {
		dao.insert(dto);
		return "redirect:insert3";
	}
	
	@RequestMapping("/insert3")
	public String insert3() {
		return "/WEB-INF/views/emp/insert3.jsp";
	}
	
	//수정 페이지
	//- 수정페이지는 일반적으로 상세/목록에서 들어온다
	//- 처음에 정보가 다 표시되어 있어야한다
	//- 그러기 위해서 출력페이지에서 기본키(PK) 정도는 전달받아야 한다
	//- 무언가를 화면으로 전달하고 싶다면 매개변수에 Model 객체를 선언
	//- model은 Map<String, Object> 형태
	@GetMapping("/edit")
	public String edit(@RequestParam int empNo, Model model) {
		EmpDto dto = dao.selectOne(empNo);
		//model.addAttribute("이름", 데이터);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/emp/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute EmpDto dto) {
		if(dao.update(dto)) {
			//return "redirect:editSuccess";
			return "redirect:detail?empNo=" + dto.getEmpNo();
		}
		else{
			return "redirect:editFail";
		}
	}
	@RequestMapping("/editSuccess")
	public String editSuccess() {
		return "/WEB-INF/views/emp/editSuccess.jsp";
	}
	@RequestMapping("/editFail")
	public String editFail() {
		return "/WEB-INF/views/emp/editFail.jsp";
	}
	
	//목록 & 검색 페이지
	
	//@RequestMapping(values = "/list", method = RequestMehod.GET)
//	@RequestMapping("/list")
//	public String list(@RequestParam(required = false) String column,
//							@RequestParam(required = false) String keyword, 
//							Model model) {
//		boolean isSearch = column != null && keyword != null;
//		List<EmpDto> list = isSearch ? dao.selectList(column, keyword) : dao.selectList();
//		
//		model.addAttribute("isSearch", isSearch);
//		model.addAttribute("list", list);
//		return "/WEB-INF/views/emp/list2.jsp";
//	}
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVO vo, 
									Model model) {
		int count = dao.count(vo);
		vo.setCount(count);
		
		List<EmpDto> list = dao.selectListByPaging(vo);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/emp/list2.jsp";
	}
	
	//상세페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam int empNo, Model model) {
		EmpDto dto = dao.selectOne(empNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/emp/detail.jsp";
	}
	
	//@RequestMapping("/delete")
	@GetMapping("/delete")
	public String delete(@RequestParam int empNo) {
		dao.delete(empNo);
		return "redirect:list";
	}
	
}
