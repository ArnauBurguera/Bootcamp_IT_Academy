package s1t3n3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S1T3n3 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Persona> llistaPersones = dataToArrayList();

	public static void main(String[] args) {

		iniciar();
		sc.close();

	}

	public static void iniciar() {
		int opcio = -1;

		do {
			opcio = menu();
			switch(opcio) {
			case 0:
				System.out.print("A reveure!");
				break;
			case 1:
				introduirPersona();
				break;
			case 2:
				orderarNomAZ();
				break;
			case 3:
				orderarNomZA();
				break;
			case 4:
				orderarCognomAZ();
				break;
			case 5:
				orderarCogomZA();
				break;
			case 6:
				orderarDni19();
				break;
			case 7:
				orderarDni91();
				break;
			}
		}while(opcio != 0);

	}

	public static int menu() {
		int opcio = -1;

		System.out.println("PROGRAMA:\n"
				+ "1.- Introduir persona\n"
				+ "2.- Mostrar les persones ordenades per nom (A-Z)\n"
				+ "3.- Mostrar les persones ordenades per nom (Z-A)\n"
				+ "4.- Mostrar les persones ordenades per cognoms (A-Z)\n"
				+ "5.- Mostrar les persones ordenades per cognoms (Z-A)\n"
				+ "6.- Mostrar les persones ordenades per DNI (1-9)\n"
				+ "7.- Mostrar les persones ordenades per DNI (9-1)\n"
				+ "0.- Sortir.");

		opcio = sc.nextInt();

		while(opcio < 0 || opcio > 7) {
			System.out.print("El nombre introduït no és correcte.\nTorna-ho a intentar: ");
			opcio = sc.nextInt();
		}
		return opcio;
	}

	public static void introduirPersona() {
		String nom = "";
		String cognoms = "";
		String dni = "";

		sc.nextLine();
		System.out.println("Introdueix el nom:");
		nom = sc.nextLine();
		System.out.println("Introdueix els cognoms:");
		cognoms = sc.nextLine();
		System.out.println("Introdueix el DNI:");
		dni = sc.next();

		llistaPersones.add((new Persona (nom,cognoms,dni)));
	}

	public static void orderarNomAZ() {
		ComparadorNoms comparador = new ComparadorNoms();
		Collections.sort(llistaPersones,comparador);

		for(Persona a : llistaPersones) {
			System.out.println(a.getNom());
		}
	}
	
	public static void orderarNomZA() {
		ComparadorNoms comparador = new ComparadorNoms();
		Collections.sort(llistaPersones,comparador);
		Collections.reverse(llistaPersones);

		for(Persona a : llistaPersones) {
			System.out.println(a.getNom());
		}
	}
	
	public static void orderarCognomAZ() {
		ComparadorCognoms comparador = new ComparadorCognoms();
		Collections.sort(llistaPersones,comparador);
		
		for(Persona a : llistaPersones) {
			System.out.println(a.getCognoms());
		}
	}
	
	public static void orderarCogomZA() {
		ComparadorCognoms comparador = new ComparadorCognoms();
		Collections.sort(llistaPersones,comparador);
		Collections.reverse(llistaPersones);

		for(Persona a : llistaPersones) {
			System.out.println(a.getCognoms());
		}
	}
	
	public static void orderarDni19() {
		ComparadorDni comparador = new ComparadorDni();
		Collections.sort(llistaPersones,comparador);
		
		for(Persona a : llistaPersones) {
			System.out.println(a.getDni());
		}
	}
	
	public static void orderarDni91() {
		ComparadorDni comparador = new ComparadorDni();
		Collections.sort(llistaPersones,comparador);
		Collections.reverse(llistaPersones);

		for(Persona a : llistaPersones) {
			System.out.println(a.getDni());
		}
	}

	public static ArrayList<Persona> dataToArrayList() {
		String linea = "";
		FileReader lector = null;
		BufferedReader buffer = null;
		String[] valors = null;
		ArrayList<Persona> llista = new ArrayList<Persona>();

		try {
			lector = new FileReader("Arxiu_Persones.csv");
			buffer = new BufferedReader(lector);
			buffer.readLine();
			linea = buffer.readLine();

			while(linea != null) {
				valors = linea.split(",");
				llista.add(new Persona(valors[0],valors[1],valors[2]));
				linea = buffer.readLine();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				lector.close();
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return llista;
	}
}
