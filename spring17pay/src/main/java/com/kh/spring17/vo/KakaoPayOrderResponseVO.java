package com.kh.spring17.vo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayOrderResponseVO {
	private String tid; //결제 고유번호
	private String cid; //가맹점 코드
	private String status; //결제 상태
	private String partnerOrderId; //가맹점 주문번호
	private String partnerUserId; //가맹점 회원ID
	private String paymentMethodType; //결제수단(CARD/MONEY)
	
	private KakaoPayAmountVO amount; //결제금액
	private KakaoPayAmountVO canceledAmount; //취소된금액
	private KakaoPayAmountVO cancelAvailableAmount; //취소 가능 금액
	
	private String itemName; //상품이름
	private String itemCode; //상품 코드
	private int quantity; //상품수량
	private Date createdAt; //결제 준비 요청 시각
	private Date approvedAt; //결제 승인 시각
	private Date canceledAt; //결제 취소 시각
	private KakaoPaySelectedCardInfoVO selectedCardInfo; //결제카드정보
	private List<KakaoPayPaymentActionDetailVO> paymentActionDetails;
}
