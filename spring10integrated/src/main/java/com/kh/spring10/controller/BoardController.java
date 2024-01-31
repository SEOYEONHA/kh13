package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.BoardDto;
import com.kh.spring10.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	
	//게시글 등록
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		//세션에서 로그인한 사용자의 ID 추출
		String loginId = (String)session.getAttribute("loginId");
		
		//아이디를 게시글 정보에 포함시킨다
		boardDto.setBoardWriter(loginId);
		
		int sequence = boardDao.getSequence(); //DB에서 시퀀스 번호를 추출
		//int sequence = boardDao.redirectDetail(); //원래 내코드
		boardDto.setBoardNo(sequence);//게시글 정보에 추출한 번호를 포함시킨다
		boardDao.insert(boardDto);//등록
		
		return "redirect:detail?boardNo=" + sequence;
	}
	
	//게시글 상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo, Model model,
									@ModelAttribute BoardDto boardDto /*, HttpSession session*/) {
		//String loginId = (String)session.getAttribute("loginId");
		
		//boardDao.updateReadcount(boardNo);
		BoardDto detailDto = boardDao.selectOne(boardNo);
		model.addAttribute("detailDto", detailDto);
		
		//조회한 게시글 정보에 있는 회원 아이디로 작성자 정보를 불러와서 첨부
		if(detailDto.getBoardWriter() != null) { //작성자가 탈퇴하지 않았다면
			MemberDto memberDto = memberDao.selectOne(detailDto.getBoardWriter());
			model.addAttribute("memberDto", memberDto);
		}
		
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	//게시글 목록
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column,
							@RequestParam(required = false) String keyword, 
							@RequestParam(required = false, defaultValue = "1") int page, 
							@RequestParam(required = false, defaultValue = "10") int size, 
							Model model) {
		boolean isSearch = column != null && keyword != null;
		List<BoardDto> boardList = isSearch ? boardDao.selectList(column, keyword) : boardDao.selectListByPaging(page, size);
		
		model.addAttribute("isSearch", isSearch);
		model.addAttribute("boardList", boardList);
		return "/WEB-INF/views/board/list.jsp";
	}
	
	
	
	//게시글 수정
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		if(boardDao.editBoard(boardDto)){
			return "redirect:detail?boardNo=" + boardDto.getBoardNo();
		}
		else {
			return "redirect:edit?error";
		}
	}
	
	//게시물 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
		//return "redirect:/board/list";//절대경로
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
