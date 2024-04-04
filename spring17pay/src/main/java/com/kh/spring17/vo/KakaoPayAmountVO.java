package com.kh.spring17.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true) //혹시 없는 항목이 있으면 그냥 넘어가줘..
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //카멜케이스로 바꿔줘..
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class KakaoPayAmountVO {
	private int total; //전체 결제 금액
	private int taxFree; //비과세 금액
	private int vat; //부가세 금액
	private int point; //사용한 포인트 금액
	private int discount; //할인 금액
	private int greenDeposit; //컵 보증금

}
