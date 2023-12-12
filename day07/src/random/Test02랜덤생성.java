package random;

import java.util.Random;

public class Test02랜덤생성 {
	public static void main(String[] args) {
//		다음 제시된 값을 생성해보세요
//
//		로또번호 1개를 추첨한 결과
//		두자리 정수 중 한 개를 추첨한 결과
//		6자리 OTP 번호 한 개를 생성한 결과
//		동전의 앞/뒤 중 하나를 생성한 결과
//		가위/바위/보 중 하나를 생성한 결과
		
		Random r = new Random(); //도구 생성
		
		// 1. 로또
		int lotto = r.nextInt(45) + 1;
		System.out.println("로또 = " + lotto);
		
		// 2. 두 자리 정수
		int two = r.nextInt(99) + 10;
		System.out.println("두자리 정수 = " + two);
		
		// 3. 6자리 OTP번호
		int OTP = r.nextInt(999999) + 100000;
		System.out.println("OTP = " + OTP);
		
		//(주의) Random은 문자열을 만들 수 없다.
		// 4. 동전 앞/뒤
		int coin = r.nextInt(2); // 컴퓨터는 0으로 시작하는것을 좋아함
		if (coin == 0) {
			System.out.println("동전 = 앞");
		}
		else {
			System.out.println("동전 = 뒤");
		}
		
		// 5. 가위/바위/보
		int RPS = r.nextInt(3);
//		if (RPS == 0) {
//			System.out.println("가위/바위/보 = 가위");
//			}
//		if (RPS == 1) {
//			System.out.println("가위/바위/보 = 바위");
//		}
//		else {
//			System.out.println("가위/바위/보 = 보");
//		}
		switch(RPS) {
		case 0:
			System.out.println("가위/바위/보 = 가위");
			break;
		case 1:
			System.out.println("가위/바위/보 = 바위");
			break;
		case 2: //default:
			System.out.println("가위/바위/보 = 보");
		
		}
	}

}
