package s1t3n1ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class S1T3n1ex3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int puntuacio = 0;
		String nom = "";
		String pais = "";
		String[] countriesList = null;
		Map<String, String> countriesAndCapitals = new HashMap<>();

		LlegirFitxer acces = new LlegirFitxer();
		EscriureFitxer write = new EscriureFitxer();

		countriesAndCapitals = acces.dataToHashMap();

		if(!countriesAndCapitals.isEmpty()) {
			countriesList = acces.returnArrayCountries();
			nom = demanarNom();
			puntuacio = rondaPreguntes(countriesList,countriesAndCapitals);
			System.out.println(nom + ", la teva puntuació final és de " + puntuacio + "/10!");
			write.escriure(nom,puntuacio);	
		}
	}

	public static String demanarNom() {
		String nom = "";

		System.out.print("Introdueix el teu nom: ");
		nom = sc.nextLine();

		return nom;
	}
	
	public static String demanarCapital(String pais, int contador) {
		String capital = "";
		
		System.out.print(contador + ".País:  " + pais + "\nCapital: ");
		capital = sc.nextLine();
		
		return capital;
	}
	
	public static int rondaPreguntes(String[] countriesList, Map<String, String> countriesAndCapitals) {
		int puntuacio = 0;
		int contador = 1;
		String pais = "";
		
		for(int i = 0; i < 10; i++) {
			pais = countriesList[(int)(Math.random()*(countriesList.length))];
			if(countriesAndCapitals.get(pais).equalsIgnoreCase(demanarCapital(pais,contador))) {
				puntuacio++;
				System.out.println("Encertada! " + puntuacio + "/10 punts.\n");	
			}else {
				System.out.println("La capital de " + pais + " és " +  countriesAndCapitals.get(pais) 
				+ ". " + puntuacio + "/10 punts.\n");
			}
			contador++;
		}
		return puntuacio;
	}
}
