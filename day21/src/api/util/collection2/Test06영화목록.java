package api.util.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test06영화목록 {
	public static void main(String[] args) {
//		마리오와 루이지는 각각 2023년 한 해 동안 다음과 같은 영화를 봤습니다.
//
//		마리오 : 서울의 봄, 그대들은 어떻게 살 것인가, 3일의 휴가, 괴물
//		루이지 : 나폴레옹, 사랑은 낙엽을 타고, 서울의 봄, 괴물, 쏘우 X
//
//		마리오와 루이지가 모두 본 영화 목록을 출력
//		마리오와 루이지 중 한 명만 본 영화 목록을 출력
		
		//기초 데이터 준비
		Set<String> mario = Set.of("서울의 봄", "그대들은 어떻게 살 것인가", "3일의 휴가", "괴물");
		Set<String> ruisy = Set.of("나폴레옹", "사랑은 낙엽을 타고", "서울의 봄", "괴물", "쏘우 X");
		
		Set<String> union = new TreeSet<>();
		union.addAll(mario);
		union.addAll(ruisy);
		System.out.println("<마리오와 루이지가 모두 본 영화 목록> 총 " + union.size() + "편");
		for(String title : union) {
			System.out.println("- " + title);
		}
		
		
		Set<String> intersect = new TreeSet<>();
		intersect.addAll(mario); //마리오 본 영화 더하고
		intersect.retainAll(ruisy); //루이지가 본 영화 겹치는것만 놔두고
		//System.out.println("1. 마리오와 루이지가 모두 본 영화 목록 : " + intersect);
		
		Set<String> minus = new TreeSet<>();
//		minus.addAll(mario);
//		minus.addAll(ruisy);
		minus.addAll(union);
		minus.removeAll(intersect);
		System.out.println("<마리오와 루이지 중 한 명만 본 영화 목록> 총 " + minus.size() + "편");
		for(String title : minus) {
			System.out.println("- " + title);
		}
	}
}
