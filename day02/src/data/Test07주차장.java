package data;

public class Test07주차장 {
	public static void main(String[] args) {
		//Test07주차장
		//KH주차장은 10분당 1500원의 요금을 받고 있습니다.
		//처음 9분까지는 돈을 받지 않고 10분이 되면 1500원, 20분이 되면 3000원으로 요금이 올라갑니다

		//11시 50분에 들어와서 17시 25분에 나간 차량의 요금을 출력
		//(단, 다음날까지 주차는 절대로 불가능합니다)
		
		int Price = 1500;
		int inHour = 11 , inMinute = 50;
		int outHour = 17 , outMinute = 25;
		
		
		int inTIME = inHour*60 + inMinute , outTime = outHour*60 + outMinute;
		int parkTime = outTime - inTIME; 
		//System.out.println(parkTime); //총 주차 시간(분)
		int totalPrice = Price * (parkTime/ 10);


		System.out.println(totalPrice);
		
	}

}
