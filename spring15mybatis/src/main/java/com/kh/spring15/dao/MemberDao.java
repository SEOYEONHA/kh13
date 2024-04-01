package com.kh.spring15.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring15.dto.MemberDto;
import com.kh.spring15.vo.MemberComplexVO;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberDto> selectList(MemberComplexVO vo){
		return sqlSession.selectList("member.complex", vo);
	}
}
