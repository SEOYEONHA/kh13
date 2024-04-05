package com.kh.spring17.vo;

import java.sql.Date;

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
public class KakaoPaySelectedCardInfoVO {
	private String cardBin; //카드BIN
	private int installMonth; //할부 개월수
	private String installmentType; //할부 유형(업종무이자/분담무이자)
	private String cardCorpName; //카드사 정보
	private String interestFreeInstall; //무이자할부여부(Y/N)
}
