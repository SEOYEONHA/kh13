package oop.inherit8;

public class GalaxyFold5 extends GalaxyPhone{

	public GalaxyFold5(String number, String color) {
		super(number, color);
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시폴드5 삼성페이 기능 실행");
	}

	@Override
	public void call() {
		System.out.println("갤럭시폴드5 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시폴드5 문자 기능 실행");
	}
	
	public void iris() {
		System.out.println("갤럭시폴드5 홍채인식 기능 실행");
	}

}
