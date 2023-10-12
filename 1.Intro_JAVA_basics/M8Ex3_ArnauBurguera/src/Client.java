import java.util.ArrayList;

public class Client {
	
	private String nom;
	private String cognom;
	private ArrayList<Compte> comptes;
	
	public Client(String nom, String apellido) {
	
	this.nom = nom;
	this.cognom = apellido;
	this.comptes = new ArrayList<Compte>();
	
	}
	
	String getNom() {
		return this.nom;
	}
	String getCognom() {
		return this.cognom;
	}
	ArrayList<Compte> getComptes() {
		return this.comptes;
	}
	
	void setNom(String nom) {
		this.nom = nom;
	}
	void setCognom(String cognom) {
		this.cognom = nom;
	}
	void setComptes(ArrayList<Compte> comptes) {//No sé si és necessari crear aquest (edita la llista de comptes sencera canviant l'Array)
		this.comptes = comptes;
	}
	
	
	public void addCompte(Compte compte) {
		this.comptes.add(compte);
	}
	
	public String toString() {
		return this.getNom() + " " + this.getCognom() 
		+ " " + this.getComptes() + ".";
	}
	
}
