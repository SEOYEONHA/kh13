package api.util.scanner;

import java.util.Scanner;

public class Test03Scanner부가기능2 {
	public static void main(String[] args) {
		String colors = "빨강+주황/노랑-초록=파랑*남색_보라";
		
		Scanner sc = new Scanner(colors);
		String find = sc.findInLine("[가-힣]+");
		System.out.println("find = " + find);
		sc.close();
	}
}
