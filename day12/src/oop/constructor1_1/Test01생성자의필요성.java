package oop.constructor1_1;

public class Test01생성자의필요성 {
	public static void main(String[] args) {
		Student a = new Student("피카츄" , 50);
		
//		a.data("피카츄", 50);
		
		a.information();
		
		Student b = new Student("라이츄");
		
		b.information();
	}
}
