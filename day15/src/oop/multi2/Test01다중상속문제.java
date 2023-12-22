package oop.multi2;

public class Test01다중상속문제 {
	public static void main(String[] args) {
		Drone d = new Drone();
		d.on();
		d.off();
		d.fly();
		d.move();
		
		System.out.println("--------------------");
		Airplane a = new Airplane();
		a.fly();
		a.move();
		a.reservation();

		System.out.println("--------------------");
		Train t = new Train();
		t.move();
		t.reservation();
		
		System.out.println("--------------------");
		Bus b = new Bus();
		b.move();
		
		System.out.println("--------------------");
		Kickboard k = new Kickboard();
		k.on();
		k.off();
		k.move();
	
	}
}
