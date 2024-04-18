package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.EmpDto;

@Repository
public class EmpDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//조회
	public List<EmpDto> selectList(){
		return sqlSession.selectList("emp.list");
	}
	
	public int sequence() {
		return sqlSession.selectOne("emp.sequence");
	}
	//등록
	public void insert(EmpDto empDto) {
		sqlSession.insert("emp.save", empDto);
	}
	
	//수정
	public boolean editAll(EmpDto empDto) {
		return sqlSession.update("emp.editAll", empDto) > 0;
	}
	
	public boolean editUnit(EmpDto empDto) {
		return sqlSession.update("emp.editUnit", empDto) > 0;
	}
	
	//삭제
	public boolean delete(int empNo) {
		return sqlSession.delete("emp.delete", empNo) > 0;
	}

	//상세조회
	public EmpDto selectOne(int empNo) {
		return sqlSession.selectOne("emp.find", empNo);
	}


}
