package jdbc.app;

import java.util.List;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test10포켓몬조회 {
	public static void main(String[] args) {
		//조회 역시 DAO를 이용하여 진행
		//- 목록을 조회하는 경우
		//		- 데이터가 여러 개 조회된다(0, 1개도 포함)
		//		- 원하는 최종 형태는 List<PocketmonDto>
		//- 단일항목을 조회하는 경우
		//		- 기본키(PK) 조건을 통해 조회
		//		- 데이터가 있거나 없거나 두 가지 상태 뿐
		//		- 원하는 최종 형태는 PocketmonDto
		
		PocketmonDao dao = new PocketmonDao();
		List<PocketmonDto> list = dao.selectList();
		System.out.println(list.size());
		//list를 이용해서 반복 또는 개수확인 등을 구현할 수 있다
		
	}
}