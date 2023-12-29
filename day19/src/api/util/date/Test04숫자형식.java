package api.util.date;

import java.text.DecimalFormat;

public class Test04숫자형식 {
	public static void main(String[] args) {
		//Format 중 하나인 DecimalFormat 으로 숫자의 형식을 제어할 수 있다.
		//# - 해당 자리의 값이 있으면 출력
		//0 - 해당 자리의 값을 출력하고 없으면 0으로 출력(자리수 확보할 때 0사용)
		
		int  a = 123456789;
		double b = 1234.56789;
		
		DecimalFormat df = new DecimalFormat("#,##0.00");
		
		System.out.println("a = " + df.format(a));
		System.out.println("b = " + df.format(b));
	}
}
