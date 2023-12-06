package data2;

public class Test03급여계산기 {
	public static void main(String[] args) {
		//급여액이 주어졌을 때 각종 세금과 수령액을 계산하는 계산기를 구현합시다

		//급여액 : 300만원
		//국민연금 : 급여액의 4.5%
		//건강보험료 : 급여액의 7.09%
		//장기요양보험료 : 건강보험료의 12.81%
		//고용보험료 : 급여액의 0.9%

		//출력 순서
		//실수령액
		//국민연금
		//건강보험료
		//장기요양보험료
		//고용보험료
		
		int salary = 3000000;
		double pension = 4.5;
		double health = 7.09;
		double care = 12.81;
		double employment = 0.9;
		
		
		double pensionPer = pension / 100;
		double healthPer = health / 100;
		double carePer = care / 100;
		double employmentPer = employment / 100;
		
		double sPension = salary * pensionPer;
		double sHealth = salary * healthPer;
		double sCare = sHealth * carePer;
		double sEmployment = salary * employmentPer;


		
		
		double netPay = salary - sPension - sHealth - sCare - sEmployment;
		
		System.out.println(netPay);
		System.out.println(sPension);
		System.out.println(sHealth);
		System.out.println(sCare);
		System.out.println(sEmployment);
	
	
		
		
	}

}
