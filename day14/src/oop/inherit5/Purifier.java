package oop.inherit5;

public class Purifier {
	protected String company;
	protected int price;
	//protected String type;
	
	//protected
	public Purifier(String company, int price){//, String type) {
		this.setCompany(company);
		this.setPrice(price);
		//this.setType(type);
	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
	public void informaiont() {
		System.out.println("업체 : " + getCompany() + ", 가격 : " + getPrice()); // + ", 종류 : " + getType());
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price < 0) return;
		this.price = price;
	}
	
	public void normal() {
		System.out.println("정수 1잔 추출");
	}
}
