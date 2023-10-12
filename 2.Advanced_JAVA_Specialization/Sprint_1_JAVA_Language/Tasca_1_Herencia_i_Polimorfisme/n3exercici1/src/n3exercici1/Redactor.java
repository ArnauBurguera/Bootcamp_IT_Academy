package n3exercici1;

import java.util.ArrayList;

public class Redactor {
	
	private String nom;
	private final String dni;
	static float sou = 1500f;
	private ArrayList<Noticia> noticies = new ArrayList<Noticia>();
	
	public Redactor(String nom, String dni) {
		super();
		this.nom = nom;
		this.dni = dni;
	}

	public String getNom() {
		return this.nom;
	}
	public String getDni() {
		return this.dni;
	}
	public double getSou() {
		return this.sou;
	}
	public ArrayList<Noticia> getNoticies() {
		return this.noticies;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setSou(float sou) {
		this.sou = sou;
	}
	public void setNoticies(ArrayList<Noticia> noticies) {
		this.noticies = noticies;
	}
	
	public void addNoticia(Noticia noticia) {
		this.noticies.add(noticia);
	}
	public void removeNoticia(int posicio) {
		this.noticies.remove(posicio);
	}

}
