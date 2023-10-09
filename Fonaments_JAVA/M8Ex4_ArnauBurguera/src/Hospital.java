
public class Hospital extends Edifici{
	
	private int malalts;

	public Hospital(String nom, int plantes, float superficie, int malalts) {
		super(nom,plantes,superficie);
		this.malalts = malalts;
	}
	
	public int getMalalts() {
		return this.malalts;
	}
	
	public void setMalalts(int malalts) {
		this.malalts = malalts;
	}
	
	public String repartirDinar() {
		
		int racions = 0;
		
		racions = this.getMalalts() * 3;
		return "S’estan repartint " + racions + " racions";
	}
	
	public String toString() {
		return getNom() + ", " + getPlantes() + " plantes, " + getSuperficie() 
		+ " m^2 de superfície i actualment hi allotja " + this.getMalalts() + " malalts.\n";
		/*+ "El servei de neteja sumarà " + super.netejar() + "\n"
		+ "El cost de vigilància serà de " + super.calcularCostVigilancia() + "€.\n"
		+ repartirDinar();*/
	}
}
