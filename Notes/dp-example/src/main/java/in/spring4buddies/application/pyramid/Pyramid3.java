package in.spring4buddies.application.pyramid;

public class Pyramid3 {

	public static void main(String[] args) {
		int n = 5;
		for (int i = n; i >0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
}


/*
5 4 3 2 1 
4 3 2 1 
3 2 1 
2 1 
1
* */
