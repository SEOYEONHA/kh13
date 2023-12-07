package date4;

import java.time.LocalDate;

public class Test02성인인증2 {
	public static void main(String[] args) {
		//사용자의 생년월일 8자리를 변수에 저장한 뒤 이 사람이 성인인지
		//판정하여 출력하도록 구현하는 프로그램을 만드세요.
		
		//- 예시 생년월일 : '20020507'
		
		//성인은 한국나이로 20세 이상힐 경우를 말합니다.
		//(연도만으로 나이를 계산합니다.)
		
		//입력
		int birth = 20040507;
		
		
		//계산
		int birthYear = birth / 10000;
		//System.out.println(birthYear);
		
		LocalDate current = LocalDate.now();
		int year = current.getYear();
		int age = year - birthYear + 1;
		//System.out.println(age);
		
		
		boolean adult = age >= 20;
		
		System.out.println("나이 : " + age);
		System.out.println("성인인가요? : " + adult);
		
		
		
		
	}

}
