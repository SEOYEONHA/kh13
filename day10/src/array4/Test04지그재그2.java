package array4;

public class Test04지그재그2 {
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
		
		
		//데이터 초기화 - 위치 기준
		int number = 1;
		for(int i = 0 ; i < dataset.length ; i ++) { 
			if(i % 2 == 0) {//짝수 위치일 때(정방향)
			for(int k = 0 ; k < dataset[i].length ; k++) {//칸
				dataset[i][k] = number++;
			}
		}
			else {//홀수 위치일 때(역방향)
				for(int k = dataset[i].length - 1 ; k >= 0 ; k--) {//칸
					dataset[i][k] = number++;
				}
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
