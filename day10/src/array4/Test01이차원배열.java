package array4;

public class Test01이차원배열 {
	public static void main(String[] args) {
		//차원이란?
		//- 데이터를 바라보는 관점
		//- (ex) 2개 반에서 학생 3명씩 뽑아서 그 학생의 시험점수 관리
		int [] one = new int[] {55, 66, 77};
		int [] two = new int[] {60, 70, 80};
		
		for(int i = 0 ; i < one.length ; i ++) {
			System.out.println(one[i]);
		}
		for(int i = 0 ; i < two.length ; i ++) {
			System.out.println(two[i]);
		}
		
		System.out.println("--------------");
		
		//2차원이라고 본다면
		int [][] scores = new int[][] {
			{55,66,77},
			{60, 70, 80}
		};
		//for(int k = 0 ; k <= 1; k ++) {
		for(int k = 0 ; k <= scores.length; k ++) {
			for(int i = 0 ; i < scores[k].length ; i ++) {
			System.out.println(scores[k][i]);
			}
		}
	}
}
