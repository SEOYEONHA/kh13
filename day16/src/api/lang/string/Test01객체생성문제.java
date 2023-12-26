package api.lang.string;

public class Test01객체생성문제 {
	private static final Object String = null;

	public static void main(String[] args) {
		
	
//	api.lang.string 패키지
//	java.lang 패키지에 있는 StringBuffer 클래스의 문서를 읽고 다음 요구사항에 대한 코드를 작성하세요
//	(Test01객체생성문제)
//
//	객체 생성
//	a라는 이름으로 비어 있는 객체 생성
//	b라는 이름으로 hello라는 글자를 저장한 객체 생성
//	a와 b의 요약 정보를 출력
//	a와 b의 보관중인 글자수를 각각 출력
//	a와 b에 각각 java라는 글자를 추가
//	a와 b의 요약 정보와 보관 중인 글자 수를 다시 출력
	
	//객체 생성
	StringBuffer a = new StringBuffer();
	StringBuffer b = new StringBuffer("hello");
	
	//요약정보 출력
	//	System.out.println("a = " + a.toString());
	//	System.out.println("b = " + b.toString());
	System.out.println("a = " + a); //생략해서 출력 시에도 동일한 효과
	System.out.println("b = " + b); //생략해서 출력 시에도 동일한 효과
	
	
	//글자 수 출력
	System.out.println("a의 글자 수 = " + a.length());
	System.out.println("b의 글자 수 = " + b.length());
	
	//글자 추가
	a.append("java");
	b.append("java");
	
	//요약정보와 글자 수 출력
	System.out.println("a = " + a.toString() + ", " + a.length());
	System.out.println("b = " + b.toString() + ", " + b.length());
	
//	System.out.println("a의 글자 수 = " + a.length());
//	System.out.println("b의 글자 수 = " + b.length());
	}
}
