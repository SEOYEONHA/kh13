package oop.inherit5;

public class Test01정수기생성 {

	public static void main(String[] args) {
		IcePurifier ice = new IcePurifier("코웨이", 500000);
		ice.normal();
		ice.cold();
		ice.ice();
		
		MultiPurifier multi = new MultiPurifier("SK매직", 650000);
		multi.normal();
		multi.cold();
		multi.hot();
		
		
		HotPurifier hot = new HotPurifier("쿠쿠", 450000);
		hot.normal();
		hot.hot();
		
		
		ice.informaiont();
		multi.informaiont();
		hot.informaiont();
		
	}
}
