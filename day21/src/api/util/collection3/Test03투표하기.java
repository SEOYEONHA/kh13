package api.util.collection3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03투표하기 {
	public static void main(String[] args) {
//		사용자에게 이름을 입력받아 투표를 진행할 수 있도록 프로그램을 만드세요
//
//		사용자에게 반복적으로 이름을 입력받습니다
//		입력받은 이름이 처음 입력된 이름이라면 득표수를 1로 저장합니다
//		입력받은 이름이 이미 입력된 이름이라면 기존 득표수에 1을 더하여 저장합니다
//		투표가 완료되면 현재 투표된 이름의 득표수를 출력합니다
//		이름 입력 시 종료라는 글자가 입력되면 투표 프로그램을 종료하고 모든 값을 출력합니다
//
//		이름 입력 : (피카츄)
//		[피카츄] 현재 1표 획득!
//
//		이름 입력 : (라이츄)
//		[라이츄] 현재 1표 획득!
//
//		이름 입력 : (피카츄)
//		[피카츄] 현재 2표 획득!
//
//		이름 입력 : (피카츄)
//		[피카츄] 현재 3표 획득!
//
//		이름 입력 : (라이츄)
//		[라이츄] 현재 2표 획득!
//
//		이름 입력 : (종료)
//
//		프로그램을 종료합니다.
//
//		{피카츄=3, 라이츄=2}
		Scanner sc = new Scanner(System.in);
		
		//저장소 생성
		Map<String, Integer> datalist = new HashMap<>();
		
		
		while(true) {
			System.out.print("투표할 이름 입력 : ");
			String name = sc.nextLine();
		
			Integer score = datalist.get(name);
		
			if(name.equals("종료")) {
				break;
			}
			if(!datalist.containsKey(name) && score == null) {
				datalist.put(name,1);
				System.out.println("[" + name + "] 현재 1표 획득!");
			}
			else {
				datalist.put(name,score + 1);
				System.out.println("[" + name + "] 현재 " + (score + 1) + "표 획득!");
			}
		}
		sc.close();
		System.out.println("<투표 결과>");
		 for (Map.Entry<String, Integer> entry : datalist.entrySet()) {
	            String key = entry.getKey();
	            Integer value = entry.getValue();
	            System.out.println("이름 : " + key + " - 득표 수 : " + value);
	        }
//		System.out.println(datalist);
	}
}
