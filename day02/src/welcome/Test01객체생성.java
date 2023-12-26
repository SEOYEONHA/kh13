package welcome;

import java.util.Scanner;
public class Test01객체생성 {
	public static void main(String[] args) {
		System.out.print("이름을 입력하세요. : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.print("나이를 입력하세요. (1세이상 숫자만 가능합니다.) : ");
		int age = sc.nextInt();
		System.out.println("직업을 입력하세요. : ");
		String job = sc.next();
		Person p = new Person(name , age, job);
		
		p.information();
	}
}
