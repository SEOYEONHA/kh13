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
	
	public SecretMemberDto selectOne(String memberId) {
		return sqlSession.selectOne("secretMember.find", memberId);
	}
	
	public SecretMemberDto selectOneByMemberPw(SecretMemberDto secretMemberDto) {
		
		//사용자가 입력한 아이디로 DB에서 정보를 조회
		SecretMemberDto findDto = sqlSession.selectOne("secretMember.find", secretMemberDto.getMemberId());
		
		//조회 결과가 없다면 아이디가 없는것이므로 중단
		if(findDto == null) return null;
		
		//비밀번호를 "암호화" 고려하여 비교
		boolean isValid = encoder.matches(secretMemberDto.getMemberPw(), findDto.getMemberPw());
		
		//isValid결과에 따라 반환
		return isValid ? findDto : null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
