package oop.multi2;

import java.util.Random;

public class Test02다형성적용 {

	public static void main(String[] args) {
		//랜덤으로 비행 물체 1개를 만들어서 날려보세요
		
		Random r = new Random();
		int choice = r.nextInt(2);
		
		Flyable f;
		if (choice == 1) {
			f = new Drone(); //업캐스팅
		}
		else {
			f = new Airplane(); //업캐스팅
		}
		
		f.fly();
		
	}

}
