package in.spring4buddies.application.sample.sort;

public class SelectionSort {

	public static void selectionSort(int[] list) {

		int n = list.length;
		for (int i = 0; i < n - 1; i++) {
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (list[j] < list[index]) {
					index = j;
				}
			}

			int smallerNumber = list[index];
			list[index] = list[i];
			list[i] = smallerNumber;

			print(list);

			System.out.println("---------");
		}
	}

	public static void main(String a[]) {
		int[] list = { 10, 34, 2, 56, 7, 67, 88, 42 };
		print(list);
		System.out.println("---------");
		selectionSort(list);
	}

	private static void print(int[] list) {
		for (int i : list) {
			System.out.print(i);
			System.out.print(", ");
		}
		System.out.print("\n ");
	}
}
