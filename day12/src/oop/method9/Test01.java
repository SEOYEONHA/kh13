package oop.method9;

public class Test01 {
	public static void main(String[] args) {
		Bank a = new Bank();
		Bank b = new Bank();
		Bank c = new Bank();
		
		
		a.data("유재석", 2.2, 1, 500000, 2);
		b.data("강호동", 2.5, 1, 500000, 2);
		c.data("신동엽", 2.35, 1.5, 600000, 3);
		
		a.information();
		b.information();
		c.information();
	}

}
