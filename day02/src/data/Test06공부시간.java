package data;

public class Test06공부시간 {

	public static void main(String[] args) {
		//어제 복습한 시간은 총 2시간 45분이고
		//오늘 복습한 시간은 총 3시간 35분입니다.

		//이틀동안 공부한 시간은 총 몇시간 몇분인가요?

		//(Hint : 시간은 계산할 때 가장 작은 단위로 계산해야 편합니다)
		
		//입력
		int yesterdayHour = 2 ,  yesterdayMinute = 45;
		int todayHour = 3 , todayMinute = 35;
		
		//계산
		int totalYesterday = yesterdayHour * 60 + yesterdayMinute;
		int totalToday = todayHour * 60 + todayMinute;
		
		int totalTime = totalYesterday + totalToday;
		//System.out.println(totalTime);
		
		int totalHour = totalTime / 60;
		int totalMinute = totalTime - totalHour * 60;
		//System.out.println(totalTime % 60);
		
		//출력
		System.out.println(totalHour +"시간"+ totalMinute + "분");
		
	}

}
