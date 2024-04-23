package com.kh.spring19;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

//JWT생성
//- 사용자가 로그인을 성공하면 사용자의 주요 정보를 담아서 토큰 생성
//- 사용자가 토큰을 알아볼 수 없도록 하기 위해 서명(sign)을 추가
//- 서명을 위해서는 암호화 알고리즘과 암호화에 사용할 키(key)가 필요
@Slf4j
@SpringBootTest
public class JwtTest01 {
	
	@Test
	public void test() {
		//1. 서명을 위한 키(SecretKey) 생성
		//- HMAC : 메세지의 무결성과 인증을 동시에 처리하기 위해 키를 사용하는 암호화 방식
		//- HMAC-SHA 라는 이름으로 시작함
		String keyStr = "sksmsditjdusgkcnlwlrgkrhtlvrhwkwjsrjehtkrhtlvrhdkanxmsrmfo"; //충분히 길게 작성
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		//2. 토큰의 만료시간 설정
		Calendar c = Calendar.getInstance();
		Date now = c.getTime(); //현재시간 추출
		c.add(Calendar.HOUR, 6); //6시간 후로 이동
		Date expire = c.getTime(); //만료시각 추출
		
		//3.토큰생성
		String token = Jwts.builder()
					.issuer("KH정보교육원") //발행자
					.issuedAt(now) //발행시각
					.expiration(expire) //만료시각
					.signWith(key) //서명
					.claim("loginId", "testuser1") //사용자에게 보낼 내용(key=value)
					.claim("loginLevel", "일반회원") //사용자에게 보낼 내용(key=value)
				.compact();
		
		//4. 결과 확인
		log.debug("token = {}", token);
	}
}
