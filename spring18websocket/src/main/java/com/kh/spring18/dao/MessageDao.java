package com.kh.spring18.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring18.dto.MessageDto;

@Repository
public class MessageDao {

	@Autowired
	private SqlSession sqlSession;
	
	//등록된 결과를 바로 반환하는 형태로 insert 구현
	public MessageDto insert(MessageDto messageDto) {
		int sequence = sqlSession.selectOne("message.sequence");
		messageDto.setMessageNo(sequence);
		sqlSession.insert("message.add", messageDto);
		return sqlSession.selectOne("message.find", sequence);
	}
	
	public List<MessageDto> selectList(){
		return sqlSession.selectList("message.list");
	}
	
	public MessageDto selectOne(int messageNo) {
		return sqlSession.selectOne("message.find", messageNo);
	}
}
