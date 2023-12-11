package loop;

public class Test07삼육구2 {
	public static void main(String[] args) {

		//1부터 99사이의 3,6,9가 포함된 숫자 출력

		for(int i=1 ; i <= 99 ; i++) {//1부터 99 사이에서
			int ten = i / 10;//10의자리 추출
			int one = i % 10;//1의자리 추출

			boolean ten369 = ten == 3 || ten == 6 || ten == 9;
			//boolean ten369 == ten % 3 == 0;
			boolean one369 = one == 3 || one == 6 || one == 9;

			if(ten369 && one369) {//3, 6, 9가 포함된 숫자라면 - 박수
				System.out.println("짝짝");//출력
			}
			else if(ten369 || one369) {
				System.out.println("짝");
			}
			else {//박수x
				System.out.println(i);//출력
			}
		}

	}
}