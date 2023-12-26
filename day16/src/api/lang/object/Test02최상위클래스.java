package api.lang.object;

import java.util.Random;
import java.util.Scanner;

public class Test02최상위클래스 {
	public static void main(String[] args) {
		//Object 클래스가 최상위 클래스임을 코드로 증명
		//- 이전에 배운 다형성의 원리를 활용
		//- A를 B가 상속받았을 때 B는 A로 업캐스팅이 가능하다
		
		Object a = "hello"; //String → Object(업캐스팅) : 상속관계임을 증명
		Object b = 100; //int → Object(업캐스팅)
		Object c = 3.14; //double → Object(업캐스팅)
		Object d = new Random(); //Random → Object(업캐스팅)
		Object e = new Scanner(System.in); //Scanner → Object(업캐스팅)
		Object f = new int[5]; //(배열)int[] → Object(업캐스팅)
		
		//결론 : Object는 최상이 클래스이며 "아무거나" 보관이 가능하다.
		// → Object보다 더 위에있는 클래스는 없음
		Object g = new Student(); //Student → Object(업캐스팅)
		
		System.out.println(a instanceof String); //a의 데이터가 String 형태인가요?
		System.out.println(b instanceof String); //b의 데이터가 String 형태인가요?
		System.out.println(b instanceof Integer);//b의 데이터가 Integer(int)형태인가요?
	}
}
