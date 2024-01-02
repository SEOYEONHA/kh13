package api.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test02List {
	public static void main(String[] args) {
		//List<E>
		//- 순서를 가장 중요하게 생각하는 저장소
		//- 그룹 내에서 클래스가 다르다는 것은 저장 원리가 다르다는 것
		
		ArrayList<String> a = new ArrayList<>();
		//String[] = a = new String[5]; //(배열이었으면)
		
		//LinkedList<String> b = new LinkedList<>();
		//CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList <>();
		
		//데이터 추가
		a.add("자바");				//a[0] = "자바";
		a.add("파이썬");			//a[1] = "파이썬";
		a.add("안드로이드");	//a[2] = "안드로이드";
		a.add("루비");				//a[3] = "루비";
		a.add("엘릭서");			//a[4] = "엘릭서";
		//a.add(100); String이라고 지정해둬서 불가능
		
		//데이터 개수 확인
		System.out.println("개수 = " + a.size());
		
		//데이터 검색
		System.out.println("자바가 있나요? " + a.contains("자바"));
		
		//데이터 삭제
		a.remove("파이썬");
		
		//출력
		System.out.println(a);
	}
}
