package com.kh.spring17.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//카카오페이 준비요청을 위한 VO (내가 객체를 만듦)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayReadyRequestVO {
	private String partnerOrderId;
	private String partnerUserId;
	private String itemName;
	private int totalAmount;
}
