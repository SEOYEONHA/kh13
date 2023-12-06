package data2;

public class Test05PC방계산기 {

	public static void main(String[] args) {
		//KH PC방은 다음과 같이 운영하고 있습니다.

		//요금은 1시간당 1000원
		//분단위로 요금 부과
		//단, 10원단위까지만 돈을 받는다

		//예를 들어서 4분동안 게임을 했다면 66.6666원이 실제 요금이 되지만 60원만 받습니다.
		//고객이 12시 20분부터 15시 30분까지 게임을 했을 때 예상 요금을 구하여 출력하세요.
		
		int price = 1000;
		int startHour = 12 , startMinute = 20;
		int finishHour = 15 , finishMinute = 30;
		
		double pricePerMinute = price / 60.0;
		int startTime = finishHour * 60 + finishMinute; //들어온시간 변환 값
		int finishTime = startHour * 60 + startMinute; //나간시간 변환 값
		int playTime = startTime - finishTime; //이용시간(분)
		
		int hour = playTime / 60;
		int minute = playTime % 60;
		
		int pay = (int)(playTime * pricePerMinute) - ((int)(playTime * pricePerMinute) % 10) ;
		
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(pay);

	}

}
