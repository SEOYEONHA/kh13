package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test09카드게임 {
	public static void main(String[] args) {
		
//		트럼프 카드에서 사용자가 입력한 장수 만큼의 카드를 랜덤으로 섞은 뒤 추첨하는 프로그램을 구현하려고 합니다. 콘솔 환경이기 때문에 그래픽으로 구현하긴 어려우니 글자로 대체해서 보여주려고 합니다.
//		(ex : 하트3, 스페이드A)
//
//		카드는 총 52장이 있습니다.
//		52장은 4종류의 모양으로 구분됩니다(하트/스페이드/클로버/다이아)
//		각각의 모양에는 A,2,3,4,5,6,7,8,9,10,J,Q,K가 존재합니다.
//
//		카드 한 덱(52장)을 생성
//		카드덱을 셔플
//		사용자가 원하는 만큼 출력
//		추가
//		다 구현한 뒤 4명이 포커를 친다고 가정하고 한 사람당 7장씩 카드를 나눠준 뒤 각자가 가진 패를 출력해보세요.
		
		Scanner sc = new Scanner(System.in);
		List<String> trumpCards = new ArrayList<>();
		//List의 데이터 개수가 고정이라면 "불변" 리스트 생성 가능
		//List<String> shapes = Arrays.asList("하트", "다이아", "스페이드", "클로버");
		//List<String> Shapes = List.of("하트", "다이아", "스페이드", "클로버"); //java 9+
		
		//List<String> cardNume = list.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
		String[] cardNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		for(int i = 0 ; i < cardNum.length ; i ++) {
			trumpCards.add("♥" + cardNum[i]);
			trumpCards.add("♠" + cardNum[i]);
			trumpCards.add("♣" + cardNum[i]);
			trumpCards.add("◆" + cardNum[i]);
		}
		
//		Collections.shuffle(trumpCards);
//		System.out.print("원하는 카드 장 수 입력(1~52) : ");
//		int input = sc.nextInt();
//		System.out.println("<랜덤 카드" + input + "장>");
//		if(input >= 1 && input <= 52) {
//			for(int i = 0 ; i < input ; i ++) {
//			System.out.println(trumpCards.get(i));
//			}
//		}
//		else {
//			System.out.println("카드 범위를 1~52까지로 입력해주세요.");
//		}
		
		int distribution = 7;
		System.out.println("각각 나눠줄 카드 수 : " + distribution + "장");
		System.out.println();
		for(int i = 1 ; i <= 4 ; i ++) {
			//System.out.println("-----------------------");
			System.out.println("<user" + i + "보유 카드>");
				for(int k = distribution * (i - 1) ; k < distribution * i ; k ++) {
					System.out.print(trumpCards.get(k));
					if(k < distribution * i - 1) {
						System.out.print(", ");
					}
				}
				System.out.println();
				System.out.println();
		}
		sc.close();
	}
}
