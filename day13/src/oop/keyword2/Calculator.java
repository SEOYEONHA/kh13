package oop.keyword2;

//사각형의 넓이를 구해주는 계산기 크래스 = 일회성 계산
public class Calculator {
	//멤버 필드(변수) = 일회성 계산에 필드가 필요할까?
	
	//멤버 필드가 없으므로 일회성 메소드를 사용
	public int rect(int width, int height) {
		return width * height;
	}
}
