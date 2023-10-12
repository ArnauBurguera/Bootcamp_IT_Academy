package s1t7n1ex1;

public class S1T7n1ex1 {

	public static void main(String[] args) {
		
		TreballadorPresencial.benzina = 40.0;
		
		Treballador trebvallador1 = new Treballador("Joan","Pera",20.70d);
		TreballadorPresencial treballadorPresencial1 = new TreballadorPresencial("Ramón","Sifont",20.70d);
		TreballadorOnline treballadorOnline1 = new TreballadorOnline("Artús","Camallarg",20.70d);
		
		System.out.println("El sou del treballador1 és de " + trebvallador1.calcularSou(160) + ".");  
		System.out.println("El sou del treballadorPresencial1 és de " + treballadorPresencial1.calcularSou(160) + ".");  
		System.out.println("El sou del treballadorOnline1 és de " + treballadorOnline1.calcularSou(160) + ".");  
		
		/* Com podem observar l'annotació @Override actua informant al programa que
		 * per cada una de les classes filles de Treballador ha de sobreescriure el mètode
		 * calcularSou(). I com cap esperar, s'obtenen resultats diferents per cada una
		 * de les instàncies.
		 */

	}

}
