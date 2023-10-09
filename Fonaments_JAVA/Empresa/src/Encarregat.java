public class Encarregat extends Treballador{
	
	float plus;
	
	public Encarregat(String nom, float sou, int dia, int mes, int any, float plus) {
		super(nom,sou,dia,mes,any);
		this.plus = plus;
	}
	
	public float getPlus() {
		return this.plus;
	}
	
	public void setPlus(float plus) {
		this.plus = plus;
	}
	
	void aplicarPlus() {
		super.setSou(this.getPlus() + super.getSou());
	}
	
	public String toString() {
		return "Sóc un treballador amb el nom de " + super.getNom()/*porque puedo*/ + " guanyo " + super.getSou() 
				+ " euros anuals i vaig entrar a treballar el " + super.getAlta(); 
	}

}