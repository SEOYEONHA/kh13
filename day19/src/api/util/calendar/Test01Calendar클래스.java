package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test01Calendar클래스 {
	public static void main(String[] args) {
		//Calendar 클래스
		//- 시간 계산 특화 클래스
		//- 추상클래스이므로 직접 객체 생성 불가
		
		//Calendar c = new Calender();
		Calendar c = Calendar.getInstance();
		System.out.println("c = " + c/*.toString() <- 원래 써야하는데 출력할 때는 안써도됨 */);
	
		//Calendar는 Date로 변환이 가능
		Date d = c.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fmt.format(d));
		
	}
}
