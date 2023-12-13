package array;

public class Test04배열계산 {
	public static void main(String[] args) {
//		다음과 같은 학생 성적 정보가 있을 때 이를 배열에 저장하고 계산하여 출력
//
//		90, 67, 75, 88, 52, 59, 90, 92, 61, 72
//
//		불합격자(60점 미만) 점수만 출력
//		성적우수자(90점 이상) 점수만 출력
//		총점과 전체 평균을 출력
//		만약 80점인 학생이 전학을 온다면 예상되는 등수를 출력
		
		int[] scoreList = new int[] {90, 67, 75, 88, 52, 59, 90, 92, 61, 72};
		
		int total = 0;
		
		// [1]불합격자(60점 미만) 점수만 출력
		System.out.print("불합격자(60점 미만) 점수 : ");
		for(int i =0 ; i < scoreList.length ; i++) {
			total += scoreList[i];
		
			if(scoreList[i] < 60) {
				System.out.print(scoreList[i]);
				System.out.print(", ");
			}
		}
		System.out.println();
		
		// [2]성적우수자(90점 이상) 점수만 출력
		System.out.print("성적우수자(90점 이상) 점수 : ");
		for(int i =0 ; i < scoreList.length ; i++) {
			if(scoreList[i] >= 90) {
				System.out.print(scoreList[i]);
				System.out.print(", ");
			}
		}
		System.out.println();
		// [3]총점과 전체 평균을 출력
		System.out.println();
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + (double)total / scoreList.length + "점");
		
		int grade = 1;
		int point = 80;
		
		// [4]만약 80점인 학생이 전학을 온다면 예상되는 등수를 출력
		System.out.println();
		System.out.print("만약 80점인 학생이 전학을 온다면 예상되는 등수 : ");
		for(int i = 0 ; i < scoreList.length ; i++) {
			if(scoreList[i] > point) {
				grade ++;
			}
		}
		System.out.print(grade + "등");
}
}

