package api.lang.string2;

import java.util.Scanner;

public class Test07이메일검사 {
	public static void main(String[] args) {
//		사용자에게 입력받은 이메일이 유효한지 검사
//
//		요구사항
//		반드시 @가 한 개 있어야 한다
//		@ 앞부분과 뒷부분에 글자가 있어야 한다
//		@ 앞부분은 아이디와 동일한 형식으로 검사
//		네이버 아이디 검사 코드 참조
//		@ 뒷부분은 기관 주소가 들어온다
//		기관 명칭이 우선 나오고 확장자가 등장한다
//		(ex) 삼성이면 ooooo@samsung.com
//		기관 명칭은 소문자 3글자 ~ 20글자 사이로 설정가능
//		확장자는 다음 중 하나만 가능
//		.co.kr
//		.com
//		.net
//		.org
//		.dev
		
		System.out.print("이메일을 입력하세요. : ");
		Scanner sc = new Scanner(System.in);
		
		String email = sc.nextLine();
		
		int at = email.indexOf("@"); //@위치
		int dot = email.indexOf("."); //.위치
		
		String id = email.substring(0,at); //아이디
		String company = email.substring(at+1, dot); //기관명
		String extension = email.substring(dot); //확장자
		
		String regex = "^[a-z0-9][a-z0-9-_]{4,19}@[a-z]{3,20}\\.(co\\.kr|com|net|org|dev)$";
		String regexId ="^[a-z0-9][a-z0-9-_]{4,19}$";
		String regexCompany = "^[a-z]{3,20}$";
		String regexExtension = "^\\.(co\\.kr|com|net|org|dev)$";
		
		boolean isOkEmail = email.matches(regex);
		boolean isOkId = id.matches(regexId);
		boolean isOkCompany = company.matches(regexCompany);
		boolean isOkExtension = extension.matches(regexExtension);
		
		if(isOkEmail) {
			System.out.println("올바른 이메일 형식입니다.");
		}
		if(!isOkId) {
			System.out.println("잘못된 아이디 형식입니다. (5~20자의 영문 소문자, "
					+ "숫자와 특수기호(_)(-)만 사용 가능합니다)");
		}
		if(!isOkCompany) {
			System.out.println("잘못된 기관명 입니다.");
		}
		if(!isOkExtension) {
			System.out.println("잘못된 확장자 형식입니다.");
		}
		else if(!isOkEmail){
			System.out.println("이메일 형식을 한번 더 확인해주세요.");
		}
	}
}
