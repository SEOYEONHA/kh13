package com.kh.spring10.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//본인 글은 본인만 수정할 수 있게 구현하려고 함...
@Service
public class BoardInterceptor implements HandlerInterceptor {
	
	@Autowired
	BoardDao boardDao;



	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
						Object handler)
			throws Exception {
		
		BoardDto boardDto = new BoardDto();
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		BoardDto detailDto = boardDao.selectOne(boardDto.getBoardNo());
		
		if(loginId.equals(detailDto.getBoardWriter())) {
			return true;
		}
		
		else {
			response.sendRedirect("/board/list");
			return false;
		}
	}
}
