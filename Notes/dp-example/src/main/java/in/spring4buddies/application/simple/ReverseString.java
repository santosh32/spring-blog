package in.spring4buddies.application.simple;

public class ReverseString {

	public static void main(String[] args) {
		String str = "amaresh";
		System.out.println(str + " reverse format is  - " + reverse(str));
		
		char[] temp = str.toCharArray();
		for (int i = temp.length-1; i >= 0; i--) {
			System.out.print(temp[i]);
		}
	}

	private static String reverse(String str) {
		char[] c = str.toCharArray();
		for (int i = 0, j = c.length - 1; i < c.length / 2; i++, j--) {
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}
}
