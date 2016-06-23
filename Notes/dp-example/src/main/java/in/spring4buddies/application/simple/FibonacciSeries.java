package in.spring4buddies.application.simple;

public class FibonacciSeries {

	public static void main(String[] args) {
		int number = 20;
		int f1 = 0, f2 = 1;
		for (int i = 0; i < number; i++) {
			System.out.print(f1 + " " + f2 + " ");
			f1 = f1 + f2;
			f2 = f1 + f2;
		}
	}
}
