package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03시간형식만들기 {
	public static void main(String[] args) {

//		Date, SimpleDateFormat 클래스를 사용하여 다음 형태의 시간을 만들어 출력해보세요
//
//		2023년 7월 11일
//		오후 1시 5분
//		13:05:30
//		2023-07-11 화 13:05:30
		
		Date d = new Date();
		
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일");
		SimpleDateFormat time1 = new SimpleDateFormat("a h시 m분");
		SimpleDateFormat time2 = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat fmt2  = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
		
		
		System.out.println(fmt.format(d));
		System.out.println(time1.format(d));
		System.out.println(time2.format(d));
		System.out.println(fmt2.format(d));
	}
}
