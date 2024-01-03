package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08사다리게임 {
	public static void main(String[] args) {
//		네이버에서 사다리게임을 검색하여 나오는 프로그램을 인원수를 3명으로 고정 하고 푸세요
//		(단, 애니메이션 부분은 제외합니다)
//
//		다 푸신 분들은 인원수를 실제 프로그램과 동일하게 구현해보세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수를 입력하세요. : ");
		int totalNum = sc.nextInt();
		sc.nextLine();
		
		List<String> members = new ArrayList<>();
		List<String> draw = new ArrayList<>();
		
		System.out.println("이름 " + totalNum +"개를 입력하세요.");
		for(int i = 0 ; i < totalNum ; i++) {
			System.out.print((i + 1) + " : ");
			//String name = sc.nextLine();
			//members.add(name);
			members.add(sc.nextLine());
		}
		
		System.out.println("추첨 항목 " + totalNum + "개를 입력하세요.");
		for(int i = 0 ; i < totalNum ; i++) {
			System.out.print((i + 1) + " : ");
			//String name2 = sc.nextLine();
			//draw.add(name2);
			draw.add(sc.nextLine());
		}
		sc.close();
		
		Collections.shuffle(members);
		Collections.shuffle(draw);
		
		//System.out.println(members);
		//System.out.println(draw);
		
		System.out.println("<추첨 결과>");
		for(int i = 0 ; i < totalNum ; i++) {
			System.out.println((i + 1) + ". ★" + members.get(i) + " → " + draw.get(i) + "★");
		}
	}
}
