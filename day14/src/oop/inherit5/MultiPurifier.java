package oop.inherit5;

public class MultiPurifier extends Purifier{

	

	public MultiPurifier(String company, int price) { //, String type) {
		super(company, price); //, type);
	}
	
	
	
	
	public void cold() {
		System.out.println("냉수 1잔 추출");
	}
	
	public void hot() {
		System.out.println("온수 1잔 추출");
	}
	
	
	
}
