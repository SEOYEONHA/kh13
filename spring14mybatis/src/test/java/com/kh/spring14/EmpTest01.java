package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;
import com.kh.spring14.dto.EmpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpTest01 {
	
	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		
		//등록
		EmpDto empDto = new EmpDto();
		empDto.setEmpName("테스트사원1");
		empDto.setEmpDept("테스트부");
		empDto.setEmpDate("2024-03-29");
		empDto.setEmpSal(3000000);
		
		empDao.insert(empDto);
		log.debug("사원 등록 완료");
	}

}
