package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dao.SecretMemberDao;
import com.kh.spring16.dto.SecretMemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecretMemberTest02 {
	
	@Autowired
	private SecretMemberDao secretMemberDao;
	
	@Test
	public void test() {
		//로그인 테스트
		SecretMemberDto secretMemberDto = SecretMemberDto.builder()
				.memberId("testuser1")
				//.memberPw("Testuser2!") //null로 나옴(실패)
				.memberPw("Testuser1!")//성공
				.build();
		
		//로그인 판정
		SecretMemberDto findDto = secretMemberDao.selectOneByMemberPw(secretMemberDto);
		
		log.debug("findDto = {}", findDto);
		//null이면 로그인 실패한 것!!
	}

}
