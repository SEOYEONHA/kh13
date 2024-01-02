package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05편의점게임 {
	public static void main(String[] args) {
		
//		편의점게임은 다음과 같이 진행합니다.
//		사용자에게 편의점에 가면~ 출력
//		사용자가 편의점에 있을법한 물건을 입력
//		한 번이라도 입력한 적이 있는 물건이면 게임오버
//		입력한 적이 없는 물건이면 등록 후 1번부터 진행
//		게임 오버가 되면 여태까지 입력된 물건들을 모두 출력
		
		List<String> store = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("편의점에 가면~ ");
			String item = sc.nextLine();
			if (!store.contains(item)) {
			store.add(item);
			System.out.print(item + "도 있고~! ");
			}
			else {
			//if(store.size() > 1 && store.contains(item)) {
				System.out.println("게임 오버!");
					break;
			}
		}
		sc.close();
		System.out.println("<입력한 물건들>");
		for(int i = 0 ; i < store.size() ; i ++) {
			System.out.println("- " + store.get(i));
		}
	}
}
