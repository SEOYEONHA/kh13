package oop.inherit6;

public class File {
	//필드
	private String filename;
	private long filesize;
	//protected String execute;
	//protected String information;

//	public File(String filename, long filesize, String execute, String information) {
//		this.setFilename(filename);
//		this.setFilesize(filesize);
//		this.setExecute(execute);
//		this.setInformation(information);
//	}
	
	//생성자
	public File(String filename) {
		this(filename, 0L); //생성자 몰아주기
	}
	
	public File(String filename, long filsize) {
		this.setFilename(filename);
		this.setFilesize(filsize);
	}

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		if(filesize < 0L) return;
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
//	public String getExecute() {
//		return execute;
//	}
//	public void setExecute(String execute) {
//		this.execute = execute;
//	}
//	public String getInformation() {
//		return information;
//	}
//	public void setInformation(String information) {
//		this.information = information;
//	}
	
	public void filename() {
		System.out.println("파일이름 : " + getFilename());
	}
	public void filesize() {
		System.out.println("파일크기 : " + getFilesize());
	}
	public void execute() {
		System.out.println(this.filename + "파일 실행");
	}
	public void information() {
		System.out.println("<파일 정보>");
		System.out.println("이름 : " + this.filename);
		System.out.println("크기 : " + this.filesize + "바이트");
	}
}
