import java.util.Scanner;

public class Hotel {

	private String nom;
	private int habitacions;
	private int plantes;
	private float superficie;

	public Hotel(String nom, int habitacions, int plantes, float superficie) {
		this.nom = nom;
		this.habitacions = habitacions;
		this.plantes = plantes;
		this.superficie = superficie;
	}

	String getNom() {
		return this.nom;
	}

	int getHabitacions() {
		return this.habitacions;
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

	void setHabitacions(int habitacions) {
		this.habitacions = habitacions;
	}

	void setPlantes(int plantes) {
		this.plantes = plantes;
	}

	void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public String toString() {
		return this.getNom() + "; " + this.getHabitacions() + " habitacions, " + this.getPlantes() + " plantes i "
				+ this.getSuperficie() + " metres^2 de superfície.";
	}

	public String calcularManteniment() {
		int treballadors = 0;
		float costServei = 0f;

		treballadors = (int) Math.ceil((double) this.habitacions / 20);
		costServei = treballadors * 1500;
		return "L'hotel " + this.getNom() + " necessita " + treballadors + " treballadors i el cost del servei és de "
				+ costServei + "€.";
	}
}
