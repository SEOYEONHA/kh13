package api.lang.string;

public class Test04문자열검사 {
	public static void main(String[] args) {
		String url = "http://www.naver.com";
		
		//홈페이지 주소인가? (http로 시작하는가)
		System.out.println("http로 시작? " + url.startsWith("http"));
		System.out.println("https로 시작? " + url.startsWith("https"));
		
		//회사 주소인가? (.com으로 끝나는가)
		System.out.println(".com으로 종료? " + url.endsWith(".com"));
		
		//네이버 주소인가? (naver가 들어있는가)
		System.out.println("naver 포함? " + url.contains("naver"));
		
		//네이버가 어디있어요?
		System.out.println("naver 위치 = " + url.indexOf("naver"));
		System.out.println("kakao 위치 = " + url.indexOf("kakao"));
		
		//글자 수
		System.out.println("글자 수 = " + url.length());
		
		//특정 위치의 글자를 추출
		System.out.println("+11 위치의 글자 = " + url.charAt(11));
	}
}
