package date4;

public class Test06건강검진 {

	public static void main(String[] args) {
	
		//건강검진은 30세 이상인 사람들을 대상으로 2년에 한 번씩 진행합니다.

		//올해가 짝수 해라면 짝수년도 출생자들이 대상
		//올해가 홀수 해라면 홀수년도 출생자들이 대상

		//어떤 사람의 출생년도(ex : 1985)를 입력값으로 두고 이 사람이 올해 건강검진 대상자인지 판정하여 출력
		
		//입력
		int birth = 1995;
		int currentYear = 2023;
		int age = currentYear - birth + 1;
		
		//계산
		//[1] 30세 이상인가?
		//[2] 올해가 짝수이고 출생년도도 짝수인가?
		//[3] 올해가 홀수이고 출생년도도 홀수인가?
		//- [1][2] 을 만족하거나 [1][3]을 만족하면 건강검진 대상자
		
		boolean thirty = age >= 30;
		boolean even = birth % 2 == 0 && currentYear % 2 == 0;
		//boolean odd = birth % 2 != 0 && curretYear %2 !=0;
		boolean odd = birth % 2 == 1 && currentYear % 2 == 1;
		//boolean health = (thirty && even) || (thirty && odd);
		boolean health = thirty && (even || odd);
		
		//출력
		System.out.println("나이 = " + age + "세");
		System.out.println("30세 이상? " + thirty);
		System.out.println("짝수 대상자? " + even);
		System.out.println("홀수 대상자? " + odd);
		System.out.println("건강검진 대상자? " + health);
		
	}

}
