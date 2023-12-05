package data;

public class Test05편의점 {
	public static void main(String[] args) {
		//편의점에서 삼각김밥을 1+1으로 판매중입니다.
		//아르바이트생은 여러분의 생각만큼 친절하지 않아서
		//5개를 가져간다 한들 한 개 더 가져오면 공짜라는 말을 안합니다

		//삼각김밥 한 개가 1200원이라고 할 때,
		//삼각김밥 7개를 사면 
		//(1) 몇 개가 공짜 처리되는지
		//(2) 다 해서 얼마인지
		//구해서 출력해보세요
		
		//입력 - 김밥가격, 개수
		int gimbapPrice = 1200;
		int gimbapCount = 7;
		
		//계산 - 무료든 유료든 한 쪽 개수
		int freeGimbap = gimbapCount / 2;
		int payGimbap = gimbapCount - freeGimbap;
		int totalGimbap = payGimbap * gimbapPrice;
		
		//(1)
		System.out.println(freeGimbap);
		//(2)
		System.out.println(totalGimbap);
		
		//2+1인 경우
		int freeGimbapNew =  gimbapCount / 3;
		int payGimbapNew = gimbapCount - freeGimbapNew;
		int totalGimbapNew = payGimbapNew * gimbapPrice;
		
		//(1)
		System.out.println(freeGimbapNew);
		//(2)
		System.out.println(totalGimbapNew);
	}

}
