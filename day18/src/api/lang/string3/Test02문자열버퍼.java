package api.lang.string3;

public class Test02문자열버퍼 {
	public static void main(String[] args) {
		//문자열이 불변이어서 생기는 단점(ex : 별 생성)
		
		String star = "";
		long begin = System.currentTimeMillis(); //현재 시간을 밀리초(ms)로 반환
		for(int i = 0 ; i <= 1000000 ; i++) {
			star += "*";
		}
		long end = System.currentTimeMillis();
		long gap = end - begin;
		//System.out.println("star = " + star);
		System.out.println("gap = " + gap);
	}
}
