
public class Hotel extends Edifici{
	
	private int habitacions;

	public Hotel(String nom, int plantes, float superficie, int habitacions) {
		super(nom,plantes,superficie);
		this.habitacions = habitacions;
	}
	
	public int getHabitacions() {
		return this.habitacions;
	}
	
	public void setHabitacions(int habitacions) {
		this.habitacions = habitacions;
	}
	
	public float calcularCostVigilancia(){
			
			float cost = 0f;
			
			cost = ((int)Math.ceil(this.getSuperficie() / 1000)) * (1300 + 500);
			return cost;	
		}
	
	public String serveiHabitacions() {
		
		int persones = 0;
		int salari = 0;
		
		persones = (int)Math.ceil(this.habitacions / 20);
		salari = persones * 1000;
		return "El servei d'habitaciosn del hotel " + super.getNom() + " constarà de " 
				+ persones + " persones i sumarà un cost total de " + salari + ".";
	}
	
	public String toString() {
		return getNom() + ", " + getPlantes() + " plantes, " + getSuperficie() + " m^2 de superfície i té " 
				+ this.getHabitacions() + " habitacions.\n";
				/*+ "El servei de neteja sumarà " + super.netejar() + "\n"
				+ "El cost de vigilància serà de " + calcularCostVigilancia() + "€.\n" 
				+ serveiHabitacions();*/
	}
}
