package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.StudentDao;
import com.kh.spring07.dto.StudentDto;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentDao dao;
	
	@RequestMapping("/add")
	//http://localhost:8080/student/add?studentName=이현아&studentKoreanScore=80&studentMathScore=90&studentEnglishScore=95
	public String insert(@ModelAttribute StudentDto dto) {
		dao.insert(dto);
		return "학생정보 등록 완료";
	}
	
	@RequestMapping("/list")
	//http://localhost:8080/student/list?column=name&keyword=이
	public String list(
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword
			) {
		boolean isSearch = column != null && keyword != null;
		
		List<StudentDto> list = isSearch ? dao.selectList(column, keyword) : dao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		
		for(StudentDto dto:list) {
//			int studentTotal = dto.getStudentKoreanScore() + dto.getStudentMathScore() + dto.getStudentEnglishScore();
//			float studentAverage = (float)studentTotal / 3;
			
			buffer.append("이름 : ");
			buffer.append(dto.getStudentName());
			buffer.append(" - 국어 : ");
			buffer.append(dto.getStudentKoreanScore());
			buffer.append("점, 수학 : ");
			buffer.append(dto.getStudentMathScore());
			buffer.append("점, 영어 : ");
			buffer.append(dto.getStudentEnglishScore());
			buffer.append("점 / 총점 : " + dto.getStudentTotal() + ", 평균 : " + dto.getStudentAverage() + "<br>");
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	//http://localhost:8080/student/detail?studentId=1
	public String detail(@RequestParam int studentId) {
		StudentDto dto = dao.selectOne(studentId);
		if(dto != null) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("이름 : ");
			buffer.append(dto.getStudentName());
			buffer.append(" - 국어 : ");
			buffer.append(dto.getStudentKoreanScore());
			buffer.append("점, 수학 : ");
			buffer.append(dto.getStudentMathScore());
			buffer.append("점, 영어 : ");
			buffer.append(dto.getStudentEnglishScore());
			buffer.append("점 / 총점 : " + dto.getStudentTotal() + ", 평균 : " + dto.getStudentAverage() + "<br>");
			return buffer.toString();
		}
		else {
			return "존재하지않는 학생 id입니다.";
		}
	}
	
	@RequestMapping("/edit")
	//http://localhost:8080/student/edit?studentName=이현아&studentKoreanScore=75&studentMathScore=80&studentEnglishScore=100&studentId=6
	public String edit(@ModelAttribute StudentDto dto) {
		if(dao.update(dto)) {
			return "학생정보 수정 완료";
		}
		else {
			return "존재하지 않는 학생 id입니다.";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int studentId) {
		if(dao.delete(studentId)) {
			return "학생정보 삭제 완료";
		}
		else {
			return "존재하지 않는 학생 정보입니다.";
		}
	}
}
