package data;

public class Test08나눗셈 {
	public static void main(String[] args) {
		int number = 75;
		
		//위 숫자의 10의자리, 1의자리 숫자를 각각 출력
		System.out.println(number / 10);
		System.out.println(number % 10);
		
		//숫자의 100의자리, 10의자리, 1의자리를 각각 출력
		int number2 = 139;
		
		int first = number2 / 10 / 10;
		int second =(number2 / 10 % 10);
		int third = (number2 % 10);
		
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		
	}

}
