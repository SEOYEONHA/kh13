package com.kh.spring18.websocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.kh.spring18.dao.MessageDao;
import com.kh.spring18.vo.room.RoomVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 회원 전용 채팅 서비스
 * - 비회원은 채팅을 보는 것만 가능함
 * - 회원은 채팅을 작성하고 보는 것 모두 가능함
 */

@Slf4j
@Service
public class MemberWebSocketServer2 extends TextWebSocketHandler{
	
	//사용자의 정보를 저장할 저장소 생성
	private Map<String, RoomVO> channel = Collections.synchronizedMap(new HashMap<>());
	
	@Autowired
	private MessageDao messageDao;
	
}
