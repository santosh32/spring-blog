package in.spring4buddies.application.simple;

public class SquartRoot {

	public static void main(String[] args) {
		int n = 11;
		System.out.println(Math.sqrt(n));
		squartRoot(n);
	}

	private static void squartRoot(int num) {
		
		System.out.println((num ^ (1 / 2)));
	}
}
