package com.kh.spring19.service;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring19.configuration.JwtProperties;
import com.kh.spring19.dto.MemberDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	@Autowired
	private JwtProperties jwtProperties; //keyStr, expireHour, issuer
	
	public String create(MemberDto memberDto) {
		//1. 서명을 위한 키(SecretKey) 생성
		//- HMAC : 메세지의 무결성과 인증을 동시에 처리하기 위해 키를 사용하는 암호화 방식
		//- HMAC-SHA 라는 이름으로 시작함
		String keyStr = jwtProperties.getKeyStr();
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		//2. 토큰의 만료시간 설정
		Calendar c = Calendar.getInstance();
		Date now = c.getTime(); //현재시간 추출
		c.add(Calendar.HOUR, jwtProperties.getExpireHour()); //6시간 후로 이동
		Date expire = c.getTime(); //만료시각 추출
		
		//3.토큰생성
		String token = Jwts.builder()
					.issuer(jwtProperties.getIssuer()) //발행자
					.issuedAt(now) //발행시각
					.expiration(expire) //만료시각
					.signWith(key) //서명
					.claim("loginId", memberDto.getMemberId()) //사용자에게 보낼 내용(key=value)
					.claim("loginLevel", memberDto.getMemberLevel()) //사용자에게 보낼 내용(key=value)
				.compact();

		return token;
	}
}
