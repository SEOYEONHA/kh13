package com.kh.spring19.vo;

import java.sql.Date;

import com.kh.spring19.dto.MemberDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//로그인에 성공한 회원에게 전달할 정보
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MemberLoginVO {
	private String memberId;
	private String memberLevel;
	private String token;
}
