package in.spring4buddies.application.simple;

public class PrimeNumber {

	public static void main(String[] args) {
		int n = 11;
		System.out.println(n + " is prime - " + isPrime(n));
	}

	private static Boolean isPrime(int num) {
		double n = Math.sqrt(num);
		for (int i = 2; i < n; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
