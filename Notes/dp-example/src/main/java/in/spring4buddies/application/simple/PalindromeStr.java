package in.spring4buddies.application.simple;

public class PalindromeStr {

	public static void main(String[] args) {
		String str = "abcba";
		System.out.println(str + " is Palindrome  - " + isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {
		char[] c = str.toCharArray();
		for (int i = 0, j = c.length - 1; i < c.length / 2; i++, j--) {
			if (c[i] != c[j]) {
				return false;
			}
		}
		return true;
	}
}
