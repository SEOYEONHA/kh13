package api.util.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		//Collection
		//- 데이터를 여러 개(무한대로) 저장하기 위한 저장소, 저장 시스템
		//- 배열과 비슷하지만 가변/불변 차이가 있다
		//- 내용물(Generic type)을 같이 작성하는 것을 권장한다.
		
		//1. 아무 표시 없이 저장소를 만들었으므로 경고발생(Object 저장)
		TreeSet a = new TreeSet();
		
		//2. <String> 표시를 해서 저장소를 만들었으므로 경고없음(String 저장)
		TreeSet<String> b = new TreeSet<String>();
		
		//3. 우측에는 Generic type을 생략할 수 있다.
		TreeSet<String> c = new TreeSet<>(); //웬만하면 이런형태를 사용할 것
		
		//ArrayList d = new ArrayList();
		ArrayList<String> d = new ArrayList<>();
		
		//데이터 추가 - .add()
		c.add("피카츄");		d.add("피카츄");
		c.add("라이츄");		d.add("라이츄");
		c.add("파이리");		d.add("파이리");	
		c.add("꼬부기");		d.add("꼬부기");	
		
		//출력
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
}
