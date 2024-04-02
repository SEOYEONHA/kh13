package com.kh.spring16.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring16.dto.SecretMemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SecretMemberDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//2. 주세요 - 의존성 주입(DI)
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void insert(SecretMemberDto secretMemberDto) {
		//비밀번호를 암호화하여 재설정하는 코드
		String origin = secretMemberDto.getMemberPw(); //비밀번호 추출
		String result = encoder.encode(origin); //암호화
		secretMemberDto.setMemberPw(result); //비밀번호 재설정
		sqlSession.insert("secretMember.join", secretMemberDto);
	}

}
