package com.kh.spring18.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
 * 웹소켓 접속 및 메세지 전송을 중계하는 서버
 * - 상속을 받아서 자격을 획득 (WebSocketHandler : 부모 / 자식 TextWebSocketHandler : 글자주고받 / BinaryWebSocketHandler : 파일주고받)
 * - @Service 로 등록하여 사용
 * - 필요한 메소드를 재정의하여 사용
 * 		- afterConnectionEstablished : 사용자가 접속했을 때 실행되는 메소드
 * 		- afterConnectionClosed : 사용자가 접속을 종료했을 때 실행되는 메소드
 * 		- handleTextMessage : 사용자가 메세지를 전송했을 때 실행되는 메소드
 */



//public class BasicWebSocketServer implements WebSocketHandler{

@Slf4j
@Service
public class BasicWebSocketServer extends TextWebSocketHandler{
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("사용자가 접속했어요");
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("사용자가 접속 종료했어요");
	}
}
