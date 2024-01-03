package api.util.collection2;

import java.util.HashSet;
import java.util.Set;

public class Test01Set2 {
	public static void main(String[] args) {
		//Set<E>
		//- 전체를 매우 빠르게 탐색할 수 있도록 신경쓴 구조
		//- 구조에 따라 TreeSet, HashSet 등이 존재
		
		//HashSet<String> ts = new HashSet<>();
		Set<String> hs = new HashSet<>();//업캐스팅
		
		//데이터 추가
		hs.add("피카츄");
		hs.add("라이츄");
		hs.add("파이리");
		hs.add("꼬부기");
		
		hs.add("피카츄");
		hs.add("피카츄");
		hs.add("피카츄");
		
		//데이터 검색
		//- 피카츄가 저장소에 있습니까?
		System.out.println(hs.contains("피카츄"));
		
		//데이터 삭제
		hs.remove("파이리");
		
		//데이터 출력
		System.out.println(hs);
		System.out.println(hs.size());//개수
	}
}