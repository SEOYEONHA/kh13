package api.util.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test03로또추첨기2 {
	public static void main(String[] args) {
//		ArrayList를 만들어 이번 주 예상 로또 번호 6개를 추첨하여 저장한 뒤 출력
//		(단, Random클래스를 사용하고, 중복된 번호는 추첨할 수 없다)
//
//		주의사항
//		Generic type에는 class 형태만 작성할 수 있습니다.
		
		Random r = new Random();
		
		
		
		ArrayList<Integer> lotto = new ArrayList<>();
		
		for(int i = 1 ; i <= 6 ; i++) {
		//while(true) {	
		int lottoNum = r.nextInt(45) + 1;
		//lotto.add(lottoNum);
		if(!lotto.contains(lottoNum)){
			lotto.add(lottoNum);
			}
		else {
			i--;
			}
		}
		System.out.println(lotto);
	}
}
