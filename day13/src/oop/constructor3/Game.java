package oop.constructor3;

public class Game {
//	게임 캐릭터 정보를 사용자에게 입력받아 캐릭터를 생성하는 프로그램을 구현하세요
//
//	캐릭터에는 아이디, 직업, 레벨, 소지금 정보가 저장되어야 합니다.
//	사용자에게 아이디와 직업을 입력받습니다.
//	직업은 전사, 도적, 마법사 중에서만 설정 가능합니다.
//	레벨은 자동으로 1로 설정됩니다.
//	소지금은 캐릭터 생성 시 100 gold로 설정됩니다.
//	캐릭터 생성 후 정보를 출력해보세요
	
	
	//멤버 필드(변수)
	private String name;
	private String job;
	private int level;
	private long gold;
	
	//생성자 - 초기화
	Game(String name, String job){
		this.setName(name);
		this.setJob(job);
		this.setLevel(1);
		this.setGold(100);
	}
	Game(String name, String job, int level, long gold){
		this.setName(name);
		this.setJob(job);
		this.setLevel(level);
		this.setGold(gold);
	}
	//멤버 메소드 - 주요기능
	void setName(String name) {
		this.name = name;
	}
	void setJob(String job) {
		switch(job) {
		case "전사":
		case "도적":
		case "마법사":
			this.job = job;
		}
	}
	void setLevel(int level) {
		if(level < 1) return;
		this.level = level;
	}
	void setGold(long gold) {
		if(gold < 0) return;
		this.gold = gold;
	}
	String getName() {
		return this.name;
	}
	String getJob() {
		return this.job;
	}
	int getLevel() {
		return this.level;
	}
	long getGold() {
		return this.gold;
	}
	void information() {
		System.out.println("<캐릭터 정보>");
		System.out.println("캐릭터명 : " + this.getName());
		System.out.println("직업 : " + this.getJob());
		System.out.println("레벨 : " + this.getLevel());
		System.out.println("소지금 : " + this.getGold() + " gold");
	}
	
	void levelUp() {
		this.level ++;
	}
}
