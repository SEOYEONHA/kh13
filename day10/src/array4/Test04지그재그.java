package array4;

public class Test04지그재그 {
	public static void main(String[] args) {
//		5x5 배열을 만들고 숫자를 다음과 같이 지그재그로 배치하고 출력하세요
//
//		1    2    3    4    5
//		10    9    8    7    6
//		11    12    13    14    15
//		20    19    18    17    16
//		21    22    23    24    25
		
		//배열생성
		int row = 5;
		int col = 5;
		int[][] dataset = new int [row][col];
		
		
		int x = 0 , y = 0;
		for(int i = 1 ; i <= row * col ; i ++) {
			dataset[x][y] = i;
			y++; 
			if(y == 5) {
				y --;
				x += 1;
				}
			if(y == 0) {
				x += 1;
				y ++;
			}
			if((x < 0 && y < 0) || (x > row && y > col)) {
				break;
			}
		}
		
		
		//배열출력
		for(int i = 0 ; i < dataset.length ; i ++) {
			for(int k = 0 ; k < dataset[i].length ; k ++) {
				System.out.print(dataset[i][k]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

}
