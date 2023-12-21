package oop.inherit5;

public class IcePurifier extends Purifier {
	
	
	public IcePurifier(String company, int price) { //, String type) {
		super(company, price); //, type);
	}
	public void cold () {
		System.out.println("냉수 1잔");
	}
	public void ice() {
		System.out.println("얼음 추출");
	}

}
