package in.spring4buddies.application.simple;

public class ReverseNumber {

	public static void main(String[] args) {
		int number = 12345;
		System.out.println(number + " reverse format is  - " + reverse(number));
	}

	private static int reverse(int number) {
		int reminder, reverse = 0;
		while (number > 0) {
			reminder = number % 10;
			number = number / 10;
			reverse = reverse * 10 + reminder;
		}
		return reverse;
	}
}
