package api.lang.etc;

import java.io.IOException;

public class Test03Runtime클래스 {
	public static void main(String[] args) throws IOException {
		//Runtime 클래스
		//- 직접 객체를 생성할 수는 없으나 생성된 객체를 빌려올 수는 있는 구조
		//- 객체를 빌려오는 메소드를 찾아야 한다(static 메소드)
		
		//Runtime rt = new Runtime(); //생성(불가능)
		Runtime rt = Runtime.getRuntime(); //대여(렌탈)
		
		//rt로는 터미널 명령을 실행할 수 있다.
		
		String os = System.getProperty("os.name");
		if(os.startsWith("Windows")) { 
			rt.exec("notepad"); //실행을 장담할 수 없으니 Plan B를 설계하고 실행하라!
		//rt.exec("calc");
		//rt.exec("mspaint");
		}
		else if(os.startsWith("Mac")) {
			rt.exec("open -a TextEdit.app");
		}
	}
}
