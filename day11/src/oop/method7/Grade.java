package oop.method7;

public class Grade {
//	다음 데이터를 클래스를 사용하여 객체화하고 출력하세요
//	저장하지 않아도 되는 데이터가 있을 수 있습니다.
//	정보 출력 시 통과 또는 재평가 여부를 출력하세요.
//	통과는 각 과목별 40점 이상, 총 평균 60점 이상이어야 합니다.
//	통과가 아니면 재평가 입니다.
//	소수점 자리수는 신경쓰지 마세요
	
	//멤버변수
	int form;
	int cla;
	String name;
	int kor, eng, math;
	int total; //=  kor + eng + math;
	double average; //= (double)total / 3;
	//boolean pass = kor >= 40 && eng >=40 && math >= 40 && average >= 60;;
		
	
	//멤버 메소드
	void data(int form, int cla, String name, int kor, int eng, int math) { //, 
			//int total, double average) {
		this.form = form;
		this.cla = cla;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		//this.total = total;
		//this.average = average;
	}
		
//	void data(int form, int cla, String name, int kor, int eng, int math, int total, 
//			double average, boolean pass) {
//		this.form = form;
//		this.cla = cla;
//		this.name = name;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//		this.total = total;
//		this.average = average;
//		this.pass = pass;
//		}
	
	void information() {
		System.out.println(this.form + "학년 " + this.cla + "반");
		System.out.println("이름 : " + this.name);
		System.out.println("국어 : " + this.kor + "점, 영어 : " + this.eng + "점, 수학 : " + this.math + "점");
		int total = kor + eng + math;
		System.out.println("총 점수 : " + total);
		double average = (double)total / 3;
		System.out.println("평균 : " + average);
		//if(this.pass) {
		if(this.kor >= 40 && this.eng >=40 && this.math >= 40 && average >= 60) {
			System.out.println("통과입니다.");
		}
		else {
			System.out.println("재평가 대상입니다.");
		}
	}

}