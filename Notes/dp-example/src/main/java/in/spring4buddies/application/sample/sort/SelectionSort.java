package in.spring4buddies.application.sample.sort;

public class SelectionSort {

	public static void insertionSort(int[] list) {
		int n = list.length, key;
		for (int i = 1; i < n; i++) {
			int j = i - 1;
			key = list[i];
			while (j >= 0 && key < list[j]) {
				int temp = list[j];
				list[j] = list[j + 1];
				list[j + 1] = list[j];
				print(list);
			}
			j--;
			System.out.println("---------");
		}
	}

	public static void main(String a[]) {
		int[] list = { 10, 34, 2, 56, 7, 67, 88, 42 };
		print(list);
		System.out.println("---------");
		insertionSort(list);
	}

	private static void print(int[] list) {
		for (int i : list) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n ");
	}
}
