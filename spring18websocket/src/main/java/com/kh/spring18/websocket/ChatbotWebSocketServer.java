package com.kh.spring18.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring18.dao.ChatbotDao;
import com.kh.spring18.dto.ChatbotDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatbotWebSocketServer extends TextWebSocketHandler{
	
	@Autowired
	private ChatbotDao chatbotDao;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//사용자가 접속하면 모든 질문 목록을 사용자에게 전송
		//(모든 질문 목록 → List<ChatbotDto> → JSON)
		
		//목록 조회
		List<ChatbotDto> list = chatbotDao.selectList();
		
		//목록으로 JSON 문자열 생성(수동)
		ObjectMapper mapper = new ObjectMapper(); //JSON 변환도구
		String json = mapper.writeValueAsString(list);
		
		//메세지 객체 생성
		TextMessage message = new TextMessage(json);
		
		//전송
		//session.sendMessage(질문목록이담긴 메세지객체);
		session.sendMessage(message);
	}
	
}
