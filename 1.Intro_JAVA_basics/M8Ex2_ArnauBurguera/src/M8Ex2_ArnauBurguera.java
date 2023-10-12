import java.util.ArrayList;
import java.util.Scanner;

public class M8Ex2_ArnauBurguera {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Hotel> arrayHotels = new ArrayList<Hotel>();

	public static void main(String[] args) {
		
		int opcio = -1;
		
		do {
			System.out.println("GESTOR D'HOTELS:\n"
					+ "1.Crear hotel\n"
					+ "2.Veure hotel\n"
					+ "3.Modificar hotel\n"
					+ "4.Donar de baixa hotel\n"
					+ "0.Sortir de l'aplicació");
			opcio = sc.nextInt();
			
			while(opcio < 0 || opcio > 4) {
				System.out.print("El nombre introduït no és correcte\n.Torna-ho a intentar: ");
				opcio = sc.nextInt();
			}
			
			switch(opcio) {
			case 1:
				crearHotel();
				break;
			case 2:
				veureHotel();
				break;
			case 3:
				modificarHotel();
				break;
			case 4:
				donarDeBaixaHotel();
				break;
			}
			
		} while(opcio > 0);
		
		System.out.print("A reveure!");	
	}

	public static void crearHotel() {

		String nom = "";
		int habitacions = 0;
		int plantes = 0;
		float superficie = 0f;

		System.out.print("CREANT HOTEL:\nIntrodueix el nom del Hotel a crear: ");
		sc.nextLine();
		nom = sc.nextLine();
		System.out.print("Introdueix el nombre d'habitacions: ");
		habitacions = sc.nextInt();
		System.out.print("Introdueix el nombre de plantes: ");
		plantes = sc.nextInt();
		System.out.print("Introdueix la superfície en metres quadrats: ");
		superficie = sc.nextFloat();

		Hotel nouHotel = new Hotel(nom, habitacions, plantes, superficie);
		arrayHotels.add(nouHotel);
		
		System.out.println("L'hotel " + nom + " s'ha creat correctament!\n");	
	}

	public static void donarDeBaixaHotel() {
		
		int posicio = -1;
		String hotelNom = "";
		final String ACCIO = " que vols donar de baixa";
		
		posicio = buscador(ACCIO);
		
		if(posicio >= 0) {
			hotelNom = arrayHotels.get(posicio).getNom();
			arrayHotels.remove(posicio);
			System.out.println("L'hotel " + hotelNom + " ha estat donat de baixa correctament.");
		}
	}

	public static void veureHotel() {
		
		int posicio = -1;
		final String ACCIO = " del que en vols rebre la informació";
		
		posicio = buscador(ACCIO);
		
		if(posicio >= 0) {
			System.out.println(arrayHotels.get(posicio).toString());
			System.out.println(arrayHotels.get(posicio).calcularManteniment() + "\n");
		}
	}

	public static void modificarHotel() {

		int habitacions = 0;
		int plantes = 0;
		int superficie = 0;
		int opcio = 0;
		int posicio = -1;
		final String ACCIO = " del qual en vols moificar la informació";
		boolean finalModificacio = false;
		
		posicio = buscador(ACCIO);
		
		do {
				
			if(posicio >= 0) {
				System.out.println("Indica amb el nombre corresponent si vols modificar:\n" 
							+ "1.Habitacions\n" 
							+ "2.Plantes\n"
							+ "3.Superfície total\n"
							+ "4.Sortir de la modificació");
				opcio = sc.nextInt();

				while (opcio < 1 || opcio > 4) {
					System.out.print("El nombre introduit és invàlid.\nTorna-ho a intentar: ");
					opcio = sc.nextInt();
				}
				
				switch (opcio) {
				case 1:
					System.out.print("Introdueix el nombre d'habitacions: ");
					habitacions = sc.nextInt();
					arrayHotels.get(posicio).setHabitacions(habitacions);
					break;
				case 2:
					System.out.print("Introdueix el nombre de plantes: ");
					plantes = sc.nextInt();
					arrayHotels.get(posicio).setPlantes(plantes);
					break;
				case 3:
					System.out.print("Introdueix la superfície en metres quadrats: ");
					superficie = sc.nextInt();
					arrayHotels.get(posicio).setSuperficie(superficie);
					break;
				case 4:
					finalModificacio = true;
					break;
				}
				
				System.out.print("\n");
			}
				
		}while(!finalModificacio && (posicio != -1));
	}
	
	public static int buscador(String accio) {
		
		int cicles = 0;
		int posicio = -1;
		String nom = "";
		
		if(arrayHotels.size() == 0) {
			System.out.println("No hi ha cap hotel enregistrat a l'aplicació.\n");
		}else {
			System.out.println("Escriu el nom del hotel" + accio + " del següent llistat: ");
			
			for (int i = 0; i < arrayHotels.size(); i++) {
				System.out.println("-" + arrayHotels.get(i).getNom());
			}
			
			sc.nextLine();
			nom = sc.nextLine();
			
			do {
				 if(arrayHotels.get(cicles).getNom().equalsIgnoreCase(nom)) {
					posicio = cicles;
					cicles = arrayHotels.size();
				}else if((cicles == (arrayHotels.size() - 1)) && (arrayHotels.size() >= 1)) {
					System.out.println(nom + " no consta a l'aplicació.\nTorna-ho a intentar: ");
					nom = sc.nextLine();
					cicles = - 1;
				}
				cicles++;
			} while(cicles < arrayHotels.size());
		}
		return posicio;
	}
}