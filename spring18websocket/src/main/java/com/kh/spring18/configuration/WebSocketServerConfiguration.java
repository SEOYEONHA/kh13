package com.kh.spring18.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.kh.spring18.websocket.BasicWebSocketServer;
import com.kh.spring18.websocket.ChatbotWebSocketServer;
import com.kh.spring18.websocket.SimpleWebSocketServer;

@EnableWebSocket //웹소켓을 사용할 것임을 표시(활성화설정)
@Configuration //설정파일임을 표시
public class WebSocketServerConfiguration implements WebSocketConfigurer{
	
	@Autowired
	private BasicWebSocketServer basicWebSocketServer;
	
	@Autowired
	private SimpleWebSocketServer simpleWebSocketServer;
	
	@Autowired
	private ChatbotWebSocketServer chatbotWebSocketServer;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//매개변수로 주어진 registry에 웹소켓 서버를 등록
		//- 반드시 웹페이지처럼 주소가 부여되어야 함
		//- (중요) 절대로 다른 주소와 겹치면 안된다
		registry.addHandler(basicWebSocketServer, "/ws/basic")
						.addHandler(simpleWebSocketServer, "/ws/simple")
						.addHandler(chatbotWebSocketServer, "/ws/chatbot");
		//registry.addHandler(simpleWebSocketServer, "ws/simple");
	}
	

}
