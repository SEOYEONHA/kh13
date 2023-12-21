package oop.inherit6;

public class DocumentFile extends File{
	private int pagesize;

	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		if(pagesize <= 0) return;
		this.pagesize = pagesize;
	}
	public DocumentFile(String filename) {
		super(filename);
		this.setPagesize(pagesize);
	}
	public DocumentFile(String filename, int pagesize) {
		super(filename);
		this.setPagesize(pagesize);
	}
	public DocumentFile(String filename, long filesize) {
		super(filename, filesize);
		this.setPagesize(1);
	}
	public DocumentFile(String filename, long filesize, int pagesize) {
		super(filename, filesize);
		this.setPagesize(pagesize);
	}
}
