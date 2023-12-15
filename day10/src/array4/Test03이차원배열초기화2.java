package array4;

public class Test03이차원배열초기화2 {
	public static void main(String[] args) {
		
		//배열 생성
		int row = 5;
		int col = 5;
		int[][] dataset = new int [row/*줄*/][col/*칸*/];
		
		//데이터 초기화
		//- 값 기준
		int x = 0 , y = 0;
		for(int i = 1 ; i <= row * col ; i ++) {
			dataset[x][y] = i;
			y++; //오른쪽으로만 이동
			
			if(y == 5) {//넘어갈 것 같으면
				y = 0;
				x ++;
			}
		}
		
		//배열 출력
		for(int i = 0 ; i < dataset.length ; i ++) {
			for(int k = 0 ; k < dataset[i].length ; k ++) {
				System.out.print(dataset[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
