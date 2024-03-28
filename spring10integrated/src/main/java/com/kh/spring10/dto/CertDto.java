package com.kh.spring10.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CertDto {
	private String certEmail;
	private String certNumber;
	private Date certTime;
		
}
