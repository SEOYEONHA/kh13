package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02날짜변경 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		//시간 변경 - .set()
		//c.set(항목, 값);
		c.set(Calendar.YEAR, 2024); //연도는 4자리로 설정
		c.set(Calendar.MONTH, 0); //월은 0부터 11로 설정
		//c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.DATE, 1);

		//시간 출력
		Date d = c.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fmt.format(d));
		
	}
}
