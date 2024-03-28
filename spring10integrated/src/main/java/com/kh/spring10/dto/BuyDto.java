package com.kh.spring10.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BuyDto {
	private int buySerial;
	private String memberId;
	private int itemNo;
	private String itemName;
	private Date buyTime;
	private int buyQty;
	private int buyTotal;

}
