package oop.poly2;

public class GalaxyBook extends Laptop {

	@Override
	public void power() {
		System.out.println("갤럭시북 전원을 켭니다");
	}

	@Override
	public void video() {
		System.out.println("갤럭시북으로 동영상을 재생합니다");
	}

	@Override
	public void typing() {
		System.out.println("갤럭시북 타이핑 기능을 실행합니다");
	}

}
