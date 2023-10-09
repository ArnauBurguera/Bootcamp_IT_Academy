import java.util.ArrayList;
import java.util.Scanner;

public class M8Ex3_ArnauBurguera {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Client> clients = new ArrayList<Client>();

	public static void main(String[] args) {
		
		int opcio = -1;
		int numCompte = 0;
		int quantitat = 0;
		Compte compteActual = null;
		
		do {
			System.out.println("GESTOR BANCARI:\n"
					+ "0.Sortir de l'aplicació\n"
					+ "1.Crear client/a\n"
					+ "2.Eliminar client/a\n"
					+ "3.Crear compta d'un/a client/a\n"
					+ "4.Ingressar euros en un compte d'un client/a\n"
					+ "5.Retirar euros en un compte d'un client/a");
			
			opcio = sc.nextInt();
			
			while(opcio < 0 || opcio > 5) {
				System.out.print("El nombre introduït no és correcte.\nTorna-ho a intentar: ");
				opcio = sc.nextInt();
			}
			
			switch(opcio) {
			case 1:
				crearClient();
				break;
			case 2:
				eliminarClient();
				break;
			case 3:
				crearCompte();
				break;
			case 4:
				compteActual = buscadorCompteDeClient("ingressar");
				if(compteActual != null) {
					System.out.print("Quina quantitat vols ingressar? ");
					quantitat = sc.nextInt();
					compteActual.ingresar(quantitat);
					System.out.print("Balanç: " + compteActual.getSaldo() + "\n");
				}
				break;
			case 5:
				compteActual = buscadorCompteDeClient("retirar");
				if(compteActual != null) {
					System.out.print("Quina quantitat vols retirar? ");
					quantitat = sc.nextInt();
					compteActual.retirar(quantitat);
					System.out.print("Balanç: " + compteActual.getSaldo() + "\n");
					break;
				}
			}
			
		} while(opcio > 0);
		
		System.out.print("A reveure!");	

	}
	
	public static void crearClient() {
		
		String nom = "";
		String cognom = "";
		
		System.out.print("CREANT USUARI:\nIntrodueix el nom del usuari: ");
		sc.nextLine();
		nom = sc.nextLine();
		System.out.print("Cognom: ");
		cognom = sc.nextLine();
		
		Client nouClient = new Client(nom,cognom);
		clients.add(nouClient);
		
		System.out.println("El client " + nom + " " + cognom + " s'ha enregistrat correctament!\n");
	}
	
	public static void eliminarClient() {
		
		String nom = "";
		String cognom = "";
		int posicio = -1;
		
		if(clients.size() == 0) {
			System.out.println("No hi ha cap client enregistrat a l'aplicació.\n");
		}else {
			System.out.println("Escriu el nom i cognom del client que vols eliminar del següent llistat: ");
			
			for (int i = 0; i < clients.size(); i++) {
				System.out.println("-" + clients.get(i).getNom() + " " + clients.get(i).getCognom());
			}
			
			System.out.print("Nom: ");
			sc.nextLine();
			nom = sc.nextLine();
			System.out.print("Cognom: ");
			cognom = sc.nextLine();
			
			posicio = buscadorClient(nom,cognom);
					
			if(posicio >= 0) {
				clients.remove(posicio);
				System.out.println("El client " + nom + " " + cognom + " ha estat donat de baixa correctament.");
			}
		}
		
	}
	
	public static void crearCompte() {
		
		String nom = "";
		String cognom = "";
		int numCompte = 0;
		int posicio = -1;
		Compte novaCompta = null;
		
		if(clients.size() == 0) {
			System.out.println("No hi ha cap client enregistrat a l'aplicació. No es pot crear cap compte.\n");
		}else {
			System.out.println("Escriu el nom i cognom del client a qui li vols assignar el compte del següent llistat: ");
			
			for (int i = 0; i < clients.size(); i++) {
				System.out.println("-" + clients.get(i).getNom() + " " + clients.get(i).getCognom());
			}
			
			System.out.print("Nom: ");
			sc.nextLine();
			nom = sc.nextLine();
			System.out.print("Cognom: ");
			cognom = sc.nextLine();
			
			posicio = buscadorClient(nom,cognom);
			
			if(posicio >= 0) {
				
				System.out.print("CREANT COMPTE:\nIntrodueix el numero de compte a crear: ");
				numCompte = sc.nextInt();
				
				novaCompta = new Compte(numCompte);
				
				clients.get(posicio).addCompte(novaCompta);
				
				System.out.println("La compta " + numCompte + " per al client " + nom + " " + cognom + " ha estat creada correctament.");
			}
		}
	}
	
	public static int buscadorClient(String nom, String cognom) {
		
		int cicles = 0;
		int posicio = -1;
	
			do {
				 if((clients.get(cicles).getNom().equalsIgnoreCase(nom)) && (clients.get(cicles).getCognom().equalsIgnoreCase(cognom))) {
					posicio = cicles;
					cicles = clients.size();
				}else if((cicles == (clients.size() - 1)) && (clients.size() >= 1)) {
					System.out.println(nom + " " + cognom + " no consta a l'aplicació.\nTorna-ho a intentar: ");
					System.out.print("Nom: ");
					sc.nextLine();
					nom = sc.nextLine();
					System.out.print("Cognom: ");
					cognom = sc.nextLine();
					cicles = - 1;
				}
				cicles++;
			} while(cicles < clients.size());
		return posicio;
	}
	
	public static Compte buscadorCompteDeClient(String accio) {
		
		int opcio = -1;
		String nom = "";
		String cognom = "";
		int posicio = -1;
		int posicioCompte = -1;
		int numCompte = 0;
		int cicles = 0;
		Compte trobada = null;
		
		if(clients.size() == 0) {
				System.out.println("No hi ha cap client enregistrat a l'aplicació. No es poden " + accio + " diners\n");
			}else {
				System.out.println("Escriu el nom i cognom del client que ha de " + accio + " del següent llistat: ");
					
				for (int i = 0; i < clients.size(); i++) {
					System.out.println("-" + clients.get(i).getNom() + " " + clients.get(i).getCognom());
				}
					
				System.out.print("Nom: ");
				sc.nextLine();
				nom = sc.nextLine();
				System.out.print("Cognom: ");
				cognom = sc.nextLine();
					
				posicio = buscadorClient(nom,cognom);
				
					
				if(clients.get(posicio).getComptes().size() == 0) {
						
					System.out.println("El client no té cap compte obert al seu nom. No es poden " + accio + " diners\n");
						
				}else {
					Client clientTrobat = clients.get(posicio);	
					System.out.println("Introdueix el número del compte al que vols " + accio + " diners del segürnt llistat\n");
						
					for (int i = 0; i < clientTrobat.getComptes().size(); i++) {
						System.out.println("- " + clientTrobat.getComptes().get(i).getNumCompte());///////////////////////////////////////
							
					}
						
					numCompte = sc.nextInt();
						
					do {
						 if(clientTrobat.getComptes().get(cicles).getNumCompte() == numCompte) {
								 
							posicioCompte = cicles;
							trobada = clientTrobat.getComptes().get(posicioCompte);
							cicles = clientTrobat.getComptes().size();
								
						}else if((cicles == (clientTrobat.getComptes().size() - 1)) && (clientTrobat.getComptes().size() >= 1)) {
								
							System.out.println("El compte " + numCompte + " no consta a l'aplicació.\nTorna-ho a intentar: ");
							System.out.print("Número de compte: ");
							numCompte = sc.nextInt();
							cicles = - 1;
						}
						cicles++;
					} while(cicles < clients.get(posicio).getComptes().size());
				}
			}
		return trobada;
	}

}
