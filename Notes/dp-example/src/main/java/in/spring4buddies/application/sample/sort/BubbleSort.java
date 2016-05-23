package in.spring4buddies.application.sample.sort;

public class BubbleSort {

	public static void bubbleSort(int list[]) {
		
		int n = list.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					int temp;
					temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					
				}
				print(list);
			}
			System.out.println("---------");
		}
	}

	public static void main(String[] args) {
//		 int[] list = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] list = { 5, 1, 12, -5, 16 };
		print(list);
		bubbleSort(list);
	}

	private static void print(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + ", ");
		}
		System.out.println("\n");
	}
}
