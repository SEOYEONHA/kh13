package com.kh.spring19.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EmpDto {
	private int empNo;
	private String empName,empDept, empDate;
	private int empSal;
}
