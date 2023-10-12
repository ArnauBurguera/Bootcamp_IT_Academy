
public class Edifici {

	private String nom;
	private int plantes;
	private float superficie;
	
	public Edifici(String nom, int plantes, float superficie) {
		this.nom = nom;
		this.plantes = plantes;
		this.superficie = superficie;
	}
	
	String getNom() {
		return this.nom;
	}
	int getPlantes() {
		return this.plantes;
	}
	float getSuperficie() {
		return this.superficie;
	}
	
	void setNom(String nom) {
		this.nom = nom;
	}
	void setPlantes(int plantes) {
		this.plantes = plantes;
	}
	void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	
	
	public float netejar() {
		
		float sou = 0f;
		
		sou = (float) (((this.getSuperficie() / 5) + ((this.getPlantes() - 1) * 0.5)) * 30);
		return sou;
	}
	
	public float calcularCostVigilancia(){
		
		float cost = 0f;
		
		cost = ((int)Math.ceil(this.getSuperficie() / 1000)) * 1300;
		
		return cost;	
	}
	
	public String toString() {
		return getNom() + ", " + getPlantes() + " plantes i " + getSuperficie() + " m^2 de superfície.";
	}
}
