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
public class ComplexSearchTest02 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		String column = "member_id";
		String keyword = "test";
		
		//(주의) mybatis는 구문 호출 시 데이터를 한 개만 첨부할 수 있다
		Map<String, Object> data = new HashMap<>();
		data.put("column", column);
		data.put("keyword", keyword);
		
		List<MemberDto> list = sqlSession.selectList("member.search", data);
		for(MemberDto memberDto : list) {
			log.debug("member = {}", memberDto);
		}
	}

}
