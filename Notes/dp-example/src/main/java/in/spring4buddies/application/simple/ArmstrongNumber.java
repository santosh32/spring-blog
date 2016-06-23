package in.spring4buddies.application.simple;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int number = 153;
		System.out.println(number + " isArmstrong - " + isArmstrong(number));
	}

	private static boolean isArmstrong(int number) {
		int temp = number;
		int armstrong = 0;
		int reminder = 0;
		while (number > 0) {
			reminder = number % 10;
			number = number / 10;
			armstrong = armstrong + reminder * reminder * reminder;
		}
		if (armstrong == temp) {
			return true;
		}
		return false;
	}
}
