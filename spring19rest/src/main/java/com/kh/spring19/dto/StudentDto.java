package com.kh.spring19.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Tag(name = "학생 정보 객체")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class StudentDto {
	private int studentId;
	private String name;
	private Integer koreanScore, englishScore, mathScore;
}