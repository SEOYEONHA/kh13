package com.kh.spring15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ComplexSearchTest04 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> data = new HashMap<>();
		data.put("memberId", "test");
		data.put("memberNick", "테스트");
		
		List<MemberDto> list = sqlSession.selectList("member.complex", data);
		for(MemberDto memberDto : list) {
			log.debug("member = {}", memberDto);
		}
	}

}
