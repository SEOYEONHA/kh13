package oop.constructor1;

public class Student {
	private String name;
	private int score;
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getScore() {
		return score;
	}
	void setScore(int score) {
		this.score = score;
	}
	
	void data(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	void information() {
		System.out.println("이름 : " + this.name);
		System.out.println("점수 : " + this.score);
	}
}
