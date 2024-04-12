package com.kh.spring18.websocket;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring18.vo.ChatRequestVO;
import com.kh.spring18.vo.ChatResponseVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 클라이언트와 JSON형태의 데이터를 주고받도록 처리
 * - 사용자가 보낸 메세지에 시간과 같은 정보를 추가하여 회신하도록 구현
 */

@Slf4j
@Service
public class JsonWebSocketServer extends TextWebSocketHandler{
	
	//사용자의 정보를 저장할 저장소 생성
	//private Set<WebSocketSession> users = new HashSet<>(); //동기화 안됨(자물쇠 없음)
	//private Set<WebSocketSession> users = Collections.synchronizedSet(new HashSet<>()); //자물쇠 추가
	private Set<WebSocketSession> users = new CopyOnWriteArraySet<>();//동기화 됨(자물쇠 있음)
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.add(session);
		log.debug("사용자 접속, 현재 사용자{}명", users.size());
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
		log.debug("사용자 종료, 현재 사용자{}명", users.size());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//서버와 클라이언트간의 메세지 규약을 만들어보자
		//- 클라이언트 → 서버 : ChatRequestVO
		//- 서버 → 클라이언트 : ChatResponseVO
		
		//[1] 사용자가 보낸 메세지를 ChatRequestVO로 해석
		ObjectMapper mapper = new ObjectMapper();
		ChatRequestVO requestVO = mapper.readValue(message.getPayload(), ChatRequestVO.class);
		
		//[2] 사용자에게 보낼 메세지를 ChatResponseVO로 생성
		ChatResponseVO responseVO = ChatResponseVO.builder()
													.Content(requestVO.getContent())//내용은 그대로 복사
													.time(LocalDateTime.now().toString()) //시간 추가
												.build();
		
		//[3] 메세지 객체 생성
		String json = mapper.writeValueAsString(responseVO);
		TextMessage response = new TextMessage(json);
		
		//전체에게 메세지를 전송(broadcast)
		for(WebSocketSession user : users) {
			user.sendMessage(response);
		}
	}
}
