package s1t3n3;

public class Persona {
	
	private String nom;
	private String cognoms;
	private String dni;
	
	public Persona(String nom, String cognoms, String dni) {
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public String getCognoms() {
		return cognoms;
	}
	public String getDni() {
		return dni;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
