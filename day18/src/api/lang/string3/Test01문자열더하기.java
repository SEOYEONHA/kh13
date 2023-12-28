package api.lang.string3;

public class Test01문자열더하기 {
	public static void main(String[] args) {
		//StringBuffer를 이용한 문자열 합산
		
		//String = satr ="";
		StringBuffer buffer = new StringBuffer();
		long begin = System.currentTimeMillis(); //현재 시간을 밀리초(ms)로 반환
		for(int i = 0 ; i <= 100000000 ; i++) {
			//star += "*";
			buffer.append("*");
		}
		long end = System.currentTimeMillis();
		long gap = end - begin;
		//System.out.println("star = " + star);
		System.out.println("gap = " + gap);
	}
}
