package com.kh.spring16.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SecretMemberDto {
	private String memberId;
	private String memberPw;
	private String memberNick;
}
