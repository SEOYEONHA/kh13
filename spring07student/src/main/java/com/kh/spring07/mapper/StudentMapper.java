package com.kh.spring07.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kh.spring07.dto.StudentDto;

@Service
public class StudentMapper implements RowMapper<StudentDto> {

	@Override
	public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentDto dto = new StudentDto();
		dto.setStudentId(rs.getInt("student_id"));
		dto.setStudentName(rs.getString("name"));
		dto.setStudentKoreanScore(rs.getInt("korean_score"));
		dto.setStudentMathScore(rs.getInt("math_score"));
		dto.setStudentEnglishScore(rs.getInt("english_score"));
		return dto;
	}
	
	
}
