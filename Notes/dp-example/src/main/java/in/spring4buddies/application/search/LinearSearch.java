package in.spring4buddies.application.search;

public class LinearSearch {

	public static int linearSearch(int list[], int key) {

		int start = 0;
		int end = list.length;

		for (int i = start; i < end; i++) {
			if (list[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] list = { -5, 1, 5, 12, 16 };
		System.out.println("Position of 12 is = " + linearSearch(list, 12));
		System.out.println("Position of -5 is = " + linearSearch(list, -5));
	}
}
