package oop.inherit6;

public class Mp4 extends MediaFile {
//	public Mp4(String filename, long filesize, String execute, String information, 
//			String forward, String rewid) {
//		super(filename, filesize, execute, information, forward, rewid);
//	}

//	protected long speed;
//
//	public Mp4(String filename, long filsize) {
//		super(filename, filsize);
//	}
//
//	public Mp4(String filename) {
//		super(filename);
//	}
//
//	public long getSpeed() {
//		return speed;
//	}
//
//	public void setSpeed(long speed) {
//		this.speed = speed;
//	}
	
	
	private float speed;
	
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		if(speed <= 0f) return;
		this.speed = speed;
	}

	public Mp4(String filename, long filsize) {
		super(filename, filsize);
		this.setSpeed(1f);
	}

	public Mp4(String filename) {
		super(filename);
		this.setSpeed(1f);
	}
	
	//information이 마음에 들지 않는데... 왜 재생속도가 안나오지?
	//재정의(override)를 해서 내용을 바꿔보자!
	
	public void information() {
//		System.out.println("<파일 정보>");
//		System.out.println("이름 : " + this.getFilename()); //protected로 만들면 ㄱㄴ
//		System.out.println("크기 : " + this.getFilesize() + "바이트");
		super.information(); // 앞뒤로만 넣을 수 있고 중간에 내용넣기는 불가능, 그럴땐 위로 씀
		System.out.println("배속 : x" + this.speed);
	}
}
