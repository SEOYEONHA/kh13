package com.kh.spring16;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dao.SecretMemberDao;
import com.kh.spring16.dto.SecretMemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SecretMemberTest01 {
	
	@Autowired
	private SecretMemberDao secretMemberDao;

	@Test
	public void test() {
		//회원가입 테스트
//		SecretMemberDto memberDto = new SecretMemberDto();
//		memberDto.setMemberId("testuser1");
//		memberDto.setMemberPw("Testuser1!");
//		memberDto.setMemberNick("테스트유저1");
		
		SecretMemberDto secretMemberDto = SecretMemberDto.builder()
				.memberId("testuser1")
				.memberPw("Testuser1!")
				.memberNick("테스트유저1")
				.build();
		
		//DAO를 이용한 가입처리
		secretMemberDao.insert(secretMemberDto);
	}
}
