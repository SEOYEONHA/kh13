package condition2;

public class Test04체질량계산기2 {
	public static void main(String[] args) {

		//입력
		float cm = 180f;
		float kg = 80f;

		//계산
		float m = cm / 100;
		float bmi = kg / (m * m);

		//String status = "저체중" or "정상" or "과체중" or "경도비만" or "중등도비만";
		String status;
		if(bmi < 18.5f) {
			status = "저체중";
		}
		else if(bmi < 23f) {
			status = "정상";
		}
		else if(bmi < 25f) {
			status = "과체중";
		}
		else if(bmi < 30f) {
			status = "경도비만";
		}
		else {
			status = "중등도비만";
		}

		//출력
		System.out.println("BMI 지수 = " + bmi);
		System.out.println("당신의 상태 = " + status);
	}
}

