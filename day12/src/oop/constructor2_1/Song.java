package oop.constructor2_1;

//클래스는 객체를 생성하기 위한 도구이다
public class Song {
	//멤버 필드(변수) - 데이터
	private String title;
	private String artist;
	private long playCount;
	private int likeCount;
	
	//생성자 - 초기화
	Song(String title, String artist) {
		this(title, artist, 0, 0);
	}
	Song(String title, String artist, long playCount, int likeCount){
		this.setTitle(title);
		this.setArtist(artist);
		this.setPlayCount(playCount);
		this.setLikeCount(likeCount);
	}
	
	//멤버 메소드 - 주요 기능
	void setTitle(String title) {
		this.title = title;
	}
	void setArtist(String artist) {
		this.artist = artist;
	}
	void setPlayCount(long playCount) {
		if(playCount < 0L) return;
		this.playCount = playCount;
	}
	void setLikeCount(int likeCount) {
		if(likeCount < 0) return;
		this.likeCount = likeCount;
	}
	String getTitle() {
		return this.title;
	}
	String getArtist() {
		return this.artist;
	}
	long getPlayCount() {
		return this.playCount;
	}
	int getLikeCount() {
		return this.likeCount;
	}
	
	long getRankingPoint() {
		return this.playCount * 2 + this.likeCount / 2;
		//return this.getPlayCount() * 2 + this.getLikeCount() / 2;
	}
	
	String getBestText() {
		if(this.playCount > 100000L) {
			return "(베스트)";
		}
		return "";
	}
	String getFavoriteText() {
		if(this.likeCount > 100000) {
			return "(인기곡)";
		}
		else {
			return "";
		}
	}
	
	void information() {
		System.out.println("<음원 정보>");
		System.out.println("제목 : " + this.title 
						+ this.getBestText() + this.getFavoriteText());//(베스트) (인기곡)
		System.out.println("가수 : " + this.artist);
		System.out.println("재생 수 : " + this.playCount+"회");
		System.out.println("좋아요 : " + this.likeCount);
		System.out.println("랭킹 포인트 : "+this.getRankingPoint()+" point");
	}
}
