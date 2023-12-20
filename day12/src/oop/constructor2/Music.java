package oop.constructor2;

public class Music {
	private String song;
	private String singer;
	private int count; // long으로
	private int like;
	
	String getSong() {
		return song;
	}
	void setSong(String song) {
		if(song == "") {
			return;
		}
		this.song = song;
	}

	String getSinger() {
		return singer;
	}
	void setSinger(String singer) {
		if(singer == "") {
			return;
		}
		this.singer = singer;
	}

	int getCount() {
		return count;
	}
	void setCount(int count) {
		if(count < 0) return;
		this.count = count;
	}
	
	int getLike() {
		return like;
	}
	void setLike(int like) {
		if(like < 0) return;
		this.like = like;
	}
	
	int getPoint() { //long으로
		return this.getCount() * 2 + this.getLike() / 2;
	}
	
	Music(String song, String singer, int count, int like){
		this.setSong(song);
		this.setSinger(singer);
		this.setCount(count);
		this.setLike(like);
	}
	
	void information() {
		System.out.print("제목 : " + this.getSong());
			if(this.getCount() > 100000) {
				System.out.print("(베스트)");
			}
			if(this.getLike() > 100000) {
				System.out.println("(인기곡)");
			}
			else {
				System.out.println();
			}
		System.out.println("가수 : " + this.getSinger());
		System.out.println("재생 수 : " + this.getCount());
		System.out.println("좋아요 수 : " + this.getLike());
		System.out.println("랭킹 점수 : " + this.getPoint());
		System.out.println();
	}
}