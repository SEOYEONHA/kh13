package oop.keyword5;

public class Test01파이널키워드 {
	public static void main(String[] args) {
		//final 키워드는 "불변,", "마지막", "금지"의 의미를 가진다
		//- 변수에 final이 붙으면 최초 설정 이후의 변경이 금지된다
		final int a = 10;
		//a = 20;
		//a = 30;
		//a = 40;
		
		System.out.println("a = " + a); 
	}
}
