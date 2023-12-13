package array;

public class Test03배열생성 {
	public static void main(String[] args) {
//		다음 정보를 저장할 수 있도록 배열을 만들고 데이터를 출력하세요
//
//		[1] 30, 50, 20, 10, 40
//		[2] 피카츄, 라이츄, 파이리, 꼬부기
//		[3] 177.1f, 182.3f, 160.5f, 157.9f, 180.1f, 163.6f
		
		int[] arr = new int[] {30, 50, 20, 10, 40};
		
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
		
		//for(int i = 0 ; i <=4 ; i++) {
		//for(int i = 0 ; i < 5 ; i++) {
		for(int i = 0 ; i < arr.length  ; i++) {//a.length는 a 배열의 길이(칸수)
			System.out.println(arr[i]);
		}
		
//		String b = "피카츄";
		String[] b = new String[] {"피카츄", "라이츄", "파이리", "꼬부기"};
		for(int i1 = 0 ; i1 < b.length  ; i1++) {//a.length는 a 배열의 길이(칸수)
			System.out.println(b[i1]);
		}
		float[] arr2 = new float[] {177.1f, 182.3f, 160.5f, 157.9f, 180.1f, 163.6f};

		for(int i2 = 0 ; i2 < arr2.length  ; i2++) {//a.length는 a 배열의 길이(칸수)
			System.out.println(arr2[i2]);
		}
//		System.out.println(arr2[0]);
//		System.out.println(arr2[1]);
//		System.out.println(arr2[2]);
//		System.out.println(arr2[3]);
//		System.out.println(arr2[4]);
//		System.out.println(arr2[5]);
}
}