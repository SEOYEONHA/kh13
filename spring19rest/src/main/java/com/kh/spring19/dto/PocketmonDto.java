package com.kh.spring19.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PocketmonDto {
	private int pocketmonNo;
	private String pocketmonName, pocketmonType;
}
