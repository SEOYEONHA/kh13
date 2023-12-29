package api.util.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기 {
	public static void main(String[] args) {
		/* 사용자에게 문자열로 'YYYY-MM-DD' 형식의 날짜를 입력받습니다. 
		  입력된 날짜를 기준으로한 기념일을 계산하여 출력
		  	- 100일 간격으로 계속
			- 1년 간격으로 계속
			- 100일, 200일, 300일, 1주년, 400일, 500일, 600일, 700일, 2주년
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("기념일을 입력하세요 (YYYY-MM-DD) : ");
		String anniversary = sc.nextLine();
		
		String yearParts = anniversary.substring(0, 4);
		String monthParts = anniversary.substring(5, 7);
		String dayParts = anniversary.substring(8);
		
		int year = Integer.valueOf(yearParts);
		int month = Integer.valueOf(monthParts);
		int day = Integer.valueOf(dayParts);
		
		
		Calendar c = Calendar.getInstance();
//		c.set(Calendar.YEAR, year); 
//		c.set(Calendar.MONTH, month - 1); 
//		c.set(Calendar.DATE, day + 32);
//		
//		Date d = c.getTime();
//		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//		
//		System.out.println(fmt.format(d));
		
		for (int i = 1 ; i <= 730 ; i ++) {
			c.set(Calendar.YEAR, year); 
			c.set(Calendar.MONTH, month - 1); 
			c.set(Calendar.DATE, day + i - 1);
			
			Date d = c.getTime();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			if (i % 100 == 0 ) {
				System.out.println(i+ "일 째 되는날 : " + fmt.format(d));
			}
			else if (i  % 365 == 0) {
				//i = i + 1;
				System.out.println(i / 365 + "주년 : " + fmt.format(d));
			}
			
		}
	}
}
