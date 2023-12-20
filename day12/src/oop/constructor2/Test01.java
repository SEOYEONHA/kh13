package oop.constructor2;

public class Test01 {
	public static void main(String[] args) {
		Music m1 = new Music("Perfect Night", "르세라핌", 104250, 91835);
		Music m2 = new Music("첫 눈", "EXO", 83127, 90805);
		Music m3 = new Music("Drama", "aespa", 64590, 174519);
		Music m4 = new Music("To.X", "태연", 58826, 70313);
		
		System.out.println("<음원차트>");
		m1.information();
		m2.information();
		m3.information();
		m4.information();
	}
}