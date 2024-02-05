package com.kh.spring10.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring10.dao.AttachDao;
import com.kh.spring10.dto.AttachDto;

@Service
public class AttachService {
	
	@Autowired
	AttachDao attachDao;
	
	// 파일저장 + DB저장
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		int attachNo = attachDao.getSequence(); //시퀀스 생성
		File dir = new File(System.getProperty("user.home"), "khUpload");
		File target = new File(dir, String.valueOf(attachNo));
		attach.transferTo(target); //실물파일 저장
		
		AttachDto attachDto = new AttachDto();
		attachDto.setAttachNo(attachNo);
		attachDto.setAttachName(attach.getOriginalFilename());
		attachDto.setAttachType(attach.getContentType());
		attachDto.setAttachSize(attach.getSize());
		attachDao.insert(attachDto); //DB저장
		
		return attachNo;
	}
	
	// 파일삭제 + DB삭제
	public void remove(int attachNo) {
		//실제 파일 삭제
		File dir = new File(System.getProperty("user.home"), "khUpload");
		File target = new File(dir, String.valueOf(attachNo));
		target.delete();
		attachDao.delete(attachNo); //파일정보 지우고
	}
}
