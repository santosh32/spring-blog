package in.spring4buddies.application.sort;

public class BubbleSort {
	public static void main(String[] arg) {

		int[] numbers = new int[] { 10, 0, 23, 18, -10, 25 };
		print(numbers);
		System.out.println("------------");
		bubbleSort(numbers);

	}

	private static void bubbleSort(int[] list) {
		int n = list.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					print(list);
				}
			}
			System.out.println("------------");
		}
	}

	private static void print(int[] numbers) {

		for (int i : numbers) {
			System.out.print(i + ", ");

		}
		System.out.println();

	}
}