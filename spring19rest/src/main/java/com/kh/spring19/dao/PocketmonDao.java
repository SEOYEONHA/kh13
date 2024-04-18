package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.PocketmonDto;

@Repository
public class PocketmonDao {

	@Autowired
	private SqlSession sqlSession;
	
	//조회
	public List<PocketmonDto> selectList(){
		return sqlSession.selectList("pocketmon.list");
	}
}
