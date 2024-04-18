package com.kh.spring19.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring19.dao.PocketmonDao;
import com.kh.spring19.dto.PocketmonDto;

@CrossOrigin //(CORS)때문에
@RestController
@RequestMapping("/pocketmon")
public class PocketmonRestController {
	
	@Autowired
	private PocketmonDao pocketmonDao;
	
	@GetMapping("/") //조회
	public List<PocketmonDto> list (){
		return pocketmonDao.selectList();
	}
//	@PostMapping("/") //등록
//	@PutMapping("/") //전체수정
//	@PatchMapping("/") //일부수정
//	@DeleteMapping("/") //삭제

}
