package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
		
//		Map을 만들고 다음 아이디와 비밀번호를 저장해둔 뒤 사용자에게 아이디와 비밀번호를 입력받아 로그인을 판정하는 프로그램을 구현하세요
//
//		(아이디) khadmin , (비밀번호) admin1234
//		(아이디) khstudent, (비밀번호) student1234
//		(아이디) khteacher, (비밀번호) teacher1234
//		(아이디) khmanager, (비밀번호) manager1234
//
//		사용자가 입력한 아이디와 비밀번호를 검사하여 통과 시 로그인 성공 출력
//		통과하지 못할 경우 입력하신 정보가 일치하지 않습니다 출력
		Scanner sc = new Scanner(System.in);
		
		//저장소 생성
		Map<String, String> datalist = new HashMap<>();
		
		//데이터 등록
		datalist.put("khadmin", "admin1234");
		datalist.put("khstudent", "student1234");
		datalist.put("khteacher", "teacher1234");
		datalist.put("khmanager", "manager1234");
		
		//사용자 입력
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호를 입력하세요 : ");
		String inputPw = sc.nextLine();
		
		sc.close();
		
		//판정
		String pw = datalist.get(id);
		boolean idPass = pw != null; //datalist.containsKey(id);
		
		if(idPass && pw.equals(inputPw)) {
			System.out.println("로그인 성공!");
		}
		else /*if(!pw.equals(inputPw) || idFail)*/ {
			System.out.println("입력하신 정보가 일치하지 않습니다. 아이디또는 비밀번호를 확인해주세요");
		}
		
	}
}
