package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	
	
	//회원가입
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto dto) {
		memberDao.insert(dto);
		return "redirect:joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
	//테스트 로그인 & 로그아웃
	//- HttpSession을 사용하고 싶다면 매개변수에 선언만 하면 된다
	//- 등록 : session.setAttribute("key", value)
	//- 확인 : session.getAttribute("key")
	//- 삭제 : session.removeAttribute("key")
	@RequestMapping("/testLogin")
	public String testLogin(HttpSession session) {
		//아이디만 있으면 모든 정보를 불러올 수 있으므로 아이디를 저장
		session.setAttribute("loginId", "johndoe123");
		return "redirect:/";
	}
	@RequestMapping("/testLogout")
	public String testLogout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	//실제 로그인
	//- 아이디와 비밀번호 검사를 통과해야하만 세션에 데이터를 추가한다
	//- 사용자가 입력한 아이디를 추가한다
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto inputDto, 
														HttpSession session) {
		MemberDto findDto = memberDao.selectOne(inputDto.getMemberId()); 
		//로그인 가능 여부를 판정
		boolean isValid = findDto != null && inputDto.getMemberPw().equals(findDto.getMemberPw());
		//결과에 따라 다른 처리
		if(isValid) {
			//세션에 따라 데이터 추가
			session.setAttribute("loginId", findDto.getMemberId());
		
			return "redirect:/";
		}
		else {//로그인 실패
			return "redirect:login?error";
		}
	}
	
	//실제 로그아웃
	//- 로그인 때 검사를 했으므로 추가 검사는 불필요
	//- 로그인 때 저장한 세션의 데이터만 삭제 처리
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	
	
//	@PostMapping("/login")
//	public String login(Model model,
//							@ModelAttribute MemberDto dto,
//							@RequestParam String memberId,
//							@RequestParam String memberPw) {
//		boolean pass = memberId.equals(dto.getMemberId()) && memberPw.equals(dto.getMemberPw());
//		model.addAttribute("dto", dto);
//		model.addAttribute("pass", pass);
//		if(pass) {
//			return "/WEB-INF/views/home";
//		}
//		else {
//			return "/WEB-INF/views/member/login.jsp";
//		}
//	}
	
	
			
}
