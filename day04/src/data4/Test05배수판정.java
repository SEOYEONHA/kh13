package data4;

public class Test05배수판정 {
	public static void main(String[] args) {
		
		//b를 a로 나머지가 0인 경우 b는 a의 배수라 부른다.
		
		int number = 5;
		
		boolean even = number % 2 == 0;
		System.out.println("짝수? " + even);
		
		//boolean odd = number % 2 == 1;
		boolean odd = number % 2 != 0;
		
		System.out.println("홀수? " + odd);
		System.out.println("홀수? " + !even); //부정연산
		
	}

}
