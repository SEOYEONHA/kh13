package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test03주말추첨 {
	public static void main(String[] args) {
		/*2024년의 주말(토,일) 중에서 무작위로 하루를 추첨해서 날짜 정보를 다음 형식으로 화면에 출력
		 2024년 6월 8일 토요일 
		 */
		Random r = new Random();
		Calendar c = Calendar.getInstance();
		
		int randomMonth = r.nextInt(11);
		int randomDay = r.nextInt(31) + 1;
		
		c.set(Calendar.YEAR, 2024); 
		c.set(Calendar.MONTH, randomMonth); 
		c.set(Calendar.DATE, randomDay);
		
		Date d = c.getTime();
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd EEEE");
		
		boolean weekend = fmt.format(d).contains("토요일") || fmt.format(d).contains("일요일");
		
		while(true) {
			if (weekend) break;
		}
		System.out.println(fmt.format(d));
	}
}
