package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test01Set {
	public static void main(String[] args) {
		//Set<E>
		//- 전체를 매우 빠르게 탐색할 수 있도록 신경쓴 구조
		//- 구조에 따라 TreeSet, HashSet 등이 존재
		//- 구조적으로 중복이 불가능
		//- 구조적으로 정해진 저장 순서를 따른다
		//- 구조적으로 인덱스가 존재하지 않는다
		
		//TreeSet<String> ts = new TreeSet<>();
		Set<String> ts = new TreeSet<>();//업캐스팅
		
		//데이터 추가
		ts.add("피카츄");
		ts.add("라이츄");
		ts.add("파이리");
		ts.add("꼬부기");
		
		ts.add("피카츄");
		ts.add("피카츄");
		ts.add("피카츄");
		
		//데이터 검색
		//- 피카츄가 저장소에 있습니까?
		System.out.println(ts.contains("피카츄"));
		
		//데이터 삭제
		ts.remove("파이리");
		
		//데이터 출력
		System.out.println(ts);
		System.out.println(ts.size());//개수
	}
}