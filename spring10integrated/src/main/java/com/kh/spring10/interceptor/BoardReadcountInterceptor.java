package com.kh.spring10.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//게시글의 조회수와 관련된 사전 처리를 수행하는 인터셉터
@Service
public class BoardReadcountInterceptor implements HandlerInterceptor{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//인터셉터에서 파라미터를 받고싶다면
		//- request.getParameter("이름")을 사용
		//- 반환형이 String이므로 원하는 형태로 바꿔서 사용
		
		
		//파라미터에서 글 번호 추출
//		long boardNo = Iong.parseInt(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		//1. 비회원은 조회수 증가 방지 처리
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		if(loginId == null) {
			return true;
		}
		
		//2. 작성자 본인인 경우 조회수 증가 방지 처리
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(loginId.equals(boardDto.getBoardWriter())) { //로그인 아이디 = 작성자 아이디
			return true;
		}
		
		//3. 작성자가 탈퇴한 사용자면 조회수 증가 방지 처리
		if(boardDto.getBoardWriter() == null) {
			return true; //탈퇴한 사용자면 누가읽어도 조회수 안늘어남
		}
		
		//4. 한 번이라도 본 적이 있는 글이라면 조회수 증가 방지 처리
		//- 여러 방법 중에 HttpSession을 사용하는 방법으로 구현
		//- 세션에 history라는 이름으로 글 번호를 저장할 저장소를 저장(?)
		//- history=[10. 13. 15] 과 같은 형태로 만들 예정
		//- history에 해당하는 저장소는 HashSet<Integer> 형태로 만든다
		
		
		
		
		//조회수 증가
		boardDao.updateReadcount(boardNo);
		
		return true; //통과
	}
	
	

}
