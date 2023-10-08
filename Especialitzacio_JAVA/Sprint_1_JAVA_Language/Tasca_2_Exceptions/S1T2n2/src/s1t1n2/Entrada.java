package s1t1n2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	static Scanner sc = new Scanner(System.in);

	public static byte llegirByte(String userPrompt) {
		byte edat = 0;
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				edat = sc.nextByte();
				error = false;
			}catch(InputMismatchException e) {
				System.out.println("Error de format. Torna a introduir l'edat:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return edat;
	}
	
	public static int llegirInt(String userPrompt) {
		int edat = 0;
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				edat = sc.nextInt();
				error = false;
			}catch(InputMismatchException e) {
				System.out.println("Error de format. Torna a introduir l'edat:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return edat;
	}
	
	public static float llegirFloat(String userPrompt) {
		float edat = 0f;
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				edat = sc.nextFloat();
				error = false;
			}catch(InputMismatchException e) {
				System.out.println("Error de format. Torna a introduir l'edat:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return edat;
	}
	
	public static double llegirDouble(String userPrompt) {
		double edat = 0d;
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				edat = sc.nextDouble();
				error = false;
			}catch(InputMismatchException e) {
				System.out.println("Error de format. Torna a introduir l'edat:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return edat;
	}
	
	/*No estic segur de si en els tres següents métodes haig de contemplar més enllà 
	 * del que ja he fet el cas de que l'usuari entri algo no desitjat, creant classes
	 * d'excepció propies per a cada cas, ja que no veig un escenari on l'usuari pugui
	 * introduir una dada que faci saltar l'excepció. Ho he deixat així perquè l'enunciat 
	 * diu explícitament que li hem de demanar a l'usuari la dada correcta sempre i quan 
	 * salti l'excepció.
	 */
	
	public static char llegirChar(String userPrompt) {
		char lletra = ' ';
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				lletra = sc.next().charAt(0);
				error = false;
			}catch(Exception e) {
				System.out.println("Error de format. Torna-ho a provar:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return lletra;
	}
	
	public static String llegirString(String userPrompt) {
		String string = "";
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				sc.nextLine();
				string = sc.nextLine();
				error = false;
			}catch(Exception e) {
				System.out.println("Error de format. Torna-ho a provar:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return string;
	}
	
	public static boolean llegirSiNo(String userPrompt) {
		String string = "";
		boolean resposta = false;
		boolean error = false;

		System.out.println(userPrompt);
		do{
			try {
				string = sc.nextLine();
				System.out.println(string);
				//Aquí és l'únic lloc on haig de fer un cribatge de dades com a tal, però sense excepció.
				while(!string.equalsIgnoreCase("s") && !string.equalsIgnoreCase("n")) {
					System.out.println("Has de respondre amb 's' o 'n'.\nTorna-ho a intentar:");
					string = sc.nextLine();
				}
				
				if(string.equalsIgnoreCase("s")) {
					resposta = true;
				}
				
				error = false;
			}catch(Exception e) {
				System.out.println("Error de format. Torna-ho a provar:");
				error = true;
				sc.nextLine();
			}
		}while(error);
		return resposta;
	}



}
