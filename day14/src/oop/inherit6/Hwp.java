package oop.inherit6;

public class Hwp extends DocumentFile{

//	protected String preview;
//
//	public String getPreview() {
//		return preview;
//	}
//
//	public void setPreview(String preview) {
//		this.preview = preview;
//	}
//	
//	public void preview() {
//		System.out.println("미리보기 기능 실행");
//	}


	//추가되는 필드 없음
	public Hwp(String filename, int pagesize) {
		super(filename, pagesize);
	}

	public Hwp(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public Hwp(String filename, long filesize) {
		super(filename, filesize);
	}

	public Hwp(String filename) {
		super(filename);
	}

		//추가되는 메소드 구현
	public void preview() {
		System.out.println("미리보기 기능 실행");
	}

}