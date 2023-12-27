package api.lang.string2;

import java.util.Scanner;

public class Test02이름검사 {
	public static void main(String[] args) {
//		사용자에게 한국이름을 입력받아 올바른 이름인지 검사 후 출력
//
//		요구사항
//		완성된 한글 글자만 사용 가능
//		성은 1글자 또는 2글자
//		이름은 1글자에서 5글자 사이
		
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		//regex는 regular expression(정규 표현식)의 줄임 표현이다
		String regex = "^[가-힣]{1,2}[가-힣]{1,5}$"; //강사님은 이거 권장하심
		//String regex = "^[가-힣]{2,7}$";
		
		//참고 낱자까지 모두 검사하고 싶다면 ^[ㄱ-ㅎㅏ-ㅣ가-힣]{2,7}$
		
//		int koreanCount = 0;
//		for(int i = 0 ; i < name.length() ; i ++) { 
//		char ch = name.charAt(i); 
//		if('가' <= ch && ch <= '힣') { 
//			koreanCount++;
//			}
//		}
//		boolean koreanOnly = koreanCount == name.length();
		boolean isOKNameLength = name.matches(regex);
		
		//if (koreanOnly&& isOKNameLength) {
		if (isOKNameLength) {
			System.out.println("올바른 이름형식입니다.");
		}
		else {
			System.out.println("잘못된 형식의 이름입니다.");
		}
	}
}
