package oop.inherit8;

public class Galaxy23FE extends GalaxyPhone{

	public Galaxy23FE(String number, String color) {
		super(number, color);
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시23FE 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시23FE 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시23FE 문자 기능 실행");
	}
	
	public void bixby() {
		System.out.println("갤럭시23FE 음성인식 기능 실행");
	}
}
