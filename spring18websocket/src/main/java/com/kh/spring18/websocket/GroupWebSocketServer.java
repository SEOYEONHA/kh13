package com.kh.spring18.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 접속한 사용자를 어떻게 관리할 것인가?
 * - 접속한 모든 사용자에게 메세지를 보내고 싶다면 사용자 정보를 저장
 * - 저장소를 Set<WebSocketSession> 형태로 생성
 */

@Slf4j
@Service
public class GroupWebSocketServer extends TextWebSocketHandler{
	
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
		//사용자가 메세지를 보내면 어떻게 할까?
		//- 사용자가 보낸 메세지를 저장소에 있는 모든 사용자에게 전송
		//- 메세지는 조작을 해도 되고 있는 그대로 전송해도 된다
		
		//전체에게 메세지를 전송(broadcast)
		for(WebSocketSession user : users) {
			user.sendMessage(message);
		}
	}
}
