package com.kh.spring17.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDetailDto {
	private int paymentDetailNo;
	private int paymentDetailProduct;
	private int paymentDetailQty;
	private String paymentDetailName;
	private int paymentDetailPrice;
	private String paymentDetailStatus;
	private int paymentNo;
}
