package condition3;

import java.util.Scanner;

public class Test02학점계산기 {
	public static void main(String[] args) {
		//KH대학교에서는 다음 기준에 따라 학점을 계산합니다.
		//(시험은 '100'점이 만점입니다)
		
		//- 90점 이상 100점 이하라면 'A+'
		//- 80점 이상 90점 미만이라면 'A'
		//- 70점 이상 80점 미만이라면 'B'
		//- 60점 이상 70점 미만이라면 'C'
		//- 나머지는 'F'
		
		//if 구문이 아닌 switch구문으로 풀어보세요.
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		int newScore = score / 10;
		
		String result;
		switch (newScore) {
		case 9: case 10:
			result = "A+";
			break;
		case 8:
			result = "A";
			break;
		case 7:
			result = "B";
			break;
		case 6:
			result = "C";
			break;
		default:
			result = "F";
			break;
	}
		System.out.println("학점은 " + result + " 입니다.");
	}
}
