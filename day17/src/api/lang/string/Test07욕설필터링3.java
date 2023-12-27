package api.lang.string;

import java.util.Scanner;

public class Test07욕설필터링3 {
	public static void main(String[] args) {
//		사용자가 임의의 문자열을 입력했을 때 이 안에 포함된 욕설을 모두 마스킹 처리하세요
//
//		이번에는 사용자가 띄어쓰기가 있는 문자열을 입력해야 합니다.
		
		Scanner sc = new Scanner(System.in);
		
		String[] swearWords = {"수박", "조카", "시베리아", "개나리", "신발끈", "지옥", "주옥", 
				"십장생", "십자수", "게불"};
				
		System.out.print("채팅을 입력하세요 : ");
		String input = sc.nextLine();
		
		for(int i = 0 ; i < swearWords.length ; i++) {
			int size = swearWords[i].length(); //글자수 확인
			
			//합계를 구하는 것 처럼 문자열을 계속 더하여 별을 생성(버전 무관)
			String star = "";
			for(int k = 1 ; k <= size ; k++) {
				star += "*";
				}
			input = input.replace(swearWords[i], star);
			}
		System.out.println(input);
	}
}


