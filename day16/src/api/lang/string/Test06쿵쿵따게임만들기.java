package api.lang.string;

import java.util.Random;
import java.util.Scanner;

public class Test06쿵쿵따게임만들기 {
	public static void main(String[] args) {
//		공포의 쿵쿵따 게임 만들기
//
//		요구사항
//		첫 번째 제시어를 바나나로 설정해두고 사용자에게 단어를 입력받아서 쿵쿵따 게임을 진행하세요
//		사용자가 입력한 단어는 제시어와 이어져야 합니다.
//		사용자가 입력한 단어는 반드시 3글자여야 합니다.
//		위 조건을 만족하지 않을 경우 게임오버가 되며 프로그램이 종료됩니다.
//		단어를 정상적으로 입력한 경우 제시어가 입력한 단어로 바뀝니다.
//		위 작업을 반복적으로 진행합니다.
//		아래 예시에서 ( )로 감싸진 부분이 사용자가 입력하는 부분입니다.
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		String game = "! 쿵쿵따!";
		String[] words = {"바나나", "나이프", "프랑스", "제주도", "영등포", "양평동", "지하철", "비행기", "당산역"};
		
		String propose = words[r.nextInt(words.length)];
		
		System.out.println(propose + game);
		
		int gameCount = 0;
		
		while(true) {
			
			StringBuffer problem = new StringBuffer(propose);
			
			System.out.print("글자 입력 : ");
			String word = sc.next();
			StringBuffer user = new StringBuffer(word);
			
			int koreanCount = 0;
				for(int i = 0 ; i < word.length() ; i ++) { 
				char ch = word.charAt(i); 
				if('가' <= ch && ch <= '힣') { 
					koreanCount++;
					}
				}
				
			boolean isOKLength = word.length() == 3; //반드시 3글자
			boolean isOKLast = problem.charAt(2) == user.charAt(0); //제시어의 끝글자와 입력어의 첫글자가 같아야함.
			boolean koreanOnly = koreanCount == word.length(); //한국어만 가능
			
			if(isOKLength && isOKLast && koreanOnly) {
				System.out.println(word + game);
				propose = word;
				gameCount ++;
			}
			else if(!koreanOnly) {
				System.out.println("한글만 입력 가능합니다");
				System.out.println("게임 오버!");
				System.out.println("쿵쿵따 " + gameCount + "번 성공!");
					break;
			}
			else if(!isOKLength) {
				System.out.println("3글자만 입력하셔야해요!");
				System.out.println("게임 오버!");
				System.out.println("쿵쿵따 " + gameCount + "번 성공!");
					break;
			}
			else {
				System.out.println("땡! 게임 오버!");
				System.out.println("쿵쿵따 " + gameCount + "번 성공!");
					break;
			}
		}
	}
}