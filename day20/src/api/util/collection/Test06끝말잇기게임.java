package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임 {
	public static void main(String[] args) {
//		자바를 최초 제시어로 하는 끝말잇기 게임을 구현
//
//		게임오버 조건은 다음과 같습니다.
//		이전 단어와 이어지지 않는 단어를 입력한 경우
//		한글 2~6글자가 아닌 단어 입력(띄어쓰기 허용하지 않음)
//		한 번이라도 입력한 적이 있는 단어를 또 입력한 경우
		
		System.out.println("<끝말잇기 시작!>");
		
		
		
		List<String> words = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String given = "자바";
		
		while(true) {
			words.add(given);
			System.out.println(given);
			
			System.out.print("단어 입력 : ");
			String input = sc.next();
			//String regex = "^[가-힣]{2,6}$";
			//boolean isOKLength = input.matches(regex);
			
			boolean isOKLength = input.matches("^[가-힣]{2,6}$");
			boolean isOKLast = given.charAt(given.length()-1) == input.charAt(0);
			boolean overlap = words.contains(input);
			
			if(!isOKLength || !isOKLast || overlap) {
				sc.close();
				System.out.println("게임 오버!");
				if(!isOKLength) {
					System.out.println("한글 2~6글자만 입력 가능합니다.(띄어쓰기 불가)");
					}
				if(!isOKLast) {
					System.out.println(given.charAt(given.length()-1) + "(으)로 시작되는 단어를 입력하셔야합니다.");
					}
				if(overlap) {
					System.out.println(input + "은(는) 이전에 입력된 글자입니다.");
					}
				break;
				}
			else {
				given = input;
				}
			}
		System.out.println("<입력한 모든 단어들>");
		for(int i = 0 ; i < words.size() ; i ++) {
			System.out.println("- " + words.get(i));
		}
	}
}
