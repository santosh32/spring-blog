package in.spring4buddies.application.pyramid;

public class Pyramid4 {

	public static void main(String[] args) {
		int n = 5;
		for (int i = n; i > 0; i--) {
			for (int j = 1; j < i + 1; j++) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
}


/*
1 2 3 4 5 
1 2 3 4 
1 2 3 
1 2 
1 
* */
