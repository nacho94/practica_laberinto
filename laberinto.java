

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

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

		char [][] b = pedirEntrada();
		print(b);
		ArrayList <point> vecinos = buscarVecinas(b,0,0,-1,-1);
		//avanzar();
	}

	public static char [][] pedirEntrada () {

		Scanner scan = new Scanner (System.in);
		
		ArrayList <String> entrada = new ArrayList <String>();
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			String cadena=scan.next();
			entrada.add(i,cadena);
		}
		
		System.out.println(entrada);

		char [][] matriz = new char [n][n];

		matriz=inicializar(entrada,n);
		
		print(matriz);

		return matriz;

	}

	public static char [][] inicializar(ArrayList <String> a ,int n) {

		char [][] matriz = new char [n][n];

		for (int i=0;i<n; i++) {

			String linea = a.get(i);

			System.out.println(linea.length());
			for (int j=0; j<linea.length(); j++) {
				
				
				matriz[i][j]=linea.charAt(j);
			}
		}
		return matriz;
	}

	public static void print (char [][] a) {
		for (int i = 0; i<a.length; i++) {
			
			for (int j = 0; j<a.length; j++) {
				System.out.print(Integer.toString(a[i][j]) + " ");

			}
			System.out.println();
		}
	}

	public static ArrayList <point> buscarVecinas(char [][] a, int x, int y, int xA,int yA) {

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

	public static boolean avanzar(char [][] a,int x,int y,ArrayList <point> vecinos) {

		for(point p : vecinos) {
			//avanzar(a,p.getX(),p.getY());
		}
		return false;
	}

}
