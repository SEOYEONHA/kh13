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

import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dto.MenuDto;
import com.kh.spring10.vo.PageVO;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	private MenuDao dao;
	
	//등록 페이지
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/menu/insert.jsp";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MenuDto dto) {
		dao.insert(dto);
		return "redirect:insertComplete";
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/menu/insertComplete.jsp";
	}
	
	//수정 페이지
	@GetMapping("/change")
	public String change(@RequestParam int menuNo, Model model) {
		MenuDto dto = dao.selectOne(menuNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/menu/change.jsp";
//		if(dto == null) {
//			return "redirect:changeFail";
//		}
//		else {
//			return "/WEB-INF/views/menu/change.jsp";
//		}
	}
	@PostMapping("/change")
	public String change(@ModelAttribute MenuDto dto) {
		if(dao.update(dto)) {
			//return "redirect:chageSuccess";
			return "redirect:detail?menuNo=" + dto.getMenuNo();
		}
		else {
			return "redirect:changeFail";
		}
	}
	
	@RequestMapping("/changeSuccess")
	public String chageSuccess() {
		return "/WEB-INF/views/menu/changeSuccess.jsp";
	}
	@RequestMapping("/changeFail")
	public String chageFail() {
		return "/WEB-INF/views/menu/changeFail.jsp";
	}
	
	//목록 & 검색 페이지
//	@RequestMapping("/list")
//	public String list(@RequestParam(required = false) String column, 
//							@RequestParam(required = false) String keyword,
//							Model model) {
//		boolean isSearch = column != null& keyword != null;
//		List<MenuDto> list = isSearch ? dao.selectList(column, keyword) : dao.selectList();
//		model.addAttribute("isSearch", isSearch);
//		model.addAttribute("list", list);
//		return "/WEB-INF/views/menu/list2.jsp";
//	}
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVO vo,
								Model model) {
		int count = dao.count(vo);
		vo.setCount(count);
		
		List<MenuDto> list = dao.selectListByPaging(vo);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/menu/list3.jsp";
	}
	
	//상세 페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam int menuNo, Model model) {
		MenuDto dto = dao.selectOne(menuNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/menu/detail.jsp";		
	}
	
	//삭제 페이지
	//@RequestMapping("/delete")
	@GetMapping("/delete")
	public String delete(@RequestParam int menuNo) {
		dao.delete(menuNo);
		return "redirect:list";
	}
	
}
