package oop.inherit6;

public class Ppt extends DocumentFile{
	//추가 필드 없음
	//생성자 맞춤
	public Ppt(String filename, int pagesize) {
		super(filename, pagesize);
	}

	public Ppt(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public Ppt(String filename, long filesize) {
		super(filename, filesize);
	}

	public Ppt(String filename) {
		super(filename);
	}
	
	//추가되는 메소드
	public void slideShow() {
		System.out.println("슬라이드 쇼 시작");
	}

	
}
