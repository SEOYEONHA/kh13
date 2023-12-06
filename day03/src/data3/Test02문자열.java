package data3;

public class Test02문자열 {

	public static void main(String[] args) {
		//문자열
		//- 문자를 여러 개 모아서 사용하는 형태
		//- 자바에서는 String 형ㄱ태로 쌍타옴표 사용하여 처리
		
		String a = "Hello Java!";
		System.out.println(a);
		
		//- 구조상 출력이 어려운 경우 이스케이프문자(\)로 출력
		//- 이 문자는 혼자가 아닌 뒤에 글자와 합쳐져 출력된다
		String b = "나는 지금 \"피자\" 가 먹고 싶어요";
		System.out.println(b);
		
		//String c = "번호		이름		속성";
		String c = "번호\t\t이름\t\t속성";
		System.out.println(c);
		
		String d ="안\n녕\n하\n세\n요";
		System.out.println(d);
		
		// 가격 : \10000원
		String e = "가격 : \\10000원";
		System.out.println(e);
		
		// (특징) 덧셈은 가능하다 (연결해준다)
		System.out.println("e=" + e);
		
	}

}
