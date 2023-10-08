package s1t6n3;

public class Principal {

	public static void main(String[] args) {
		
		Generica.metode1(new Smartphone());
		Generica.metode2(new Smartphone());
		
		/*El mètode limitat per la interfície Telefon de la classe Generica no 
		 * pot cridar al mètode ferFotos() ja que ha de rebre un objecte Telefon com
		 * a parametre i el mètode fer fotos() pertany a la classe Smartphone.
		 */
	}

}