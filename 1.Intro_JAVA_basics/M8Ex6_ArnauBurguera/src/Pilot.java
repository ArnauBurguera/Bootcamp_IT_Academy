
public class Pilot extends Treballador{
	
	private float alcada;
	private float pes;
	
	

	public Pilot(String nom, String cognom, int edat, int antiguitat, float alcada, float pes) {
		super(nom,cognom,edat,antiguitat);
		
		super.setSou(super.getSou() + 50000 + (10000 * super.getAntiguitat()));
		this.alcada = alcada;
		this.pes = pes;
	}
	
	public float getAlcada() {
		return this.alcada;
	}
	public float getPes() {
		return this.pes;
	}

	public void setAlcada(float alcada) {
		this.alcada = alcada;
	}
	public void setPes(float pes) {
		this.pes = pes;
	}
	
	public String toString() {
		return "El pilot " + super.getNom() + " " + super.getCognom() + " te una edat de " + super.getEdat() 
			+ " anys i una antiguitat de " + super.getAntiguitat() + ". Te una alçada de " + this.getAlcada() 
			+ " i un pes de " + this.getPes() + "kg. El seu sou és de " + this.getSou() + "€.";
	}
	
	
	

}
