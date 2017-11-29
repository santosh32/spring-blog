package sort;

public class BubbleSortEx {

	public static void main(String[] args) {

		int[] a = new int[] { 11, 13, 5, 7, 3 };
		System.out.print("Before : ");
		print(a);

		for (int outer = a.length - 1; outer > 0; outer--) {
			System.out.println("-----");
			for (int inner = 0; inner < outer; inner++) {
				if (a[inner] > a[inner + 1]) {
					int temp = a[inner];
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
				}
				print(a);
			}
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
 Before : 11 13 5 7 3 
-----
11 13 5 7 3 
11 5 13 7 3 
11 5 7 13 3 
11 5 7 3 13 
-----
5 11 7 3 13 
5 7 11 3 13 
5 7 3 11 13 
-----
5 7 3 11 13 
5 3 7 11 13 
-----
3 5 7 11 13 
=====
After  : 3 5 7 11 13 
 */

