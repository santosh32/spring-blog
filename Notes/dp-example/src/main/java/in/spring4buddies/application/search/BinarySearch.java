package in.spring4buddies.application.search;

public class BinarySearch {

	public static int binarySearch(int list[], int key) {

		int start = 0;
		int end = list.length - 1;

		while (start <= end) {
			int mid = start + end / 2;
			if (key == list[mid]) {
				return mid;
			}
			if (key < list[mid]) {
				end = mid - 1;
			} else {// if (key > list[mid]) {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] list = { -5, 1, 5, 12, 16 };
		System.out.println(binarySearch(list, 12));
		System.out.println(binarySearch(list, 5));
	}
}
