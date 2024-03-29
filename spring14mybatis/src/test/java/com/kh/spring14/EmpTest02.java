package com.kh.spring14;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dao.EmpDao;
import com.kh.spring14.dto.EmpDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpTest02 {
	
	@Autowired
	private EmpDao empDao;
	
	@Test
	public void test() {
		//목록
		List<EmpDto> list = empDao.selectList();
		log.debug("결과 수 : {}" , list.size());
	}

}
