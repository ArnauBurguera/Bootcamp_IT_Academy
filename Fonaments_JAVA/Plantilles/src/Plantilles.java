import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import s1t5n1.FileManager;

public class Plantilles {

	public static void main(String[] args) {

		/*

		 1.ELS ATRIBUTS DE CLASSE SEMPRE PRIVATE--------------------------------------------------------------------------------------------------------------------------------------------------------
		 
		 

		 2.MÈTODES ADD/REMOVE EN CLASS AMB ARRAY D'OBJECTES:-------------------------------------------------------------------------------------------------------------------------------------------

		 ADD:
			public void addCotxe(Cotxe cotxe) {
			this.cotxes.add(cotxe);
			}
		REMOVE:
			public void removeCotxe(Cotxe cotxe) {
				this.cotxes.remove(cotxe);
			}
			
			

		3.BUSCADOR ARRAYLIST EN MAIN:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		public static int posicioLlistaUniformitats(String nom) {
		int i = 0, posicio = -1;

		while(i < llistaUniformitats.length) {
			if(llistaUniformitats[i].getNom().equalsIgnoreCase(nom)) {
				posicio = i;
				i = llistaUniformitats.length;
			}
			i++;
		}
		return posicio;
	}
		
		
		
		4.BUSCADOR ARRAYLIST EN CLASS:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		4.1.SI DISPOSA D'ALGO
		
		public static boolean teUniformitat(Treballador treballador, String uniformitat) {
		int i = 0;
		boolean teUniformitat = false;

		while(i < treballador.getUniforme().size()) {
			if(treballador.getUniforme().get(i).equalsIgnoreCase(uniformitat)) {
				teUniformitat = true;
				i = treballador.getUniforme().size();
			}
			i++;
		}
		return teUniformitat;
	}	
		
		4.2.ARRAYLIST EN OBJECTE
		
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
		
		
		
		
		5.MENÚ:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		public static void iniciar() {
		int opcio = -1;
		
		do {
			opcio = menu();
			switch(opcio) {
			case 0:
				System.out.print("A reveure!");
				break;
			case 1:
				mostrarButaques();
				break;
			case 2:
				mostrarButaquesPersona();
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				anularReservaPersona();
				break;
			}
		}while(opcio != 0);
		
	}

	public static int menu() {
		int opcio = -1;

		System.out.print("CINEMA:\n"
				+ "1.Mostrar totes les butaques reservades\n"
				+ "2.Mostrar les butaques reservades per una persona\n"
				+ "3.Reservar una butaca\n"
				+ "4.Anul·lar la reserva d'una butaca\n"
				+ "5.Anul·lar totes les reserves d'una persona\n"
				+ "0.Sortir\n\n"
				+ "Navegar: ");

		opcio = sc.nextInt();

		while(opcio < 0 || opcio > 5) {
			System.out.print("El nombre introduït no és correcte.\nTorna-ho a intentar: ");
			opcio = sc.nextInt();
		}
		return opcio;
	}

		
		
		6.DONAR ALTA------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
			public static void donarAlta() {
			
			int opcio = 0;
			
			System.out.println("Introdueix el nombre del edifici que vols donar d'alta del següent llistat:\n"
					+ "1.Cinema\n"
					+ "2.Hospiatl\n"
					+ "3.Hotel");
			opcio = sc.nextInt();
			crear(opcio);
		
		}
	
		7.DONAR BAIXA------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
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
		
		8.MÈTODE CREAR OBJECTE PER ENLLAÇAR AMB LO DE DALT-----------------------------------------------------------------------------------------------------------------------------------------
		
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

	9.SEGÜENT ENTER-------------------------------------------------------------------------------------------------------------------------------------
		(int)Math.ceil

		
		
		
	10.CLASS EXCEPCIÓ PROPIA------------------------------------------------------------------------------------------------------------

	public class VendaBuidaException extends Exception{

		public VendaBuidaException(String message) {
			super(message);
		}

	}
	
	11.LLISTA D?ELEMENTS----------------------------------------------------------------------------------------------
	
	public static void llistaTreballadors() {

		for(Treballador treballador : treballadors) {
			System.out.println("- " + treballador.getNom() + " " + treballador.getCognom());
		}
	}
	
	12.LLEGIR TEXT----------------------------------------------------------------------------------------------------
	
	public static void llegirTXT(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linea = "";
			
			while((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	13.ESCRIURE TEXT---------------------------------------------------------------------------------------------------
	
	public void guardarLlistaTXT() {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Llista_Fitxers.txt"));
			
			for(String element: getLlista()) {
				writer.write(element + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	14.SERIALITZAR-----------------------------------------------------------------------------------------------------------
	
	class implements serializable (el objecte que es vol serialitzar ha de pertanyer a aaquesta classe)
	
	public static void serialitzar(FileManager obj) {

		try {
			ObjectOutputStream escrivint_fitxer = new ObjectOutputStream(new FileOutputStream("Llista_Serialitzada.ser"));
			escrivint_fitxer.writeObject(obj.getLlista());
			escrivint_fitxer.close();
		}catch(Exception e) {

		}
	}
	
	15.DESSERIALITZAR----------------------------------------------------------------------------------------------------------
	
	public static void desserialitzar(FileManager obj) {

		try {
			ObjectInputStream recuperant_fitxer = new ObjectInputStream(new FileInputStream("Llista_Serialitzada.ser"));
			ArrayList<String> llistaDesserialitzada = (ArrayList<String>) recuperant_fitxer.readObject();
			recuperant_fitxer.close();
			
			System.out.println("\nLlista desserialitzada:\n");
			
			for(String element : llistaDesserialitzada) {
				System.out.println(element);
			}
		}catch(Exception e) {

		}
	}
	
	 */
		
	}

}
