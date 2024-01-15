package com.kh.spring05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05.dao.PocketmonDao;
import com.kh.spring05.dto.PocketmonDto;

@RestController
@RequestMapping("/pocketmon") //공용주소
public class PocketmonController {
	
	//(중요) 등록된 것들은 "주세요~" 가 된다 (DI, 의존성 주입)
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//등록 페이지
	//- insert?pocketmonNo=77&pocketmonName=테스트&pcoketmonType=테스트
	@RequestMapping("/insert")
	public String insert(
			@RequestParam int pocketmonNo, 
			@RequestParam String pocketmonName, 
			@RequestParam String pocketmonType) {
		String sql = "insert into pocketmon("
							+ "pocketmon_no, pocketmon_name, pocketmon_type"
							+ ") values(?, ?, ?)";
		Object[] data = {pocketmonNo, pocketmonName, pocketmonType};
		jdbcTemplate.update(sql,data);
			return "포켓몬스터 등록 완료";
	}
	
	//업그레이드
	//- 전달되는 데이터를 낱개가 아닌 객체(DTO)로 저장
	//- (주의) @RequestParam이 아니라 @MondelAttribute 사용
	@RequestMapping("/insert2")
	public String insert2(PocketmonDto dto) {
	//public String insert2(@ModelAttribute PocketmonDto dto){
		String sql = "insert into pocketmon("
				+ "pocketmon_no, pocketmon_name, pocketmon_type"
				+ ") values(?, ?, ?)";
		Object[] data = {dto.getPocketmonNo(), dto.getPocketmonName(), dto.getPocketmonType()};
		jdbcTemplate.update(sql,data);
			return "포켓몬스터 등록 완료";
	}
	
	//업그레이드
	//- DB 처리를 DAO에게 전담하여 처리
	
	@Autowired
	private PocketmonDao dao;
	
	@RequestMapping("/insert3")
	//public String insert3(PocketmonDto dto) {
	public String insert3(@ModelAttribute PocketmonDto dto) {
		dao.insert(dto);
		return "포켓몬스터 등록 완료";
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute PocketmonDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "포켓몬스터 수정 완료";
		}
		else {
			return "존재하지 않는 포켓몬스터 번호";
		}
	}
	
	
}
