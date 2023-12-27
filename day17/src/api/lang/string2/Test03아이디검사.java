package api.lang.string2;

import java.util.Scanner;

public class Test03아이디검사 {
	public static void main(String[] args) {
//		api.lang.string2.Test03아이디검사
//		사용자에게 입력받아 올바른 아이디인지 검사 후 출력
//
//		요구사항
//		맨 앞자리는 영문 소문자 또는 숫자로 작성
//		전체 글자수는 5~20자로 설정
//		나머지 자리는 영문 소문자,숫자,대시,언더바로 구성
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		String regex ="^[a-z0-9][a-z0-9-_]{4,19}$";
		//String regex ="^[a-z0-9][_\\-a-z0-9]{4,19}$"; // 이스케이프 문자 사용가능 
		
		boolean isOkId = id.matches(regex);
		
		if(isOkId) {
			System.out.println("올바른 아이디 형식입니다.");
		}
		else {
			System.out.println("잘못된 아이디 형식입니다.(5~20자의 영문 소문자, "
					+ "숫자와 특수기호(_)(-)만 사용 가능합니다.)");
		}
	}
}
