package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임2 {
	public static void main(String[] args) {

		//저장소 구현
		List<String> history = new ArrayList<>();

		//제시어 추가
		history.add("자바");

		Scanner sc = new Scanner(System.in);

		while(true) {
			//사용자 입력
			String given = history.get(history.size()-1);//저장소 마지막 단어
			System.out.println("[제시어] " + given);
			System.out.print("입력 : ");
			String input = sc.nextLine();

			//판정 = 처음입력한단어 + 한글2~6글자 + 이어지는단어
			boolean isKoreanWord = input.matches("^[가-힣]{2,6}$");
			boolean isContain = history.contains(input);
			boolean isConnect = given.charAt(given.length()-1) == input.charAt(0);
			boolean isPass = isKoreanWord && !isContain && isConnect;
			if(isPass) {
				//System.out.println("제시어 변경");
				history.add(input);
			}
			else {
				System.out.println("게임 오버!");
				break;
			}
		}

		sc.close();

		System.out.println("<입력한 모든 단어들>");
		for(int i=0; i < history.size(); i++) {
			String word = history.get(i);
			System.out.println(" - " + word);
		}

	}
}
