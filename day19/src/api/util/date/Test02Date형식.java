package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02Date형식 {
	public static void main(String[] args) {
		//Date를 이용해 구한 현재시각을 원하는 형식으로 출력해보자
		//- 자바는 형식을 직접 바꾸는 것이 아니라 ~Format 를래스 형태로 제공
		
		Date d = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(d));
	}
}
