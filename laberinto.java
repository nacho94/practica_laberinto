

import java.util.Random;

class point {
	private int x;
	private int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}


public class laberinto {


	public static void main (String [] args) {

		int [][] b = pedirEntrada();
		print(b);
	}

	public static int [][] pedirEntrada () {

		int n = 5;
		int [][] matriz = new int [n][];

		for (int i = 0; i<n; i++) {
			matriz [i] = new int [n];

		}
		Random randomGenerator = new Random();

		for (int i = 0; i<n; i++) {
			
			for (int j = 0; j<n; j++) {
				matriz [i][j] = randomGenerator.nextInt(2);;

			}
		}
		return matriz;
	}

	public static void print (int [][] a) {
		for (int i = 0; i<a.length; i++) {
			
			for (int j = 0; j<a.length; j++) {
				System.out.print(Integer.toString(a[i][j]) + " ");

			}
			System.out.println();
		}
	}

	public static void buscarVecinas(int [][] a, int x, int y) {



	}
}