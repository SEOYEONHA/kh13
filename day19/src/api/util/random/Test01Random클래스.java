package api.util.random;

import java.util.Random;

public class Test01Random클래스 {
	public static void main(String[] args) {
		Random r1 = new Random();
		Random r2 = new Random(1L);
		
		System.out.println("r1 = " + r1.nextBoolean());
		System.out.println("r2 = " + r2.nextBoolean());
		
		System.out.println("r1 = " + r1.nextInt());
		System.out.println("r2 = " + r2.nextInt());
		
		System.out.println("r1 = " + (r1.nextInt(6) + 1));
		System.out.println("r2 = " + (r2.nextInt(6) + 1));
		
		System.out.println("r1 = " + r1.nextDouble());
		System.out.println("r2 = " + r2.nextDouble());
	}
}
