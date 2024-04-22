package com.kh.spring19.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring19.dto.MenuDto;

@Repository
public class MenuDao {
	@Autowired
	private SqlSession sqlSession;
	
	//메뉴 리스트
	public List<MenuDto> selectList(){
		return sqlSession.selectList("menu.list");
	}
	
	//하나
	public MenuDto selectOne(int menuNo) {
		return sqlSession.selectOne("menu.find", menuNo);
	}
	
	//메뉴 시퀀스
	public int sequence() {
		return sqlSession.selectOne("menu.sequence");
	}
	
	//메뉴 등록
	public void insert(MenuDto menuDto) {
		sqlSession.insert("menu.save", menuDto);
	}
	
	//메뉴 수정
	public boolean edit(MenuDto menuDto) {
		return sqlSession.update("menu.edit", menuDto) > 0;
	}
	
	//메뉴 삭제
	public boolean delete(int menuNo) {
		return sqlSession.delete("menu.delete", menuNo) > 0;
	}
	
	
}
