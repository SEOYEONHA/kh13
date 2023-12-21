package oop.inherit7;

public class Test01추상클래스 {
	public static void main(String[] args) {
		
		//추상클래스는 객체 생성이 불가능하다.
		//Phone p = new Phone();
		
		IPhone15 p = new IPhone15();
		p.setNumber("010-1212-3434");
		p.call();
		p.sms();
	}
}
