package com.kh.spring18.vo.room;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//서버에서 사용자 1명이 보관해야 하는 정보를 모아둔 클래스

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserVO {
	private String memberId;
	private String memberLevel;
	private WebSocketSession session;
	
	public UserVO(WebSocketSession session) {
		this.session = session;
		Map<String, Object> data = session.getAttributes();
		this.memberId = (String) data.get("loginId");
		this.memberLevel = (String) data.get("loginLevel");
	}
	
	public boolean isMember() {
		return this.memberId != null && this.memberLevel != null;
	}
	
	public void send(TextMessage message) throws IOException {
		session.sendMessage(message);
	}
}
