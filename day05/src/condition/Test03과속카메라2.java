package condition;

import java.util.Scanner;

public class Test03과속카메라2 {
	public static void main(String[] args) {
		//KH전자에서 개발한 과속단속 카메라는 다음 규칙에 따라 벌금을 계산하도록 만들어져 있습니다.

		//50km를 초과하여 달리는 차량을 단속
		//벌금은 시작이 30000원
		//제한속도인 50km보다 10km 빨라질 때마다 벌금은 10000원씩 증가

		//자동차 속도를 입력받아 예상되는 벌금을 출력하세요
		//(벌금이 없으면 0원이라고 출력하면 됩니다)
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("자동차 속도를 입력하세요 (km/h) : ");
		int speed = sc.nextInt();
		int limit = 50;
		int penalty = 30000; //기본벌금(원)
		int per = 10; //벌금구간(km)
		int step = 10000; //벌금증가분(원)
		
		//계산
		int add = (speed - limit) / per , addSpeed = speed - limit;
		int addPay = add * step;
		
		int total = penalty + addPay;
		
		boolean over = speed > limit;
		
		System.out.println(add);
		
		//출력
		if(over) {
			System.out.println("제한속도 : " + limit + "km/h 입니다.");
			System.out.println("측정된 속도 : " + speed + "km/h");
			System.out.println("제한속도 보다 " + addSpeed + "km/h 초과하여 벌금이 " + total + "원 부과됩니다.");
		}
		else {
			System.out.println("제한속도 : " + limit + "km/h 입니다.");
			System.out.println("측정된 속도 : " + speed + "km/h");
			System.out.println("제한속도를 준수하여 벌금은 0원 입니다.");
	}
	}

}
