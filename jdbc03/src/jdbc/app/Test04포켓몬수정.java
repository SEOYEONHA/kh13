package jdbc.app;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test04포켓몬수정 {
	public static void main(String[] args) {
		
		//포켓몬스터 정보 수정 코드(+DAO)
		
		PocketmonDto dto = new PocketmonDto();
		dto.setPocketmonNo(1);
		dto.setPocketmonName("바꾼이름");
		dto.setPocketmonType("테스트");
		
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("포켓몬스터 변경 완료!");
		}
		else {
			System.out.println("존재하지않는 포켓몬 번호");
		}
	}
}
