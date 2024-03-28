package com.kh.spring10.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString뒤에 of 적어서 보고싶은것만 지정할 수 있음 @ToString(of = ...)
@Data
//@Setter @Getter @NoArgsConstructor @ToString
public class PocketmonDto {
	private int pocketmonNo;
	private String pocketmonName;
	private String pocketmonType;
	
}
