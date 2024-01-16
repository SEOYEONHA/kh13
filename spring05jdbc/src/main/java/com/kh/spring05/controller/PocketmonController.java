package com.kh.spring05.controller;

import java.util.List;

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
	
	@RequestMapping("/delete")
	//http://localhost:8080/pocketmon/delete?pocketmonNo=74
	public String delete(@RequestParam int pocketmonNo) {
		if(dao.delete(pocketmonNo)) {
			return "포켓몬스터 삭제 완료";
		}
		else {
			return "존재하지 않는 포켓몬스터 번호입니다.";
		}
		
	}
	
	@RequestMapping("/list")
	public String list() {
		List<PocketmonDto> list = dao.selectList();
		
		//list를 이용하여 화면에 출력할 문자열을 생성
		StringBuffer buffer = new StringBuffer();
		for(PocketmonDto dto:list) {
			buffer.append(dto.getPocketmonNo());
			buffer.append(" - ");
			buffer.append(dto.getPocketmonName());
			buffer.append(", ");
			buffer.append(dto.getPocketmonType());
			//buffer.append("\n"); //일반 텍스트의 엔터
			buffer.append("<br>"); //HTML의 엔터
		}
		return buffer.toString();
	}
	
	//항목 키워드 검색
	@RequestMapping("/list2")
	public String list2(
								@RequestParam String column, 
								@RequestParam String keyword) {
		List<PocketmonDto> list = dao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		for(PocketmonDto dto:list) {
			buffer.append(dto.getPocketmonNo());
			buffer.append(" - ");
			buffer.append(dto.getPocketmonName());
			buffer.append(", ");
			buffer.append(dto.getPocketmonType());
			//buffer.append("\n"); //일반 텍스트의 엔터
			buffer.append("<br>"); //HTML의 엔터
		}
		return buffer.toString();
		
	}
	
	//목록 + 검색(최종)
	//- column, keyword 파라미터 유무에 따라 검색/목록을 결정
	@RequestMapping("/list3")
	//http://localhost:8080/pocketmon/list3?column=pocketmon_name&keyword=%ED%85%8C
	public String list3(
						@RequestParam(required = false) String column,
						@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		List<PocketmonDto> list;
		if(isSearch) {
			list = dao.selectList(column, keyword);
		}
		else {
			list = dao.selectList();
		}
		StringBuffer buffer = new StringBuffer();
		for(PocketmonDto dto:list) {
			buffer.append(dto.getPocketmonNo());
			buffer.append(" - ");
			buffer.append(dto.getPocketmonName());
			buffer.append(", ");
			buffer.append(dto.getPocketmonType());
			//buffer.append("\n"); //일반 텍스트의 엔터
			buffer.append("<br>"); //HTML의 엔터
		}
		return buffer.toString();
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int pocketmonNo) {
		PocketmonDto dto = dao.selectOne(pocketmonNo);
		if(dto != null) {// 검색한 번호가 있는 번호인 경우
			StringBuffer buffer = new StringBuffer();
			buffer.append(dto.getPocketmonName());
			buffer.append(" (");
			buffer.append(dto.getPocketmonType());
			buffer.append(")");
			return buffer.toString();
		}
		else {// 없는 번호인 경우
			return "존재하지 않는 몬스터 번호입니다.";
		}
	}
	
	
	
	
	
	
	
	
}
