package oop.inherit2;

public class Test01상속이있는경우 {
	public static void main(String[] args) {
		//각각의 휴대폰을 하나씩 생성해서 사용 가능한 모든 메소드 호출
		GalaxyFold5 p1 = new GalaxyFold5();
		p1.call();
		p1.sms();
		p1.bixby();
		
		IPhone15 p2 = new IPhone15();
		p2.call();
		p2.sms();
		p2.siri();
	}

}
