
public class Treballador {
	
	private String nom;
	private String cognom;
	private int edat;
	private int antiguitat;
	private float sou;
	
	public Treballador(String nom, String cognom, int edat, int antiguitat) {
		
		this.nom = nom;
		this.cognom = cognom;
		this.edat = edat;
		this.sou = 50000;
		
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getCognom() {
		return this.cognom;
	}
	public int getEdat() {
		return this.edat;
	}
	public int getAntiguitat() {
		return this.antiguitat;
	}
	public float getSou() {
		return this.sou;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public void setAntiguitat(int antiguitat) {
		this.antiguitat = antiguitat;
	}
	public void setSou(float sou) {
		this.sou = sou;
	}
	
	public String getNomICognom() {
		return this.nom + " " + this.cognom;
	}
	
	





}
