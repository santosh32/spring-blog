package in.spring4buddies.application.pyramid;

public class Pyramid5 {

	public static void main(String[] args) {
		int n = 9;
		int s = 5;
		for (int i = n; i >= s; i--) {
			for (int j = s; j < i + 1; j++) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
}


/*
5 6 7 8 9 
5 6 7 8 
5 6 7 
5 6 
5 
* */
