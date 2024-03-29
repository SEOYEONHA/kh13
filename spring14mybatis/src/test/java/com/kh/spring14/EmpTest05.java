package com.kh.spring14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpTest05 {
	
	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		//삭제
		int empNo = 41;
//		if(empDao.delete(empNo)) {
//			log.debug("사원 삭제 완료");
//		}
//		else {
//			log.debug("존재하지 않는 대상");
//		}
		boolean result = empDao.delete(empNo);
		log.debug("result = {}", result);
	}
	

}
