package n1exercici1;

public class Percussio extends Instrument{

	public Percussio(String nom, float preu) {
		super(nom, preu);	
	}
	
	static{
		System.out.println("Static block: La classe Percussio s'ha inicalitzat/carregat!");
	}
	
	
	public static String metodeStatic() {
		return "Sóc un mètode estatic la mar de xulo! I carrego amb suma classe la classe Percussio.";
	}
	
	
	@Override
	public String tocar() {
		return "Està sonant un instrument de percussió";
	}
	
}
