package condition2;

public class Test01그룹조건2 {
	public static void main(String[] args) {
		
		//우선순위
		//(1)버스 (2)지하철 (3)택시 (4)죄송...
		
		int minute = 20;
		
		
		if(minute >= 120) {//지하철을 탈 수 있는 상황이라면
			System.out.println("지하철을 타고 학원에 갑니다.");
		}
		else if(minute >= 60) {//버스를 탈 수 있는 상황이라면
			System.out.println("버스를 타고 학원에 갑니다.");
		}
		else if(minute > 30) {//택시를 탈 수 있는 상황이라면
			System.out.println("택시를 타고 학원에 갑니다.");
		}
		else {
			System.out.println("강사에게 전화를 합니다.");
		}
		}
	}

