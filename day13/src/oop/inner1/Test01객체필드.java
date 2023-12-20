package oop.inner1;

public class Test01객체필드 {
	public static void main(String[] args) {
		Gun gun = new Gun();
		
		//Police police = new police("폴리", "경위", gun);
		Police police = new Police();
		police.setName("폴리");
		police.setLevel("경위");
		police.setGun(gun);
	}
}
