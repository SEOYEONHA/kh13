package oop.inherit4;

public class IPhone15 extends Phone {

	public IPhone15(String number) {
		super(number);
	}

	@Override
	public void internet() {
		System.out.println("사파리 브라우저 실행");
	}

}
