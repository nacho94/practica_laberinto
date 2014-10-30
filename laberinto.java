

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


	}

	public static int [][] pedirEntrada () {

		int n = 5;
		int [][] matriz = new int [n][];

		for (int i = 0; i<n; i++) {
			matriz [i] = new int [n];

		}
		return matriz;
	}
}