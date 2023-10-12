import java.util.Scanner;

public class M73Ex1_ArnauBurguera {
	
	static float area = 0f;
	static final float PI = 3.14159f;

	public static void main(String[] args) {
		
		int opcio = 0;
		int altura = 0;
		int amplada = 0;
		int radi = 0;
		//float area = 0f;
		boolean surtProgram = false;
		String poligon = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Tria una de les següents opcions:\r\n"
				+ "1.- Quadrat\r\n"
				+ "2.- Triangle\r\n"
				+ "3.- Rectangle\r\n"
				+ "4.- Cercle\r\n"
				+ "0.- Sortir del programa\r\n"
				+ "Elecció: ");
		opcio = sc.nextInt();
		
		switch(opcio) {
		case 1:
			poligon = "quadrat";
			System.out.print("Introdueix l'alçada del " + poligon + ": ");
			altura = sc.nextInt();
			System.out.print("Introdueix l'amplada del " + poligon + ": ");
			amplada = sc.nextInt();
			quadrat(altura,amplada);
			break;
		case 2:
			poligon = "tringle";
			System.out.print("Introdueix l'alçada del " + poligon + ": ");
			altura = sc.nextInt();
			System.out.print("Introdueix l'amplada del " + poligon + ": ");
			amplada = sc.nextInt();
			triangle(altura,amplada);
			break;
		case 3:
			poligon = "rectangle";
			System.out.print("Introdueix l'alçada del " + poligon + ": ");
			altura = sc.nextInt();
			System.out.print("Introdueix l'amplada del " + poligon + ": ");
			amplada = sc.nextInt();
			rectangle(altura,amplada);
			break;
		case 4:
			poligon = "cercle";
			System.out.print("Introdueix el radi del " + poligon + ": ");
			radi = sc.nextInt();
			cercle(radi);
			break;
		case 0:
			surtProgram = true;
			break;
		default:
			surtProgram = true;
			System.out.print("El nombre introduit no és correcte. ");
		}
		
		if(surtProgram) {
			System.out.print("A reveure!");
		}else {
			System.out.print("L'area del " + poligon + " és de " + area + " unitats.");
		}	
	}
	
	public static float quadrat(int altura, int amplada) {
		return area = altura * amplada;
	}
	
	public static float triangle(int altura, int amplada) {
		return area = (altura * amplada) / 2;
	}
	
	public static float rectangle(int altura, int amplada) {
		return area = altura * amplada;
	}
	
	public static float cercle(int radi) {
		return area = PI * (radi * radi);
	}
	
	

}
