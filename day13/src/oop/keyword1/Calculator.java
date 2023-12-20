package oop.keyword1;

//사각형의 넓이를 구해주는 계산기 크래스
public class Calculator {
	//멤버 필드(변수)
	private int width;
	private int height;
	
	//멤버 메소드
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getResolution() {
		return this.width * this.height;
	}
	
	//생성자
	public Calculator(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}

}
