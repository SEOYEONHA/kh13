package com.kh.spring07.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring07.dto.StudentDto;
import com.kh.spring07.mapper.StudentMapper;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StudentMapper mapper;
	
	public void insert(StudentDto dto) {
		String sql = "insert into student("
							+ "student_id, name, korean_score, math_score, "
							+ "english_score) values("
							+ "student_seq.nextval, ?, ? ,?, ?)";
		Object[] data = {dto.getStudentName(), dto.getStudentKoreanScore(), 
				dto.getStudentMathScore(), dto.getStudentEnglishScore()
		};
		jdbcTemplate.update(sql, data);
	}
}
