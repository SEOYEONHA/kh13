package loop;

public class Test03반복변수활용 {
	public static void main(String[] args) {
		//(Q) Hello Java 1 부터 Hello java10 까지 출력하세요
		
		for(int i = 1 ; i <= 10 ; i = i + 1) {
			//for 내에서는 반복에 사용한 변수 i를 쓸 수 있다.
			System.out.println("Hello Java" + i);
	
		}
	}
}
