package com.kh.spring19;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring19.configuration.JwtProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JwtTest03 {

	@Autowired
	private JwtProperties jwtProperties;
	
	@Test
	public void test() {
		//생성된 토큰 정보
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJLSGFjYWRlbXkiLCJpYXQiOjE3MTM4NjA1NjQsImV4cCI6MTcxMzg4MjE2NCwibG9naW5JZCI6InRlc3R1c2VyMSIsImxvZ2luTGV2ZWwiOiLsmrDsiJjtmozsm5AifQ.tC_wH_P-93-OPCCUq3eAWyUgl8DPhesQIscVXDbBpSwWyqNv8qK5HX7BDD5cpjeQ"; //되는거(발행자 같음)
		//String token = "eyJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJLSOygleuztOq1kOycoeybkCIsImlhdCI6MTcxMzg2MTA5NiwiZXhwIjoxNzEzODgyNjk2LCJsb2dpbklkIjoidGVzdHVzZXIxIiwibG9naW5MZXZlbCI6IuyasOyImO2ajOybkCJ9.7QuN4tIz_YPnfhF4E473OBi6c1KvKRGWbFMXemjrMTFrIloM8z6S0FzSPqN8SeXz"; //안되는거(발행자 다름)
		
		//1. 해석을 위한 key 생성
		String keyStr = jwtProperties.getKeyStr();
		SecretKey key = Keys.hmacShaKeyFor(keyStr.getBytes(StandardCharsets.UTF_8));
		
		//2. 토큰 해석
		Claims claims = (Claims) Jwts.parser() //해석도구(parser) 준비해서
				.verifyWith(key) //열쇠 설정하고
				.requireIssuer(jwtProperties.getIssuer()) //발행자 정보를 확인하도록
				.build() //만든다음
				.parse(token) //토큰 해석하고
				.getPayload(); //내용 가져와!
		
		//3. 정보 출력
		log.debug("loginId = {}", claims.get("loginId"));
		log.debug("loginLevel = {}", claims.get("loginLevel"));
		log.debug("test = {}", claims.get("test"));
	}
}
