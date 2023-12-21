package oop.inherit6;

public class MediaFile extends File {
	

//생성자는 상속받는 상위클래스에 맞춘다
	public MediaFile(String filename) {
		super(filename);
		}
	public MediaFile(String filename, long filsize) {
		super(filename, filsize);
		}
	//	public MediaFile(String filename, long filesize, String execute, String information, String forward, String rewid) {
//		super(filename, filesize, execute, information);
//		this.setForward(forward);
//		this.setRewind(rewid);
//	}
//	protected String forward;
//	protected String rewind;
//	
//	
//	public String getForward() {
//		return forward;
//	}
//	public void setForward(String forward) {
//		this.forward = forward;
//	}
//	public String getRewind() {
//		return rewind;
//	}
//	public void setRewind(String rewind) {
//		this.rewind = rewind;
//	}
//	
	public void forward() {
		System.out.println("10초 뒤로 이동");
	}
	public void rewind() {
		System.out.println("10초 앞으로 이동");
	}
}
