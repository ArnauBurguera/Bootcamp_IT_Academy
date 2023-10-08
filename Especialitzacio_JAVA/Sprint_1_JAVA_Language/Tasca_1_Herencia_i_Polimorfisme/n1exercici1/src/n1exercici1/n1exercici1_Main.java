package n1exercici1;

public class n1exercici1_Main {

	public static void main(String[] args) {
		
		//Demostració amb bloc estatic que la instanciació carrega una classe Vent (l'static block només s'imprimeix un cop)
		Vent instrumentVent1 = new Vent("flauta", 20);
		
		//Demostració amb bloc estatic que l'acces a un mètode static de la classe Percussio la carrega.
		Percussio.metodeStatic();
	
	}

}
