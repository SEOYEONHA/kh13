package api.lang.string;

public class Test06문자열편집 {
	public static void main(String[] args) {
		//문자열은 불변(immutable)이다.
		//- 편집 명령을 쓰면 무조건 신규 문자열이 나온다
		
		String word = "Hello Java!";
		String upper = word.toUpperCase();
		System.out.println("대문자 = " + upper);
		System.out.println("소문자 = " + word.toLowerCase());
		
		//자르기 = substring()
		System.out.println("자르기 = " + word.substring(0, 4)); 
		System.out.println("자르기 = " + word.substring(6)); //(숫자하나만 알려주면 시작점부터 끝까지) - 6부터 끝까지
	
		//불필요한 공백제거 - trim(), strip() // strip() 이 더 좋은 명령임
		String url = "                               　　       www.naver.com            　                          ";
		System.out.println("여백제거 = " + url.trim()); //아스키코드만 제거(구식명령) ㄱ + 한자 + 1 -> 제거 불가
		System.out.println("여백제거 = " + url.strip()); //유니코드도 제거(최신명령) ㄱ + 한자 + 1 -> 제거 가능

		//문자열 치환
		String text = "나는 피자가 좋아요";
		System.out.println("치환 = " + text.replace("피자", "자바"));
		
		//문자열 분리 - split()
		String[] parts = text.split(" "); // 문자열이 몇개 나올 지 모르니 배열로 분류
		for(int i = 0 ; i < parts.length ; i++) {
			System.out.println("분리 = " + parts[i]);
		}
	}
}
