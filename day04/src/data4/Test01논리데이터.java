package data4;

public class Test01논리데이터 {
	public static void main(String[] args) {
		//논리
		//- 판정을 위한 데이터
		//- true / false 두 가지만 가질 수 있다. (중간 없음)
		//- 종류도 boolean 하나뿐이다.
		
		boolean a = true;
		boolean b = false;
		//System.out.println(a);
		//System.out.println(b);
		
		//(예) 가진돈이 28000원이고, 피자가 20000원이면 주문이 가능한가?
		int money = 18000;
		int pizza = 20000;
		boolean order = money >= pizza;
		System.out.println("order = " + order);
		
		
		
		
	}

}
