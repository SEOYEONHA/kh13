package api.util.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03팔로우 {
	public static void main(String[] args) {
//		다음 요구사항대로 사용자에게 팔로우를 설정 또는 해제할 수 있는 프로그램을 구현
//
//		사용자의 아이디를 입력합니다.
//		사용자의 아이디가 저장소에 없는 경우 "팔로우 설정 완료" 출력
//		사용자의 아이디가 저장소에 있는 경우 "팔로우 삭제 완료" 출력
		// ↑왔다갔다 하는걸 토글(toggle)이라고 함
//		팔로우 설정 또는 삭제에 맞는 저장소 처리를 추가적으로 구현
//		사용자가 종료라는 글자를 입력하면 등록된 팔로우 대상 수를 출력
		
		//Set<String> followings = new TreeSet<>(); //팔로우 목록 출력이 필요할 경우
		Set<String> followings = new HashSet<>(); //팔로우 여부 확인만 할 경우
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			
			if(id.equals("종료")) {
				break;
			}
			
			if(followings.contains(id)) {
				followings.remove(id);
				System.out.println(id + "님을 팔로우 해제하였습니다.");
			}
			
			else /*(!followings.contains(id) && !id.equals("종료"))*/ {
				followings.add(id);
				System.out.println(id + "님을 팔로우 설정하였습니다.");
			}
//			else if(id.equals("종료")) {
//				break;
//			}
		}
		sc.close();
		
		System.out.println("등록된 팔로우 대상 수 : " + followings.size());
	}
}

