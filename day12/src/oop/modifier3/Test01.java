package oop.modifier3;

public class Test01 {
	public static void main(String[] args) {
		Carrier a = new Carrier();
		Carrier b = new Carrier();
		Carrier c = new Carrier();
		Carrier d = new Carrier();
		
		a.data("갤럭시Fold4", "SK", 1800000, 0);
		b.data("갤럭시Fold4", "KT", 1750000, 24);
		c.data("아이폰15", "LG", 2000000, 30);
		d.data("아이폰15", "SK", 1990000, 0);
		
		a.information();
		b.information();
		c.information();
		d.information();
	}

}
