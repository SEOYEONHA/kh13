package oop.method9;

public class Bank {
	//멤버 변수
	String name;
	double basicRate;
	double specialRate;
	int monthlyInstall;
	int year;
	
	//멤버 메소드
	void data(String name, double basicRate, double specialRate, int monthlyInstall, int year) {
		this.name = name;
		this.basicRate = basicRate;
		this.specialRate = specialRate;
		this.monthlyInstall = monthlyInstall;
		this.year = year;
	}
	int getYearlyInstall() {
		return this.monthlyInstall * 12;
	}
	double getTotalRate() {
		return this.basicRate + this.specialRate;
	}
	double getInterest() {
		return this.getTotalRate() * this.getYearlyInstall() / 100;
	}
	int getTotalDeposit() {
		return this.getYearlyInstall() * this.year;
	}
	int getTotal() {
		return (int)((this.getYearlyInstall() + this.getInterest()) * this.year);
	}
	String getName() {
		return this.name;
	}
	double getBasicRate() {
		return this.basicRate;
	}
	double getSpecialRate() {
		return this.specialRate;
	}
	double getMonthlyInstall() {
		return this.monthlyInstall;
	}
	int getYear() {
		return this.year;
	}
	
	
	void information() {
		System.out.println("<적금 통장 정보>");
		System.out.println("예금주 : " + this.getName());
		System.out.println("기본이율 : " + this.getBasicRate() + "%, 우대이율 : " + this.getSpecialRate() + "%, 총 이율 : " + this.getTotalRate() + "%");
		System.out.println("월 입금액 : " + this.getMonthlyInstall() + "원, 1년 입금액 : " + this.getYearlyInstall() + "원");
		System.out.println("총 입금액 : " + this.getTotalDeposit());
		System.out.println("만기 예상 금액 : " + this.getTotal() + "원");
		if(this.year <= 3) {
			System.out.println("예치기간 : " + this.getYear() + "년 / 3년 이하로 비과세상품입니다.");
		}
		else {
			System.out.println("예치기간 : " + this.getYear() + "년 / 3년 이상으로 과세상품 입니다.");
		}
		System.out.println();
	}
}
