import java.util.ArrayList;
import java.util.Scanner;

public class M8Ex6_ArnauBurguera {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Escuderia> escuderies = new ArrayList<Escuderia>();

	public static void main(String[] args) {
		
		Escuderia escuderia = null;
		Cotxe cotxeTrobat = null;

		Escuderia escu1 = new Escuderia("escu1","Moldavia",5000);
		Escuderia escu2 = new Escuderia("escu2","Brasil",15000);
		Escuderia escu3 = new Escuderia("escu3","Tijuana-Méjico",25000);
		
		Cotxe cotxe1 = new Cotxe("BMW", "Blau", 120, 210,28000);
		Cotxe cotxe2 = new Cotxe("Mercedes-Benz", "Vermell", 170, 260,40000);
		
		escu1.addCotxe(null);
		
		escuderies.add(escu1);
		escuderies.add(escu2);
		escuderies.add(escu3);
		
		System.out.println(buscadorEscuderia("escu2"));
		
		escuderia = buscadorEscuderia("escu2");
		
		escuderia.addCotxe(cotxe1);
		escuderia.addCotxe(cotxe2);
		
		cotxeTrobat = escuderia.buscarCotxe("BMW", escuderia);
		
		System.out.println(cotxeTrobat);
		


	}

	public static void crearEscuderia() {

		String nom = "";
		String paisOrigen = "";
		float pressupost = 0f;

		System.out.print("Escriu el nom de la escuderia que vols crear: ");
		sc.nextLine();
		nom = sc.nextLine();
		System.out.print("El país d'origen: ");
		paisOrigen = sc.nextLine();
		System.out.print("I el pressupost amb el que compta: ");
		pressupost = sc.nextFloat();

		Escuderia novaEscuderia = new Escuderia(nom,paisOrigen,pressupost);
		escuderies.add(novaEscuderia);
	}

	public static void veureEscuderies() {

		for(Escuderia escuderia : escuderies) {
			System.out.println(escuderia);
		}
	}

	public static void veureInfoEscuderia(){

		String nomEscuderia = "";
		Escuderia escuderia = null;

		System.out.print("Escriu el nom de la escuderia de la que en vols veure la informació: ");
		nomEscuderia = sc.nextLine();

		escuderia = buscadorEscuderia(nomEscuderia);

		while(escuderia == null) {
			System.out.print("La escuderia introduida no existeix.\nTorna-ho a intentar: ");
			nomEscuderia = sc.nextLine();
			escuderia = buscadorEscuderia(nomEscuderia);
		}

		System.out.print(escuderia.toString());
	}

	public static void crearCotxe() {

		String model = "";
		String color = "";
		String nomEscuderia = "";
		float potencia = 0f;
		float velMax = 0f;
		float preuMercat = 0f;
		Escuderia escuderia = null;
		Cotxe cotxe = null;

		System.out.print("Escriu el model del cotxe: ");
		sc.nextLine();
		model = sc.nextLine();
		System.out.print("Quin és el color del cotxe?: ");
		color = sc.nextLine();
		System.out.print("Introdueix la seva potencia: ");
		potencia = sc.nextFloat();
		System.out.print("La seva velocitat màxima: ");
		velMax = sc.nextFloat();
		System.out.print("I el seu preu de mercat: ");
		preuMercat = sc.nextFloat();
		System.out.print("Escriu el nom de la escuderia al que pertany: ");
		nomEscuderia = sc.nextLine();

		escuderia = buscadorEscuderia(nomEscuderia);

		while(escuderia == null) {
			System.out.print("La escuderia introduida no existeix.\nTorna-ho a intentar: ");
			nomEscuderia = sc.nextLine();
			escuderia = buscadorEscuderia(nomEscuderia);
		}

		cotxe = new Cotxe(model,color,potencia,velMax,preuMercat);

		escuderia.addCotxe(cotxe);	
	}

	public static void donarAltaPilot() {

		String nom = "";
		String cognom = "";
		String nomEscuderia = "";
		int edat = 0;
		int antiguitat = 0;
		float alcada = 0f;
		float pes = 0f;
		Escuderia escuderia = null;
		Pilot nouPilot = null;


		System.out.print("Escriu el nom del pilot: ");
		sc.nextLine();
		nom = sc.nextLine();
		System.out.print("Ara escriu el cognom: ");
		cognom = sc.nextLine();
		System.out.print("Introdueix la seva edat: ");
		edat = sc.nextInt();
		System.out.print("Introdueix l'antiguitat: ");
		antiguitat = sc.nextInt();
		System.out.print("Alçada: ");
		alcada = sc.nextFloat();
		System.out.print("I el pes: ");
		pes = sc.nextFloat();
		System.out.print("Escriu el nom de la escuderia al que pertany: ");
		nomEscuderia = sc.nextLine();

		escuderia = buscadorEscuderia(nomEscuderia);

		while(escuderia == null) {
			System.out.print("La escuderia introduida no existeix.\nTorna-ho a intentar: ");
			nomEscuderia = sc.nextLine();
			escuderia = buscadorEscuderia(nomEscuderia);
		}

		nouPilot = new Pilot(nom,cognom,edat,antiguitat,alcada,pes);
		escuderia.addTreballador(nouPilot);

		System.out.print("El pilot " + nom + " " + cognom + " ha estat donat d'alta correctamanet.");
	}

	public static void donarBaixaPilot() {

		String nomPilot = "";
		String cognom = "";
		String nomICognom = "";
		String nomEscuderia = "";
		Escuderia escuderiaFound = null;
		Treballador pilotTrobat = null;

		System.out.print("Escriu el nom de la escuderia a la que pertany el pilot que vols donar de baixa:\nESCUDERIES:\n");

		for(Escuderia escuderia : escuderies) {
			System.out.println(escuderia);
		}

		System.out.print("Escuderia:");
		sc.nextLine();
		nomEscuderia = sc.nextLine();

		escuderiaFound = buscadorEscuderia(nomEscuderia);

		while(escuderiaFound == null) {
			System.out.print("No hi ha cap escuderia enregistrada amb aquest nom.\nTorna-ho a intentar: ");

			System.out.print("Escuderia:");
			nomEscuderia = sc.nextLine();

			escuderiaFound = buscadorEscuderia(nomEscuderia);
		}

		System.out.print("Escriu el nom del pilot que vols donar de baixa:\nPILOTS:\n");

		for(Treballador pilot : escuderiaFound.getTreballadors()) {
			System.out.println(pilot);
		}

		System.out.print("Nom: ");
		nomPilot = sc.nextLine();
		System.out.print("Ara introdueix el seu cognom: ");
		sc.nextLine();
		cognom = sc.nextLine();

		nomICognom = nomPilot + " " + cognom;

		pilotTrobat = buscadorTreballador(nomICognom,escuderiaFound);

		while(pilotTrobat == null) {
			System.out.print("No hi ha cap pilot enregistrat amb aquest nom.\nTorna-ho a intentar:\n");

			System.out.print("Nom: ");
			nomPilot = sc.nextLine();
			System.out.print("Ara introdueix el seu cognom: ");
			sc.nextLine();
			cognom = sc.nextLine();

			nomICognom = nomPilot + " " + cognom;

			pilotTrobat = buscadorTreballador(nomICognom,escuderiaFound);
		}

		escuderiaFound.removeTreballador(pilotTrobat);

		System.out.print("El pilot " + nomICognom + " ha estat donat de baixa correctamanet.");
	}

	public static void veurePilot() {

		String nomPilot = "";
		String cognom = "";
		String nomICognom = "";
		String nomEscuderia = "";
		Escuderia escuderiaFound = null;
		Treballador pilotTrobat = null;

		System.out.print("Escriu el nom de la escuderia a la que pertany el pilot "
				+ "del que en vols veure la informació:\nESCUDERIES:\n");

		for(Escuderia escuderia : escuderies) {
			System.out.println(escuderia);
		}

		System.out.print("Escuderia:");
		sc.nextLine();
		nomEscuderia = sc.nextLine();

		escuderiaFound = buscadorEscuderia(nomEscuderia);

		while(escuderiaFound == null) {
			System.out.print("No hi ha cap escuderia enregistrada amb aquest nom.\nTorna-ho a intentar: ");

			System.out.print("Escuderia:");
			nomEscuderia = sc.nextLine();

			escuderiaFound = buscadorEscuderia(nomEscuderia);
		}

		System.out.print("Escriu el nom del pilot del que en vols veure la informació:\nPILOTS:\n");

		for(Treballador pilot : escuderiaFound.getTreballadors()) {
			System.out.println(pilot);
		}

		System.out.print("Nom: ");
		nomPilot = sc.nextLine();
		System.out.print("Ara introdueix el seu cognom: ");
		sc.nextLine();
		cognom = sc.nextLine();

		nomICognom = nomPilot + " " + cognom;

		pilotTrobat = buscadorTreballador(nomICognom,escuderiaFound);

		while(pilotTrobat == null) {
			System.out.print("No hi ha cap pilot enregistrat amb aquest nom.\nTorna-ho a intentar:\n");

			System.out.print("Nom: ");
			nomPilot = sc.nextLine();
			System.out.print("Ara introdueix el seu cognom: ");
			sc.nextLine();
			cognom = sc.nextLine();

			nomICognom = nomPilot + " " + cognom;

			pilotTrobat = buscadorTreballador(nomICognom,escuderiaFound);
		}

		System.out.print(pilotTrobat.toString());
	}	

	public static void donarAltaMecanic() {

		String nom = "";
		String cognom = "";
		String nomEscuderia = "";
		String response = "";
		int edat = 0;
		int antiguitat = 0;
		boolean estudisSuperiors = false;
		Escuderia escuderia = null;
		Mecanic nouMecanic = null;


		System.out.print("Escriu el nom del mecànic: ");
		sc.nextLine();
		nom = sc.nextLine();
		System.out.print("Ara escriu el cognom: ");
		cognom = sc.nextLine();
		System.out.print("Introdueix la seva edat: ");
		edat = sc.nextInt();
		System.out.print("Introdueix l'antiguitat: ");
		antiguitat = sc.nextInt();
		System.out.print("Escriu el nom de la escuderia al que pertany: ");
		nomEscuderia = sc.nextLine();
		System.out.print("Ha cursat estudis superiors:\n");
		response = sc.next();

		estudisSuperiors = (response.equals("si")) ? true : false;

		escuderia = buscadorEscuderia(nomEscuderia);

		while(escuderia == null) {
			System.out.print("La escuderia introduida no existeix.\nTorna-ho a intentar: ");
			nomEscuderia = sc.nextLine();
			escuderia = buscadorEscuderia(nomEscuderia);
		}

		nouMecanic = new Mecanic(nom,cognom,edat,antiguitat,estudisSuperiors);
		escuderia.addTreballador(nouMecanic);

		System.out.print("El mecànic " + nom + " " + cognom + " ha estat donat d'alta correctamanet.");
	}

	public static void donarBaixaMecanic() {

		String nomMecanic = "";
		String cognom = "";
		String nomICognom = "";
		String nomEscuderia = "";
		Escuderia escuderiaFound = null;
		Treballador mecanicTrobat = null;

		System.out.print("Escriu el nom de la escuderia a la que pertany el mecànic que vols donar de baixa:\nESCUDERIES:\n");

		for(Escuderia escuderia : escuderies) {
			System.out.println(escuderia);
		}

		System.out.print("Escuderia:");
		sc.nextLine();
		nomEscuderia = sc.nextLine();

		escuderiaFound = buscadorEscuderia(nomEscuderia);

		while(escuderiaFound == null) {
			System.out.print("No hi ha cap escuderia enregistrada amb aquest nom.\nTorna-ho a intentar: ");

			System.out.print("Escuderia:");
			nomEscuderia = sc.nextLine();

			escuderiaFound = buscadorEscuderia(nomEscuderia);
		}

		System.out.print("Escriu el nom del mecànic que vols donar de baixa:\nMECÀNICS:\n");

		for(Treballador pilot : escuderiaFound.getTreballadors()) {
			System.out.println(pilot);
		}

		System.out.print("Nom: ");
		nomMecanic = sc.nextLine();
		System.out.print("Ara introdueix el seu cognom: ");
		sc.nextLine();
		cognom = sc.nextLine();

		nomICognom = nomMecanic + " " + cognom;

		mecanicTrobat = buscadorTreballador(nomICognom,escuderiaFound);

		while(mecanicTrobat == null) {
			System.out.print("No hi ha cap mecànic enregistrat amb aquest nom.\nTorna-ho a intentar:\n");

			System.out.print("Nom: ");
			nomMecanic = sc.nextLine();
			System.out.print("Ara introdueix el seu cognom: ");
			sc.nextLine();
			cognom = sc.nextLine();

			nomICognom = nomMecanic + " " + cognom;

			mecanicTrobat = buscadorTreballador(nomICognom,escuderiaFound);
		}

		escuderiaFound.removeTreballador(mecanicTrobat);

		System.out.print("El mecànic " + nomICognom + " ha estat donat de baixa correctamanet.");
	}

	public static void veureMecanic() {

		String nomMecanic = "";
		String cognom = "";
		String nomICognom = "";
		String nomEscuderia = "";
		Escuderia escuderiaFound = null;
		Treballador mecanicTrobat = null;

		System.out.print("Escriu el nom de la escuderia a la que pertany el mecànic "
				+ "del que en vols veure la informació:\nESCUDERIES:\n");

		for(Escuderia escuderia : escuderies) {
			System.out.println(escuderia);
		}

		System.out.print("Escuderia:");
		sc.nextLine();
		nomEscuderia = sc.nextLine();

		escuderiaFound = buscadorEscuderia(nomEscuderia);

		while(escuderiaFound == null) {
			System.out.print("No hi ha cap escuderia enregistrada amb aquest nom.\nTorna-ho a intentar: ");

			System.out.print("Escuderia:");
			nomEscuderia = sc.nextLine();

			escuderiaFound = buscadorEscuderia(nomEscuderia);
		}

		System.out.print("Escriu el nom del mecànic del que en vols veure la informació:\nMECÀNICS:\n");

		for(Treballador mecanic : escuderiaFound.getTreballadors()) {
			System.out.println(mecanic);
		}

		System.out.print("Nom: ");
		nomMecanic = sc.nextLine();
		System.out.print("Ara introdueix el seu cognom: ");
		sc.nextLine();
		cognom = sc.nextLine();

		nomICognom = nomMecanic + " " + cognom;

		mecanicTrobat = buscadorTreballador(nomICognom,escuderiaFound);

		while(mecanicTrobat == null) {
			System.out.print("No hi ha cap mecànic enregistrat amb aquest nom.\nTorna-ho a intentar:\n");

			System.out.print("Nom: ");
			nomMecanic = sc.nextLine();
			System.out.print("Ara introdueix el seu cognom: ");
			sc.nextLine();
			cognom = sc.nextLine();

			nomICognom = nomMecanic + " " + cognom;

			mecanicTrobat = buscadorTreballador(nomICognom,escuderiaFound);
		}
	}

	public static Escuderia buscadorEscuderia(String nom) {

		int i = 0;
		Escuderia escuderia = null;

		while(i < escuderies.size()) {
			escuderia = escuderies.get(i);
			if(escuderia.getNom().equalsIgnoreCase(nom)) {
				escuderia = escuderies.get(i);
				i = escuderies.size();
			}
			i++;
		}
		return escuderia;
	}

	

	public static Treballador buscadorTreballador(String nomICognom, Escuderia escuderia) {

		int i = 0;
		ArrayList<Treballador> llistaTreballadors = escuderia.getTreballadors();
		Treballador treballador = null;

		while(i < llistaTreballadors.size()) {
			treballador = llistaTreballadors.get(i);
			if(treballador.getNomICognom().equalsIgnoreCase(nomICognom)) {
				treballador = llistaTreballadors.get(i);
				i = llistaTreballadors.size();
			}
			i++;
		}
		return treballador;
	}

}
