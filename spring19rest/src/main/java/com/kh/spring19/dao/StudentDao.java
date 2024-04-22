package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.StudentDto;

@Repository
public class StudentDao {
	@Autowired
	private SqlSession sqlSession;

	public List<StudentDto> selectList() {
		return sqlSession.selectList("student.list");
	}

	public StudentDto selectOne(int studentId) {
		return sqlSession.selectOne("student.find", studentId);
	}
	
	public int sequence() {
		return sqlSession.selectOne("student.sequence");
	}
	public void insert(StudentDto studentDto) {
		sqlSession.insert("student.save", studentDto);
	}

	public boolean edit(StudentDto studentDto) {
		return sqlSession.update("student.edit", studentDto) > 0;
	}

	public boolean delete(int studentId) {
		return sqlSession.delete("student.delete", studentId) > 0;
	}
	
}