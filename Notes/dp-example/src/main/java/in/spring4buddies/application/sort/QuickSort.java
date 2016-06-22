package in.spring4buddies.application.sort;

public class QuickSort {

	private int array[];
	private int length;

	public void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
				print(array);
			}
		}
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	public static void main(String a[]) {
		QuickSort sorter = new QuickSort();
		int[] input = { 5, 1, 12, 16, -5 };
		print(input);
		sorter.sort(input);
	}

	private static void print(int[] input) {
		for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
}
