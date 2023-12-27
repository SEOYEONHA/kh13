package api.lang.string2;

public class Test06비밀번호검사 {
	public static void main(String[] args) {
		//(Q) 정규표현식으로 반드시 한 개 이상 보함이라는 것을 검사할 수 있는가?
		//(ex) 비밀번호 - 대문자/소문자/숫자/특수문자 반드시 1개이상 포함
		
		String password = "STudent1234!";
		
		//String regex = "^[A-Za-z0-9!@#$%]{8,16}$"; //'반드시 포함' 미구현
		//String regex = "^(?=(.*?)[A-Z]+)[A-Za-z0-9!@#$%]{8,16}$"; //대문자 반드시 포함
		String regex = "^(?=(.*?)[A-Z]+)(?=(.*?)[a-z]+)(?=(.*?)[0-9]+)(?=(.*?)[!@#$]+)[A-Za-z0-9!@#$]{8,16}$"; //대문자, 소문자, 숫자, 특수문자(!@#$) 반드시 포함
		
		System.out.println(password.matches(regex));
	}
}
