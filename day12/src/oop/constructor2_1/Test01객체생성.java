package oop.constructor2_1;

public class Test01객체생성 {
	public static void main(String[] args) {
		Song a = new Song("Perfect Night", "르세라핌", 104250, 91835);
		Song b = new Song("첫 눈", "EXO", 83127, 90805);
		Song c = new Song("Drama", "aespa", 64590, 174519);
		Song d = new Song("To.X", "태연", 58826, 70313);
		
		a.information();
		b.information();
		c.information();
		d.information();
	}
}