

import java.util.Random;
import java.util.ArrayList;

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
		ArrayList <point> vecinos = buscarVecinas(b,0,0,-1,-1);
		avanzar();
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

	public static ArrayList <point> buscarVecinas(int [][] a, int x, int y, int xA,int yA) {

		ArrayList <point> vecinos = new ArrayList <point>();

		int length = a.length;

		if (y-1 != yA && y-1 >= 0 && a[x][y-1] == 0 ) {
			vecinos.add(new point(x,y-1));
		}
		if (x+1 != xA && y-1 != yA && x+1 <length && y-1 >=0 && a[x+1][y-1] == 0) {
			vecinos.add(new point(x+1,y-1));
		}
		if (x+1 != xA && x+1 <length && a[x+1][y] == 0) {
			vecinos.add(new point(x+1,y));
		}
		if (x+1 != xA && y+1 != yA && x+1 <length && y+1 <length && a[x+1][y+1] == 0) {
			vecinos.add(new point(x+1,y+1));
		}
		if (y+1 != yA && y+1 <length && a[x][y+1] == 0) {
			vecinos.add(new point(x,y+1));
		}
		if (x-1 != xA && y+1 != yA && x-1 >=0 && y+1 <length && a[x-1][y+1] == 0) {
			vecinos.add(new point(x-1,y+1));
		}
		if (x-1 != xA && x-1 >=0 && a[x-1][y] == 0) {
			vecinos.add(new point(x-1,y));
		}
		if (x-1 != xA && y-1 != yA && x-1 >=0 && y-1 >= 0 && a[x-1][y-1] == 0) {
			vecinos.add(new point(x-1,y-1));
		}

		return vecinos;

	}

	public static boolean avanzar(int [][] a,int x,int y,ArrayList <point> vecinos) {

		for(point p : vecinos) {
			avanzar(a,p.getX(),p.getY());
		}
	}

}
