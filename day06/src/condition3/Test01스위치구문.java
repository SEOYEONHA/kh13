package condition3;

public class Test01스위치구문 {
	public static void main(String[] args) {
		//월을 입력받아 계절을 출력하는 프로그램
		
		//입력
		int month = 3;
		
		//출력 - break를 의도적으로 배치하여 여러 경우를 묶어서 처리
		switch(month) {//month에 있는 값에 따라 시작 지점이 달라진다
		case 3:	case 4: 	case 5:
			System.out.println("봄");
			break; 
		case 6:	case 7: case 8:
			System.out.println("여름");
			break; 
		case 9: case 10: case 11:
			System.out.println("가을");
			break;
		//case 12: case 1: case 2:
		default: //나머지(기본값) = if구문에서 else랑 비슷
			System.out.println("겨울");
			break;
		}
	}
}
