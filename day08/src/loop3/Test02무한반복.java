package loop3;

import java.util.Random;

public class Test02무한반복 {
	public static void main(String[] args) {
		
		Random r = new Random();
				
		while(true) {
			//System.out.println("무한반복");
			int dice = r.nextInt(6) + 1;
			System.out.println("주사위 = " + dice);
			
			if(dice == 5) { //주사위가 5가 나왔다면
				break; // 그만둬
			}
		}
	}

}
