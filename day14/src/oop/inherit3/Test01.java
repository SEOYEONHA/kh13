package oop.inherit3;

public class Test01 {
	public static void main(String[] args) {
		//Browser browser = new Browser(); //존재하면 안되는 객체
		
		Chrome c1 = new Chrome();
		c1.url();
		c1.refresh();
		c1.move();
		c1.develop();
		c1.chromeStore();
		
		Edge e1 = new Edge();
		e1.url();
		e1.refresh();
		e1.move();
		e1.fullScreen();
		
		Whale w1 = new Whale();
		w1.url();
		w1.refresh();
		w1.move();
		w1.papago();
		w1.naverSearch();
		
	}
}
