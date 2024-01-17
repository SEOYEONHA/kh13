package com.kh.spring07.dto;

public class StudentDto {
	private int studentId;
	private String studentName;
	private int studentKoreanScore;
	private int studentMathScore;
	private int studentEnglishScore;
	public StudentDto() {
		super();
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentKoreanScore() {
		return studentKoreanScore;
	}
	public void setStudentKoreanScore(int studentKoreanScore) {
		this.studentKoreanScore = studentKoreanScore;
	}
	public int getStudentMathScore() {
		return studentMathScore;
	}
	public void setStudentMathScore(int studentMathScore) {
		this.studentMathScore = studentMathScore;
	}
	public int getStudentEnglishScore() {
		return studentEnglishScore;
	}
	public void setStudentEnglishScore(int studentEnglishScore) {
		this.studentEnglishScore = studentEnglishScore;
	}
	public int getStudentTotal() {
		return getStudentKoreanScore() + getStudentMathScore() + getStudentEnglishScore();
	}
	
	public float getStudentAverage() {
		return getStudentTotal() / 3f;
	}
}
