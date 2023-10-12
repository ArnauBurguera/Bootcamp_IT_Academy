import java.util.ArrayList;

public class Treballador {
	
	int id = 0;
	String nom = "";
	String cognom = "";
	ArrayList<String> uniformitat = new ArrayList<String>();
	
	public Treballador(int id, String nom, String cognom, ArrayList<String> uniformitat) {
		this.id = id;
		this.nom = nom;
		this.cognom = cognom;
		this.uniformitat = uniformitat;
	}
	
	public int getId() {
		return this.id;
	}
	public String getNom() {
		return this.nom;
	}
	public String getCognom() {
		return this.cognom;
	}
	public ArrayList<String> getUniformitat() {
		return this.uniformitat;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public void setUniformitat(ArrayList<String> uniformitat) {
		this.uniformitat = uniformitat;
	}
	
	

}
