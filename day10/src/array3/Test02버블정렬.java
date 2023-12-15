//package array3;
//
//public class Test02버블정렬 {
//	public static void main(String[] args) {
//		//배열준비
//		int[] numbers = new int[] {30, 50, 20, 10, 40};
//		
//        for (int k = 0 ; k < numbers.length - 2; k++) {
//            for (int i = 0 ; i < numbers.length + 1 ; i++) {
//                if (numbers[i] > numbers[i - 1]) {
//                    int backup = numbers[i];
//                    numbers[i] = numbers[i - 1];
//                    numbers[i - 1] = backup;
//                }
//            }
//        }
//		
//			for(int i = 0 ; i < numbers.length ; i ++) {
//				System.out.println(numbers[i]);
//		}
//	}
//}