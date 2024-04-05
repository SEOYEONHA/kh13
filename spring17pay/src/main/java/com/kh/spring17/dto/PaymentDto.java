package com.kh.spring17.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDto {
	private int paymentNo;
	private Date paymentTime;
	private String paymentName;
	private int paymentTotal;
	private int paymentRemain;
	private String memberId;
	private String paymentTid;
}
