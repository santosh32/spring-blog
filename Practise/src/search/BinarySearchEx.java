package search;

public class BinarySearchEx {

	public int binarySearch(int[] a, int key) {

		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (key < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		BinarySearchEx mbs = new BinarySearchEx();
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
		System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
		
		int[] arr1 = { 6, 34, 78, 123, 432, 900 };
		System.out .println("Key 432's position: " + mbs.binarySearch(arr1, 432));
	}
}