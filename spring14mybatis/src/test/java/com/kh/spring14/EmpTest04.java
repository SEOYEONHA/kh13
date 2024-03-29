package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;
import com.kh.spring14.dto.EmpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpTest04 {

	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		//수정
		EmpDto empDto = new EmpDto();
		empDto.setEmpNo(41);
		empDto.setEmpName("테스트사원");
		empDto.setEmpDept("테스트부");
		empDto.setEmpDate("2024-03-29");
		empDto.setEmpSal(3500000);
		
		if(empDao.update(empDto)) {
			log.debug("사원 정보 변경 성공");
		}
		else {
			log.debug("존재하지 않는 대상");
		}
	}
}
