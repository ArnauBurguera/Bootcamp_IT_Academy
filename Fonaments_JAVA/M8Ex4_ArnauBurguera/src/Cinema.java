
public class Cinema extends Edifici{

	private int aforament;
	
	public Cinema(String nom, int plantes, float superficie, int aforament) {
		super(nom,plantes,superficie);
		this.aforament = aforament;
	}
	
	public int getAforament() {
		return this.aforament;
	}
	
	public void setAforament(int aforament) {
		this.aforament = aforament;
	}
	
	public float calcularCostVigilancia(){
			
		float cost = 0f;
			
		cost = ((int)Math.ceil(this.getSuperficie() / 3000)) * 1300;
		return cost;	
	}
	
	public String projectarSessio(int numAsistents, float preuEntrada) {
		
		float recaptacio = 0f;
		String text = "El nombre d'asistents és superior al aforamnet màxim del cinema " + super.getNom() + ".";
		
		if(numAsistents <= this.getAforament()) {
			recaptacio = numAsistents * preuEntrada;
			text = "S’han recaptat " + recaptacio + " euros";
		}
		return text;
	}
	
	public String toString() {
		return getNom() + ", " + getPlantes() + " plantes, " + getSuperficie() 
		+ " m^2 de superfície i un aforament de " + this.getAforament() + ".\n";
		/*+ "El servei de neteja sumarà " + super.netejar() + "\n"
		+ "El cost de vigilància serà de " + this.calcularCostVigilancia() + "€.\n";*/
	}
	
	
}
