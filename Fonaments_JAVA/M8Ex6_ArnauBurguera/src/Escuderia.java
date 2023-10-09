import java.util.ArrayList;

public class Escuderia {
	
	private String nom;
	private String paisOrigen;
	private float pressupost;
	private ArrayList<Cotxe> cotxes = new ArrayList<Cotxe>();
	private ArrayList<Treballador> treballadors = new ArrayList<Treballador>();
	
	public Escuderia(String nom, String paisOrigen, float pressupost) {
		this.nom = nom;
		this.paisOrigen = paisOrigen;
		this.pressupost = pressupost;
	}
	
	public String getNom() {
		return this.nom;
	}
	public String getPaisOrogen() {
		return this.paisOrigen;
	}
	public float getPressupost() {
		return this.pressupost;
	}
	public ArrayList<Cotxe> getCotxes() {
		return this.cotxes;
	}
	public ArrayList<Treballador> getTreballadors() {
		return this.treballadors;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public void setPressupost(float pressupost) {
		this.pressupost = pressupost;
	}
	/*public void setCotxes(ArrayList<Cotxe> cotxes) {
		this.cotxes = cotxes;
	}
	public void setTreballadors(ArrayList<Treballador> treballadors) {
		this.treballadors = treballadors;
	}*/
	
	public void addCotxe(Cotxe cotxe) {
		this.cotxes.add(cotxe);
	}
	public void addTreballador(Treballador treballador) {
		this.treballadors.add(treballador);
	}
	public void removeCotxe(Cotxe cotxe) {
		this.cotxes.remove(cotxe);
	}
	public void removeTreballador(Treballador treballador) {
		this.treballadors.remove(treballador);
	}
	
	public String toString() {
		return "L'escuderia " + this.getNom() + " és de " + this.getPaisOrogen() + " i té un pressupost de " 
				+ this.getPressupost() + ".\nEls seus vòlids son: " + this.getCotxes() + ".\nEls seus treballadors: "
				+ this.getTreballadors() + ".";
	}
	
	public Cotxe buscarCotxe(String model, Escuderia escuderia) {

		int i = 0;
		Cotxe cotxe = null;

		while(i < cotxes.size()) {
			cotxe = cotxes.get(i);
			if(cotxe.getModel().equalsIgnoreCase(model)) {
				cotxe = cotxes.get(i);
				i = cotxes.size();
			}
			i++;
		}
		return cotxe;
	}

}
