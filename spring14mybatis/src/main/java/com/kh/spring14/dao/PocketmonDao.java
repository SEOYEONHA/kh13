package com.kh.spring14.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring14.dto.PocketmonDto;

@Repository
public class PocketmonDao {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;//Spring JDBC
	
	@Autowired
	private SqlSession sqlSession;//myBatis
	
	public List<PocketmonDto> selectList() {
		//return pocketmon 영역의 list라는 구문을 실행해서 나온 결과;
		return sqlSession.selectList("pocketmon.list");
	}
	
	public void insert(PocketmonDto pocketmonDto) {
		sqlSession.insert("pocketmon.add", pocketmonDto);
	}
	
	public boolean update(PocketmonDto pocketmonDto) {
		return sqlSession.update("pocketmon.edit", pocketmonDto) > 0;
	}
	
	public boolean delete(int pocketmonNo) {
		return sqlSession.delete("pocketmon.remove", pocketmonNo) > 0;
	}
	
	//상세조회를 구현하는 방법은 두가지
	//1. selectList를 사용해서 목록으로 처리 - 여러개 나와도 에러가 안남(안좋은 방법)
	//2. selectOne을 사용해서 상세조회 처리 - 여러개 나오면 에러발생(좋은 방법)
	public PocketmonDto selectOne(int pocketmonNo) {
		//1
//		List<PocketmonDto> list = sqlSession.selectList("pocketmon.find", pocketmonNo);
//		return list.isEmpty() ? null : list.get(0);
		
		//2
		return sqlSession.selectOne("pocketmon.find", pocketmonNo);
		
	}
}







