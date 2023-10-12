package s1t7n1ex2;

public class Treballador {
	
	String nom;
	String cognom;
	double preu_hora;
	
	public Treballador(String nom, String cognom, double preu_hora) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.preu_hora = preu_hora;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognom() {
		return this.cognom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public double getPreu_hora() {
		return this.preu_hora;
	}
	public void setPreu_hora(double preu_hora) {
		this.preu_hora = preu_hora;
	}
	
	public double calcularSou(int horesTreballades) {
		return horesTreballades * this.getPreu_hora();
	}
	
	

}
