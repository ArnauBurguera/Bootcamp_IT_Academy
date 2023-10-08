package n1exercici1;

public class Vent extends Instrument{

	public Vent(String nom, float preu) {
		super(nom,preu);
		
	}
	
	static{
		System.out.println("Static block: La classe Vent s'ha inicalitzat/carregat!");
	}

	@Override
	public String tocar() {
		return "Està sonant un instrument de vent";
	}

}
