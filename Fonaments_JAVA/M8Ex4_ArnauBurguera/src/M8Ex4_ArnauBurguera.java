import java.util.ArrayList;
import java.util.Scanner;

public class M8Ex4_ArnauBurguera {
	
	static ArrayList<Edifici> edificis = new ArrayList<Edifici>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int opcio = -1;
		
		do {
			System.out.println("GESTOR D'EDIFICIS:\n"
					+ "0.Sortir de l'aplicació\n"
					+ "1.Donar d'alta edifici/a\n"
					+ "2.Mostrar edifici\n"
					+ "3.Donar de baixa edifici.");
			
			opcio = sc.nextInt();
			
			while(opcio < 0 || opcio > 3) {
				System.out.print("El nombre introduït no és correcte.\nTorna-ho a intentar: ");
				opcio = sc.nextInt();
			}
			
			switch(opcio) {
			case 1:
				donarAlta();
				break;
			case 2:
				mostrarEdifici();
				break;
			case 3:
				donarBaixa();
				break;
			}
			
		} while(opcio > 0);
		
		System.out.print("A reveure!");
	}
	
	public static void donarAlta() {
		
		int opcio = 0;
		
		System.out.println("Introdueix el nombre del edifici que vols donar d'alta del següent llistat:\n"
				+ "1.Cinema\n"
				+ "2.Hospiatl\n"
				+ "3.Hotel");
		opcio = sc.nextInt();
		crear(opcio);
		
	}
	
	public static void donarBaixa() {
		
		String nom = "";
		Edifici edificacio = null;
		
		System.out.println("Escriu el nom del edifici que vols donar de baixa del següent llistat:");
		
		for(Edifici edifici : edificis) {
			System.out.println("-" + edifici);
		}
		sc.nextLine();
		nom = sc.nextLine();
		
		edificacio = buscador(nom);
		
		while(edificacio == null) {
			System.out.print("L'edifici" + nom + " no consta a la llista.\nTorna-ho a intentar:");
			nom = sc.nextLine();
			edificacio = buscador(nom);
		}
		edificis.remove(edificacio);
		System.out.println("L'edifici s'ha donat de baixa correctament!");
	}
	
	public static void mostrarEdifici() {
		
		String nom = "";
		Edifici edificacio = null;
		int numAsistents = 0;
		float preuEntrada = 0;
		
		System.out.println("Escriu el nom del edifici del que en vols veure la informació del següent llistat:");
		
		for(Edifici edifici : edificis) {
			System.out.println("-" + edifici.getNom());
		}
		sc.nextLine();
		nom = sc.nextLine();
		
		edificacio = buscador(nom);
		
		while(edificacio == null) {
			System.out.print("L'edifici" + nom + " no consta a la llista.\nTorna-ho a intentar:");
			nom = sc.nextLine();
			edificacio = buscador(nom);
		}
		
		edificacio.toString();
		System.out.println("El servei de neteja sumarà " + edificacio.netejar() + "€ al mes.");
		System.out.println("El cost de vigilància serà de " + edificacio.calcularCostVigilancia() + "€.");
		
		if(edificacio instanceof Cinema) {
			System.out.println("Com es tracta d'un cinema has d'introduir primer;\n"
					+ "Número d'assitents: ");
			numAsistents = sc.nextInt();
			System.out.println("I el preu de l'entrada és: ");
			preuEntrada = sc.nextInt();
			System.out.println(((Cinema) edificacio).projectarSessio(numAsistents, preuEntrada));
		}else if(edificacio instanceof Hospital) {
			System.out.println(((Hospital) edificacio).repartirDinar());
		}else if(edificacio instanceof Hotel) {
			System.out.println(((Hotel) edificacio).serveiHabitacions());
		}
	}
	
	public static void crear(int opcio) {
			
			String nom = "";
			int plantes = 0;
			float superficie = 0f;
			int aforament = 0;
			int malalts = 0;
			int habitacions = 0;
			
			System.out.print("Escriu el nom que tindrà: ");
			sc.nextLine();
			nom = sc.nextLine();
			System.out.print("Introdueix el nombre de plantes: ");
			plantes = sc.nextInt();
			System.out.print("Introdueix la superfície en metres quadrats: ");
			superficie = sc.nextFloat();
			
			switch(opcio) {
			case 1:
				System.out.print("Per últim, introdueix l'aforament màxim: ");
				aforament = sc.nextInt();
				Cinema nouCinema = new Cinema(nom,plantes,superficie,aforament);
				edificis.add(nouCinema);
				System.out.println("El cinema s'ha creat correctament!\n");
				break;
			case 2:
				System.out.print("Per últim, introdueix el nombre de mlalats ingressats actualment: ");
				malalts = sc.nextInt();
				Hospital nouHospital = new Hospital(nom,plantes,superficie,malalts);
				edificis.add(nouHospital);
				System.out.println("L'Hospital s'ha creat correctament!\n");
				break;
			case 3:
				System.out.print("Per últim, introdueix el nombre d'habitacions: ");
				habitacions = sc.nextInt();
				Hotel nouHotel = new Hotel(nom,plantes,superficie,habitacions);
				edificis.add(nouHotel);
				System.out.println("L'Hotel s'ha creat correctament!\n");
				break;
			}
		}

	
	public static Edifici buscador(String nom) {
		
		int i = 0;
		Edifici edifici = null;
		
		while(i < edificis.size()) {
			edifici = edificis.get(i);
			if(edifici.getNom().equalsIgnoreCase(nom)) {
				edifici = edificis.get(i);
				i = edificis.size();
			}
			i++;
		}
		return edifici;
	}
	

}
