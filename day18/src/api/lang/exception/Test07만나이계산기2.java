package api.lang.exception;

import java.util.Scanner;

public class Test07만나이계산기2 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("출생정보(YYYY-MM) 입력");
			String input = sc.next();

			//[1] 글자수가 맞지 않으면 강제예외 발생
			if(input.length() != 7) {
				throw new Exception("글자수가 맞지 않습니다");
			}

			//연월 추출
			int year = Integer.parseInt(input.substring(0, 4));
			int month = Integer.parseInt(input.substring(5));

			//[4] 월이 1~12가 아니면 예외 처리
			if(month < 1 || month > 12) {
				throw new Exception("월은 1~12로 설정하세요");
			}
			//[5] 연도가 1900 미만이라면 예외 처리
			if(year < 1900) {
				throw new Exception("1900년도부터 입력 가능합니다");
			}
			//[6] 가운데가 -가 아니면 예외 처리
			if(input.charAt(4) != '-') {
				throw new Exception("가운데는 대시(-)만 사용 가능합니다");
			}

			int currentYear = 2023;
			int currentMonth = 12;

			//한국나이 계산
			int koreanAge = currentYear-year+1;

			//만나이 계산
			int current = currentYear * 12 + currentMonth;
			int birth = year * 12 + month;
			int gap = current - birth;//개월수
			int americanAge = gap / 12;//12개월당 1살

			//[3] 미래의 생년월일이라면 (gap이 음수라면) 예외 처리
			if(gap < 0) {
				throw new Exception("미래의 날짜는 설정할 수 없어요");
			}

			//출력
			System.out.println("한국나이 = "+koreanAge+"살");
			System.out.println("만나이 = "+americanAge+"살");
		}
		catch(Exception e) {
			if(e.getMessage() == null) {
				System.err.println("프로그램에서 문제가 발생했습니다");
			}
			else {
				System.err.println("예외 발생 : " + e.getMessage());
			}
		}
	}
}