

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
	public String toString() {
		return "point(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
	}
}


public class laberinto {


	public static void main (String [] args) {
		
		

		char [][] b = pedirEntrada();
		print(b);
		ArrayList <point> vecinos = buscarVecinas(b,0,0,-2,-2);
		imprimirpuntos(vecinos);
		if(avanzar(b,0,0,vecinos)) {
			System.out.println("SI");
		}else {
			System.out.println("NO");
		}
	}

	public static char [][] pedirEntrada () {

		Scanner scan = new Scanner (System.in);
		
		ArrayList <String> entrada = new ArrayList <String>();
		int n = scan.nextInt();
		
		for(int i=0; i<n; i++) {
			String cadena=scan.next();
			entrada.add(i,cadena);
		}
		
		

		char [][] matriz = new char [n][n];

		matriz=inicializar(entrada,n);
		

		return matriz;

	}

	public static char [][] inicializar(ArrayList <String> a ,int n) {

		char [][] matriz = new char [n][n];

		for (int i=0;i<n; i++) {

			String linea = a.get(i);

			for (int j=0; j<linea.length(); j++) {
				
				
				matriz[i][j]=(char)Integer.parseInt(linea.charAt(j) + "");
			}
		}
		return matriz;
	}

	public static void print (char [][] a) {
		for (int i = 0; i<a.length; i++) {
			
			for (int j = 0; j<a.length; j++) {
				System.out.print((a[i][j]) + " ");

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
		imprimirpuntos(vecinos);
		return vecinos;

	}

	public static boolean avanzar(char [][] a,int x,int y,ArrayList <point> vecinos) {

		d("avanzar: x=" + Integer.toString(x) + "  y=" + Integer.toString(y));

		int n = a.length;

		if(x==n-1 && y==n-1) {
			return true;
		}

		for(point p : vecinos) {
			boolean r = avanzar(a,p.getX(),p.getY(),buscarVecinas(a,p.getX(),p.getY(),x,y));
			if(r) {
				return true;
			}
		}
		return false;
	}

	private static void d(String msj) {
		System.out.println(msj);
	}

	private static void imprimirpuntos(ArrayList <point> a) {
		for(point p : a) {
			System.out.println(p);
		}
	}
}
