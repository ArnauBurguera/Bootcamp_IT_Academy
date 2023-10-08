package n3exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_Redaccio {

	static ArrayList<Redactor> redactors = new ArrayList<Redactor>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcio = -1;
		int punts = 0;
		float preu = 0f;
		String nom = "";
		String dni = "";
		String titular;
		String competicio;
		String club;
		String jugador;
		String tenistes;
		String escuderia;
		String equip;
		
		//Proves
		
		redactors.add(new Redactor("Clara", "4636237T"));

		do {
			System.out.println("GESTOR DE NOTÍCIES:\n"
					+ "0.Sortir de l'aplicació\n"
					+ "1.Introduir redactor/a\n"
					+ "2.Eliminar redactor/a\n"
					+ "3.Introduir notícia a un redactor/a\n"
					+ "4.Eliminar notícia\n"
					+ "5.Mostrar totes les notícies per redactor/a\n"
					+ "6.Calcular puntuació de la notícia\n"
					+ "7.Calcular preu-notícia");

			opcio = sc.nextInt();

			while(opcio < 0 || opcio > 7) {
				System.out.print("El nombre introduït no és correcte.\nTorna-ho a intentar: ");
				opcio = sc.nextInt();
			}

			switch(opcio) {
			case 1:

				System.out.print("Nom: ");
				sc.nextLine();
				nom = sc.nextLine();
				System.out.print("DNI: ");
				dni = sc.nextLine();

				Redactor redactorNou = new Redactor(nom,dni);
				redactors.add(redactorNou);
				System.out.println("El/La redactor/a " + nom + " s'ha introduït correctament.\n");

				break;
			case 2:
				System.out.println("Tria el redactor/a a eliminar: ");
				for(Redactor redactor : redactors) {
					System.out.println("- " + redactor.getNom());
				}
				System.out.print("\nNom: ");
				sc.nextLine();
				nom = sc.nextLine();
				if(posicioLlistaRedactors(nom) != -1) {
					redactors.remove(posicioLlistaRedactors(nom));
					System.out.println("El redactor/a " + nom + " s'ha eliminat correctament.\n");
				}else {
					System.out.println("No hi ha cap " + nom + " a la llista.\n");
				}
				break;
			case 3:
				System.out.println("Tria el redactor/a a qui li vols assignar la notícia: ");

				for(Redactor redactor : redactors) {
					System.out.println("- " + redactor.getNom());
				}
				System.out.print("\nNom: ");
				sc.nextLine();
				nom = sc.nextLine();

				if(posicioLlistaRedactors(nom) != -1) {
					System.out.println("Tria una opció: \n"
							+ "1.Futbol\n"
							+ "2.Bàsquet\n"
							+ "3.Tenis\n"
							+ "4.F1\n"
							+ "5.Motociclisme\n"
							+ "Opcio:");
					opcio = sc.nextInt();

					switch(opcio) {
					case 1:
						System.out.println("Titular: ");
						sc.nextLine();
						titular = sc.nextLine();
						System.out.println("Competició: ");
						competicio = sc.nextLine();
						System.out.println("Club: ");
						club = sc.nextLine();
						System.out.println("Jugador: ");
						jugador = sc.nextLine();
						redactors.get(posicioLlistaRedactors(nom)).addNoticia(new Futbol(titular,competicio,club,jugador));
						System.out.println("La notícia s'ha assignat correctament.\n");
						break;
					case 2:
						System.out.println("Titular: ");
						sc.nextLine();
						titular = sc.nextLine();
						System.out.println("Competició: ");
						competicio = sc.nextLine();
						System.out.println("Club: ");
						club = sc.nextLine();
						redactors.get(posicioLlistaRedactors(nom)).addNoticia(new Basquet(titular,competicio,club));
						System.out.println("La notícia s'ha assignat correctament.\n");
						break;
					case 3:
						System.out.println("Titular: ");
						sc.nextLine();
						titular = sc.nextLine();
						System.out.println("Competicios: ");
						competicio = sc.nextLine();
						System.out.println("Tenistes: ");
						tenistes = sc.nextLine();
						redactors.get(posicioLlistaRedactors(nom)).addNoticia(new Tenis(titular,competicio,tenistes));
						System.out.println("La notícia s'ha assignat correctament.\n");
						break;
					case 4:
						System.out.println("Titular: ");
						sc.nextLine();
						titular = sc.nextLine();
						System.out.println("Escuderia: ");
						escuderia = sc.nextLine();
						redactors.get(posicioLlistaRedactors(nom)).addNoticia(new F1(titular,escuderia));
						System.out.println("La notícia s'ha assignat correctament.\n");
						break;
					case 5:
						System.out.println("Titular: ");
						sc.nextLine();
						titular = sc.nextLine();
						System.out.println("Equip: ");
						equip = sc.nextLine();
						redactors.get(posicioLlistaRedactors(nom)).addNoticia(new Motociclisme(titular,equip));
						System.out.println("La notícia s'ha assignat correctament.\n");
						break;
					}


				}else {
					System.out.println("No hi ha cap " + nom + " a la llista.\n");
				}

				break;
			case 4:
				System.out.println("Tria el redactor/a a qui li vols eliminar la notícia: ");

				for(Redactor redactor : redactors) {
					System.out.println("- " + redactor.getNom());
				}
				System.out.print("\nNom: ");
				sc.nextLine();
				nom = sc.nextLine();

				if(posicioLlistaRedactors(nom) != -1) {
					
					System.out.println("\nAra tria la notícia: ");
					for(Noticia noticia : redactors.get(posicioLlistaRedactors(nom)).getNoticies()) {
						System.out.println("- " + noticia.getTitular());
					}
					System.out.println("Notícia: ");
					titular = sc.nextLine();
					
					if(posicioLlistaNoticies(nom,titular) != -1) {
						redactors.get(posicioLlistaRedactors(nom)).removeNoticia(posicioLlistaNoticies(nom,titular));
						System.out.println("La notícia s'ha eliminat correctament.\n");
					}else {
						System.out.println("No hi ha cap notícia amb aquest titular.\n");
					}
				}else {
					System.out.println("No hi ha cap " + nom + " a la llista.\n");
				}
				break;
			case 5:
				System.out.println("Tria el redactor/a de quin en vols veure les notícies: ");

				for(Redactor redactor : redactors) {
					System.out.println("- " + redactor.getNom());
				}
				System.out.print("\nNom: ");
				sc.nextLine();
				nom = sc.nextLine();

				if(posicioLlistaRedactors(nom) != -1) {
					
					System.out.println("Noticies del redactor/a " + nom + ": ");
					for(Noticia noticia : redactors.get(posicioLlistaRedactors(nom)).getNoticies()) {
						System.out.println("- " + noticia.getTitular());
					}
					System.out.println("");
				}else {
					System.out.println("No hi ha cap " + nom + " a la llista.\n");
				}

				break;
			case 6:
				System.out.println("Tria el redactor/a: ");

				for(Redactor redactor : redactors) {
					System.out.println("- " + redactor.getNom());
				}
				System.out.print("\nNom: ");
				sc.nextLine();
				nom = sc.nextLine();

				if(posicioLlistaRedactors(nom) != -1) {
					
					System.out.println("\nAra tria la notícia de la qual en vols veure la puntuació: ");
					for(Noticia noticia : redactors.get(posicioLlistaRedactors(nom)).getNoticies()) {
						System.out.println("- " + noticia.getTitular());
					}
					System.out.println("Titular: ");
					titular = sc.nextLine();
					
					if(posicioLlistaNoticies(nom,titular) != -1) {
						punts = redactors.get(posicioLlistaRedactors(nom)).getNoticies().get(posicioLlistaNoticies(nom,titular)).calcularPunts();
						System.out.println("La notícia amb el titular \"" + titular + "\" té " + punts + " punts.\n");
					}else {
						System.out.println("No hi ha cap notícia amb aquest titular.\n");
					}
				}else {
					System.out.println("No hi ha cap " + nom + " a la llista.\n");
				}
				break;
			case 7:
				System.out.println("Tria el redactor/a: ");

				for(Redactor redactor : redactors) {
					System.out.println("- " + redactor.getNom());
				}
				System.out.print("\nNom: ");
				sc.nextLine();
				nom = sc.nextLine();

				if(posicioLlistaRedactors(nom) != -1) {
					
					System.out.println("\nAra tria la notícia de la qual en vols calcular el preu: ");
					for(Noticia noticia : redactors.get(posicioLlistaRedactors(nom)).getNoticies()) {
						System.out.println("- " + noticia.getTitular());
					}
					System.out.println("Titular: ");
					titular = sc.nextLine();
					
					if(posicioLlistaNoticies(nom,titular) != -1) {
						preu = redactors.get(posicioLlistaRedactors(nom)).getNoticies().get(posicioLlistaNoticies(nom,titular)).calcularPreuNoticia();
						System.out.println("La notícia amb el titular \"" + titular + "\" te un preu de " + preu + "€.\n");
					}else {
						System.out.println("No hi ha cap notícia amb aquest titular.\n");
					}
				}else {
					System.out.println("No hi ha cap " + nom + " a la llista.\n");
				}
				break;
			}

		} while(opcio > 0);

		System.out.print("A reveure!");
	}

	public static int posicioLlistaRedactors(String nom) {
		int i = 0, posicio = -1;

		while(i < redactors.size()) {
			if(redactors.get(i).getNom().equalsIgnoreCase(nom)) {
				posicio = i;
				i = redactors.size();
			}
			i++;
		}
		return posicio;
	} 
	
	public static int posicioLlistaNoticies(String nom, String titular) {
		int i = 0, posicio = -1;

		while(i < redactors.get(posicioLlistaRedactors(nom)).getNoticies().size()) {
			if(redactors.get(posicioLlistaRedactors(nom)).getNoticies().get(i).getTitular().equalsIgnoreCase(titular)) {
				posicio = i;
				i = redactors.get(posicioLlistaRedactors(nom)).getNoticies().size();
			}
			i++;
		}
		return posicio;
	} 

}
