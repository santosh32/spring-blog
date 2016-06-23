package in.spring4buddies.application.simple;

public class Factorial {

	public static void main(String[] args) {
		int number = 5;
		int temp = number;
		int factorial = 1;
		while (number > 0) {
			factorial = factorial * number;
			number--;
		}
		System.out.println("Factorial of " + temp + " is " + factorial);
	}
}
