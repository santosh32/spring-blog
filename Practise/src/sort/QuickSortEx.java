package sort;

public class QuickSortEx {
	private int a[];
	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.a = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = a[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			System.out.println("----");
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				// move index to next position on both sides
				i++;
				j--;
				print(a);
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	public static void main(String a[]) {

		QuickSortEx sorter = new QuickSortEx();
		int[] input = { 11, 13, 5, 7, 3 };
		System.out.print("Before : ");
		print(input);
		sorter.sort(input);
		System.out.println("====");
		System.out.print("After : ");
		print(input);
	}
	private static void print(int[] a) {
		for (int x : a) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}

/*
 * 
Before : 11 13 5 7 3 
----
3 13 5 7 11 
----
3 5 13 7 11 
----
3 5 13 7 11 
----
3 5 7 13 11 
----
3 5 7 11 13 
====
After : 3 5 7 11 13 

 */
