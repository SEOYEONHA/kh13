package api.util.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test02조회수중복방지3 {
	public static void main(String[] args) {

		//정렬이 필요하지 않으므로 HashSet으로 구현
		Set<String> history = new HashSet<>();

		//샘플 데이터 저장
		//history.add("비전공자의 자바 입문기");
		//history.add("자바로 홈페이지 만들기");
		//history.add("개발자의 미래");

		//사용자 입력
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("제목 : ");
			String title = sc.nextLine();

			//if(title == "종료") {//절대로 실행되지 않는 코드
			if(title.equals("종료")) {
				break;
			}

			//판정
			//- Set은 중복이 불가능하므로 add의 결과로도 존재 여부 파악이 가능
			if(history.add(title)) {//추가했을 때 true나오면 본적이 없는 영상
				System.out.println("처음 시청하는 영상입니다");
			}
			else {
				System.out.println("시청한 적 있는 영상입니다");
			}
		}

		sc.close();

		System.out.println("총 시청한 영상 개수 : " + history.size());

	}
}