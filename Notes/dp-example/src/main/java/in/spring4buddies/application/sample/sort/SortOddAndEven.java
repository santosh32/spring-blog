package in.spring4buddies.application.sample.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortOddAndEven {
	public static void main(String[] args) {
		Integer num[] = { 10, 1, 8, 3, 6, 7 };
		for (int i = 0; i < num.length; i++) {
			System.out.print(" " + num[i]);
		}
		
		Arrays.sort(num, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				
				
				return 0;
			} 
		});
		
//		int temp;
//		for (int i = 0; i < num.length; i++) {
//			for (int j = i; j > 0; j--) {
//				if (num[j] < num[j - 1]) {
//					temp = num[j];
//					num[j] = num[j - 1];
//					num[j - 1] = temp;
//				}
//			}
//		}
		System.out.println("\n");
		for (int i = 0; i < num.length; i++) {
			System.out.print(" " + num[i]);
		}
		
		
	}
}
