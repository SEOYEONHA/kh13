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

import com.kh.spring10.dao.EmpDao;
import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dao.MenuDao;
import com.kh.spring10.dao.PocketmonDao;
import com.kh.spring10.dto.MemberDto;
import com.kh.spring10.vo.StatVO;

//관리자가 이용할 수 있는 기능을 제공하는 컨트롤러
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private PocketmonDao pocketmonDao;
	
	@Autowired
	private EmpDao empDao;
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private MemberDao memberDao;
	
	//포켓몬스터 통계
	@RequestMapping("/stat/pocketmon")
	public String statPocketmon(Model model) {
		List<StatVO> list = pocketmonDao.statByType();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/pocketmon.jsp";
	}
	
	//사원 통계
	@RequestMapping("/stat/emp")
	public String statEmp(Model model) {
		List<StatVO> list = empDao.statByDept();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/emp.jsp";
	}
	
	//메뉴 통계
	@RequestMapping("/stat/menu")
	public String statMenu(Model model) {
		List<StatVO> list = menuDao.statByType();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/menu.jsp";
	}
	
	//회원 통계
	@RequestMapping("/stat/member")
	public String statMember(Model model) {
		List<StatVO> list = memberDao.statByLevel();
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/stat/member.jsp";
	}
	
	//회원 검색
	@RequestMapping("/member/search")
	public String memberSearch(@RequestParam(required = false) String column,
											  @RequestParam(required = false) String keyword, 
												Model model) {
		
		List<MemberDto> list = memberDao.selectList(column, keyword);
		model.addAttribute("list", list);
		return "/WEB-INF/views/admin/member/search.jsp";
	}
	
	//회원 상세
	@RequestMapping("/member/detail")
	public String memberDetail(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
	
	//회원정보 수정
	@GetMapping("/member/edit")
	public String memberEdit(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/edit.jsp";
	}
	@PostMapping("/member/edit")
	public String memberEdit(@ModelAttribute MemberDto memberDto) {
		if(memberDao.updateAdmin(memberDto)) {
			return "redirect:detail?memberId=" + memberDto.getMemberId();
		}
		else {
			return "redirect:edit?edit?error";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
