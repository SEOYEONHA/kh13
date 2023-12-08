package condition2;

public class Test01그룹조건 {
	public static void main(String[] args) {
		//남은 시간(분)에 따라 학원에 어떻게 올 지 결정하는 프로그램
		//- 버스를 타면 2시간이 걸리지만 앉아서 편하게 올 수 있다.
		//- 지하철을 타면 1시간이 걸리지만 매우 불편하게 온다.
		//- 택시를 타면 30분이 걸리지만 돈이 비싸다.
		
		//우선순위
		//(1)버스 (2)지하철 (3)택시 (4)죄송...
		
		int minute = 140;
		
		boolean bus = minute >= 120;
		
		if(bus) {//버스를 탈 수 있다면
			System.out.println("버스를 타고 학원에 갑니다.");
		}
		else {//버스를 탈 수 없다면 - 지하철, 택시, 죄송...
			
			boolean subway = minute >= 60;
			if(subway) {//지하철을 탈 수 있다면
				System.out.println("지하철을 타고 학원에 갑니다.");
			}
			else {//지하철을 탈 수 없다면 - 택시, 죄송...
				
				boolean taxi = minute >= 30;
				if(taxi) {//택시를 탈 수 있다면
					System.out.println("택시를 타고 학원에 갑니다.");
				}
				else {//택시마저 못탄다면
					System.out.println("강사님께 전화합니다");
				}
				
			}
		}
	}

}
