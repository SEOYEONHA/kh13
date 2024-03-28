package com.kh.spring10.dto;

import lombok.Data;

@Data
public class ItemDto {
	private int itemNo;
	private String itemName;
	private int itemPrice, itemCharge;
	
}
