package api.util.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test02조회수중복방지 {
	public static void main(String[] args) {
//		유튜브에서는 크리에이터에게 조회수를 기반으로 한 수익을 제공합니다.
//		따라서 조회수가 의미 없이 마구잡이로 올라가는 것을 방지하려고 합니다.
//
//		사용자가 보고 싶은 영상 제목을 입력합니다
//		사용자가 입력한 영상 제목을 시청한 기록이 있을 경우 "조회수 증가 없이 영상만 재생합니다"를 출력합니다
//		사용자가 입력한 영상 제목을 시청한 기록이 없을 경우 "조회수 증가 후 영상을 재생합니다"를 출력합니다
//		사용자가 종료라는 글자를 입력하기 전까지 반복합니다
//		사용자가 종료라는 글자를 입력하면 여태까지 시청한 영상 개수를 출력하세요
		
//		제목 : (비전공자의 자바 도전기)
//		시청 기록이 없어 조회수 증가 후 영상을 재생합니다
//		제목 : (비전공자의 자바 도전기2)
//		시청 기록이 없어 조회수 증가 후 영상을 재생합니다
//		제목 : (비전공자의 자바 도전기)
//		이미 시청한 영상이므로 조회수 증가 없이 영상을 재생합니다
//		제목 : (종료)
//		총 2개의 영상을 시청하셨습니다
		
		Scanner sc = new Scanner(System.in);
		//정렬이 필요하지 않으므로 HashSet으로 구현......
		Set<String> videos = new HashSet<>();
		
		while(true) {
			System.out.print("제목 : ");
			String input = sc.nextLine();
			
			if(videos.contains(input)) {
				System.out.println("이미 시청한 영상이므로 조회수 증가 없이 영상을 재생합니다.");
			}
			else if(!videos.contains(input) && !(input.equals("종료"))) {
				System.out.println("시청 기록이 없어 조회수 증가 후 영상을 재생합니다.");
				videos.add(input);
			}
			else if(input.equals("종료")) {
				System.out.println("총 " + videos.size() + "개의 영상을 시청하셨습니다.");
				break;
			}
		}
	}
}
