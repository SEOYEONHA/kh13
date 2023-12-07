package data4;

public class Test04숫자판정2 {
	public static void main(String[] args) {
		//입력
		int number = 71;
		
		//계산
		//- 논리에서는 말이 되는 것이 중요하다
		//- 7이 들어있는 숫자는 무엇인가?
		//- 10의자리가 7 또는 1의 자리가 7
		//- 70부터 79사이 또는 1의 자리가 7
		boolean ten = number / 10 == 7;
		//boolean ten = number >= 70 && number < 80;
		boolean one = number % 10 == 7;
		//boolean seven = ten && one;//둘다 7 (1개)
		boolean seven = ten || one;//둘 중 하나가 7 (19개)
		
		//출력
		System.out.println("7이 들어있나요? " + seven);
		
	}
}