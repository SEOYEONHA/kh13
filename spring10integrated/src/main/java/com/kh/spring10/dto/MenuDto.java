package com.kh.spring10.dto;

import lombok.Data;

@Data
public class MenuDto {
	private int menuNo;
	private String menuNameKor;
	private String menuNameEng;
	private String menuType;
	private int menuPrice;

}
