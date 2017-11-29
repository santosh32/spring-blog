package sort;

public class SelectionSortEx {

	public static void main(String[] args) {

		int[] a = new int[] { 11, 13, 5, 7, 3 };
		System.out.print("Before : ");
		print(a);

		int n = a.length;

		for (int outer = 0; outer < n - 1; outer++) {
			int mininum = outer;
			System.out.println("-----");
			for (int inner = outer + 1; inner < n; inner++)
				if (a[inner] < a[mininum])
					mininum = inner;

			int temp = a[mininum];
			a[mininum] = a[outer];
			a[outer] = temp;
			print(a);

		}

		System.out.println("=====");
		System.out.print("After  : ");
		print(a);
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
-----
3 13 5 7 11 
-----
3 5 13 7 11 
-----
3 5 7 13 11 
-----
3 5 7 11 13 
=====
After  : 3 5 7 11 13 
 */





