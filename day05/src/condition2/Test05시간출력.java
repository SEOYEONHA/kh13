package condition2;

import java.util.Scanner;

public class Test05시간출력 {

	public static void main(String[] args) {
		//SNS에서는 작성한 글이 몇 초 전에 작성되었는지에 따라 다음과 같이 
		//출력하도록 구성되어 있습니다.
		//사용자가 초를 입력하면 입력된 값에 따라 시간 정보를 출력해보세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("초 입력 : ");
		int sec = sc.nextInt();
		int minute = sec / 60;
		int hour = minute / 60;
		int day = hour / 24;
		
	
		if (sec < 10) {
			System.out.println("방금 전 작성");
		}
		else if (sec < 60) {
			System.out.println(sec + "초 전 작성");
		}
		else if (minute < 60) {
			System.out.println(minute + "분 전 작성");
		}
		else if (hour < 24) {
			System.out.println(hour + "시간 전 작성");
		}
		else {
			System.out.println(day + "일 전 작성");
		}
	}

}
