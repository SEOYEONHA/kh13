package com.kh.spring18.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//클라이언트에게 보내는 메세지
@JsonIgnoreProperties(ignoreUnknown = true)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ChatResponseVO {
	private String Content; //메세지 내용]
	private String time; //전송 시각
	
	//(+추가) 회원 전용 채팅일 경우 작성자와 등급 정보를 추 가
	private String memberId, memberLevel;
}
