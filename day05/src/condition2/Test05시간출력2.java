package condition2;

import java.util.Scanner;

public class Test05시간출력2 {

	public static void main(String[] args) {
		//SNS에서는 작성한 글이 몇 초 전에 작성되었는지에 따라 다음과 같이 
		//출력하도록 구성되어 있습니다.
		//사용자가 초를 입력하면 입력된 값에 따라 시간 정보를 출력해보세요
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("초 입력 : ");
		int time = sc.nextInt();
		
		
		//계산+출력
		if(time < 10) { // 10초가 되지 않았다면
			System.out.println("방금 전");
		}
		else if(time < 60) {
			int second = time;
			System.out.println(second + "초 전");
		}
		else if(time < 60 * 60) {
			int minute = time / 60;
			System.out.println(minute + "분 전");
		}
		else if (time < 24 * 60 * 60) {
			int hour = time / 60 / 60;
			System.out.println(hour + "시간 전");
		}
		else {
			int day = time / 60 / 60 / 24;
			System.out.println(day + "일 전");
		}
	}
}
		
		
		
		
		
		