package api.lang.string;

import java.util.Scanner;

public class Test05닉네임검사 {
	public static void main(String[] args) {
//		사용자에게 프로그램 내에서 사용할 닉네임을 입력받아 운영 규칙에 어긋나는지 검사 후 출력하세요
//
//		운영규칙
//		닉네임은 2글자 이상 10글자 이하로만 설정 가능합니다
//		닉네임에는 운영자라는 단어를 쓸 수 없습니다
//		(추가) 닉네임 온전한 한글이나 숫자로만 작성 가능합니다
//
//		운영규칙에 어긋나지 않는 닉네임이라면 올바른 닉네임입니다 출력
//		운영규칙에 어긋나는 닉네임이라면 잘못된 닉네임입니다 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임을 입력하세요 : ");
		String nickName = sc.next();
		
		
		boolean permitLength = nickName.length() >= 2 && nickName.length() <= 10;
//		boolean prohibitWord = nickName.contains("운영자");
		boolean prohibitWord = nickName.indexOf("운영자") >= 0;
		
//		올바른 문자열 형식이란? 글자수 == 한글개수 + 숫자개수
		int koreanCount = 0;
		int numberCount = 0;
		for(int i = 0 ; i < nickName.length() ; i ++) { //모든 글자를 반복하며
			char ch = nickName.charAt(i); //현재 위치의 글자를 추출
			if('가' <= ch && ch <= '힣') { //한글이라면
				koreanCount++;
			}
			else if('0' <= ch && ch <= '9') { //숫자라면
				numberCount++;
			}
		}
//		System.out.println("한글 개수 = " + koreanCount);
//		System.out.println("숫자 개수 = " + numberCount);
		
		boolean koreanAndNumOnly = nickName.length() == koreanCount + numberCount;
		boolean pass = permitLength && !prohibitWord && koreanAndNumOnly;
				
		if (pass) {
			System.out.println("올바른 닉네임입니다");
		}
		else {
			System.out.println("한글 또는 숫자 2~10글자로 작성하세요");
		}
	}
}
