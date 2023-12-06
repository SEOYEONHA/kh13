package data2;

public class Test02비만계산기 {
	public static void main(String[] args) {
		//BMI(체질량지수) 계산 공식은 다음과 같습니다.
		//키가 180cm, 몸무게가 80kg인 사람의 BMI 지수를 구하여 출력하세요
		
		//입력
		double cm = 180;
		double weight = 80.0;
		
		//계산
		double m = cm / 100;
		double bmi = weight / (m * m);
		
		//출력
		System.out.println(bmi);
	}

}
