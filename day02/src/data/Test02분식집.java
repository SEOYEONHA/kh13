package data;

public class Test02분식집 {

	public static void main(String[] args) {
		//Test02 를 만들어서 다음 금액 계산 결과를 출력

		//떡볶이가 1인분에 3500원, 튀김이 1인분에 2000원일 때
		//떡볶이 4인분과 튀김 2인분을 주문하면 얼마인가요?
		
		//[1] 내가 다 계산하고 결과만 출력
		//System.out.println(18000);
		
		//[2] 컴퓨터에게 식으로 계산을 시켜 결과를 출력
		//System.out.println(14000 + 4000);
		//System.out.println((3500 * 4 + 2000 * 2));
		
		//[3] 각각의 합계와 총 금액을 출력
		//System.out.println(3500 * 4);//떡볶이 합계
		//System.out.println(2000 * 2);//튀김 합계
		//System.out.println((3500 * 4 + 2000 * 2));
		
		//[4] 계산 결과를 "변수"에 저장한 뒤 출력
		//int a = 3500*4;
		//int b = 2000*2;
		//System.out.println(a);
		//System.out.println(b);
		//System.out.println(a + b);
		
		//[5] 모든 수치를 변수로 관리하여 계산 및 출력(최종)
		int ddeokboki = 3500;//떡볶이 가격
		int fried = 2000;//튀김 가격
		int dderbokiCount = 4;//떡볶이 개수
		int friedCount = 2;//튀김 개수
		int ddeokbokiTotal = ddeokboki * dderbokiCount;
		int friedTotal = fried * friedCount;
		int total = ddeokbokiTotal + friedTotal;
		System.out.println(ddeokbokiTotal);
		System.out.println(friedTotal);
		System.out.println(total);
				
	}

}
