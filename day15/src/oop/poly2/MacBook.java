package oop.poly2;

public class MacBook extends Laptop {

	@Override
	public void power() {
		System.out.println("맥북 전원을 켭니다.");
	}

	@Override
	public void video() {
		System.out.println("맥북으로 동영상을 재생합니다");
	}

	@Override
	public void typing() {
		System.out.println("맥북 타이핑 기능을 실행합니다");
	}

}
