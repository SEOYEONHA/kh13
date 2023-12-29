package api.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test03출력형식지정 {
	public static void main(String[] args) {
		//Date 클래스는 SimpleDateFormat 클래스를 이용해서 출력형식을 조정
		//Calendar 클래스는 없어서 Date로 변환해서 출력형식을 조정
		//LocalDate 클래스는 신규 도구인 DateTimeFormatter를 사용(같은 형식)
		
		LocalDate current = LocalDate.now();
		System.out.println(current);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("y년 M월 d일 E");
		System.out.println(current.format(fmt));
		
		String str = "2024년 1월 1일 월";
		LocalDate a = LocalDate.parse(str, fmt); //str을 fmt로 해석하겠다
		System.out.println(a);
	}
}
