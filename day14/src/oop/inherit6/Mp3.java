package oop.inherit6;

public class Mp3 extends MediaFile{
//	public Mp3(String filename, long filesize, String execute, String information, String forward, String rewid) {
//		super(filename, filesize, execute, information, forward, rewid);
//	}
//
//	protected int duraion;
//
//	public int getDuraion() {
//		return duraion;
//	}
//
//	public void setDuraion(int duraion) {
//		this.duraion = duraion;
//	}
//
//	public void duration() {
//		System.out.println("재생 시간 : " + this.getDuraion());
//	}
//}
	//추가 필드
	private int duration;

	//getter&setter
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		if(duration < 0) return;
		this.duration = duration;
	}
	
	//생성자
	public Mp3(String filename, int duration) {
		super(filename);
		this.setDuration(duration);
	}
	public Mp3(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.setDuration(duration);
	}
	
	public String getDurationString() {
		if(this.duration < 60) {
			return this.duration + "초";
		}
		else if(this.duration < 60 * 60) {
			int minute = duration / 60;
			int second = duration % 60;
			return minute + "분" + second + "초";
		}
		else if(this.duration < 24 * 60 * 60) {
			int hour = duration / 60 / 60;
			int minute = duration / 60 % 60;
			int second = duration % 60;
			return hour + "시간" + minute + "분" + second + "초";
		}
		return "매우 김";
	}
	
	//재정의(override)를 통해 information개조
	public void information() {
		super.information();
		System.out.println("재생시간 : " + this.getDurationString());
	}
}
