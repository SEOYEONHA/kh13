package array4;

import java.util.Random;

public class Test05빙고판만들기 {
    public static void main(String[] args) {
        
        //크기 설정
        int size = 5;
        
        //배열 생성
        int[][] bingo = new int[size][size];
        
        //숫자 배치 - 초기화를 숫자 기준으로 진행
        Random r = new Random();
        for(int i=1; i <= size * size; i++) {//1부터 5x5까지 진행
            int x = r.nextInt(size);//x위치 랜덤 추첨
            int y = r.nextInt(size);//y위치 랜덤 추첨
            
            //해당 칸에 0이 있다는 것은 한 번도 값이 들어간 적이 없는 초기상태라는 의미
            if(bingo[x][y] == 0) {
                bingo[x][y] = i;
            }
            //아니면 재추첨하도록 해야한다
            //재추첨이라는 것은 다시 뽑는 것을 의미하기도 하지만 현재의 반복을 "무효화" 시키는 것을 의미
            else {
                i--;//반복문에 써있는 i++와 상쇄되어 한번 더 반복이 가능하게 한다.
            }
        }
        
        
        //출력 - length 대신 size 사용 가능(정사각형이란 특수한 상황때문)
        for(int i=0; i < size; i++) {
            for(int k=0; k < size; k++) {
                System.out.print(bingo[i][k]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        
    }
}