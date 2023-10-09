import java.util.Date;
import java.util.GregorianCalendar;

public class Treballador {
	
	private String nom;
	private float sou;
	private Date alta;
	
	public Treballador(String nom, float sou, int dia, int mes, int any) {
		this.nom = nom;
		this.sou = sou;
		GregorianCalendar calendari = new GregorianCalendar(any, (mes - 1), dia);
		this.alta = calendari.getTime();
	}
	
	public String getNom() {
		return this.nom;
	}
	public float getSou() {
		return this.sou;
		}
	public Date getAlta() {
		return this.alta;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setSou(float sou) {
		this.sou = sou;
	}
	public void setAlta(int dia, int mes, int any) {
		GregorianCalendar calendari = new GregorianCalendar(any, (mes - 1), dia);
		this.alta = calendari.getTime();
	}
	
	public void augment() {
		this.setSou(((this.getSou() * 5) / 100) + this.getSou());
	}
	
	//metodes propis son aquells que ja hi son a la llibreria geneal de java i son els que overrideo
	public String toString() {
		return "Sóc un treballador amb el nom de " + getNom()/*porque puedo*/ + " guanyo " + this.sou 
				+ " euros anuals i vaig entrar a treballar el " + this.alta; 
	}

}