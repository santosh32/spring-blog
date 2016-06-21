package in.spring4buddies.application.sample.sort;

public class InsertionSort {

	public static void insertionSort(int[] list) {
		int n = list.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (list[j] < list[j - 1]) {
					int temp = list[j];
					list[j] = list[j - 1];
					list[j - 1] = temp;
					print(list);
				}
			}
			System.out.println("---------");
		}
	}

	public static void main(String a[]) {
		int[] list = { 5, 1, 12, 16, -5 };
		print(list);
		System.out.println("---------");
		insertionSort(list);
	}

	private static void print(int[] list) {
		for (int i : list) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.println();
	}
}
