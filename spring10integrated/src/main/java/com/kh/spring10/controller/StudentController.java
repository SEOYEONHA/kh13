package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.StudentDao;
import com.kh.spring10.dto.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	//학생 등록
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/student/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute StudentDto studentDto) {
		studentDao.insert(studentDto);
		return "redirect:/student/list";
	}
	
	//목록&검색 페이지
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, 
							@RequestParam(required = false) String keyword,
							Model model
							) {
		boolean isSearch = column != null && keyword !=null;
		List<StudentDto> list = isSearch ? studentDao.selectList(column, keyword) : studentDao.selectList();
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("list", list);
		return "/WEB-INF/views/student/list.jsp";
	}
	
	@RequestMapping("/rankList")
	public String rankList(Model model) {
		List<StudentDto> list = studentDao.rankList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/student/rank.jsp";
	}
	
	//상세 페이지
	@RequestMapping("/detail")
	public String detail(@RequestParam int studentId, Model model) {
		StudentDto studentDto = studentDao.selectOne(studentId);
		model.addAttribute("studentDto", studentDto);
		return "/WEB-INF/views/student/detail.jsp";
	}
	
	//수정 페이지
	@GetMapping("/edit")
	public String edit(@RequestParam int studentId, Model model) {
		StudentDto studentDto = studentDao.selectOne(studentId);
		model.addAttribute("studentDto", studentDto);
		return "/WEB-INF/views/student/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute StudentDto studentDto) {
		if(studentDao.updateStudent(studentDto)) {
			return "redirect:detail?studentId=" + studentDto.getStudentId();
		}
		else {
			return "redirect:edit?error";
		}
	}
	
	//삭제페이지
	@GetMapping("/delete")
	public String delete(@RequestParam int studentId) {
		studentDao.delete(studentId);
		return "redirect:list";
	}
}
