package oop.poly3;

public class Test01캐스팅 {
	public static void main(String[] args) {
		//Hwang의 객체를 만들어 업/다운 캐스팅 구현
	
		//집
		Hwang h1 = new Hwang();
		h1.game();
		h1.drink();
		h1.teach();
		
		System.out.println("----------");
		//출근
		Teacher t = h1; //업캐스팅 (Hwang → Teacher)
		//t.game(); //안보이는 기능
		//t.drink(); //안보이는 기능
		t.teach(); //재정의되어 있어서 연결되어 실행
		
		System.out.println("----------");
		//퇴근
		//Hwang h2 = t; //다운캐스팅(Teacher → Hwang)
		Hwang h2 = (Hwang)t; //다운캐스팅(Teacher → Hwang)
		h2.game();
		h2.drink();
		h2.teach();
		
	}
}
