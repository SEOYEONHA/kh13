package oop.poly1;

import java.util.Random;

public class Test01다형성의장점 {
	public static void main(String[] args) {
		
		//(Q) 랜덤으로 아이폰14나 15중 하나를 추첨
		Random r = new Random();
		//약속 : 아이폰14(0), 아이폰15(1)
		
		int choice = r.nextInt(2);
		if(choice == 0) {
			//아이폰 14 객체 생성
			IPhone14 phone = new IPhone14();
			phone.call();
			phone.sms();
		}
		else {
			//아이폰 15 객체 생성
			IPhone15 phone = new IPhone15();
			phone.call();
			phone.sms();
		}
		
		//추첨된 휴대폰 객체를 알 ㅜ 없다
	}
}
