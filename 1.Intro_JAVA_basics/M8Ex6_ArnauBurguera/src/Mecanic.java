
public class Mecanic extends Treballador{
	
	private boolean estudisSuperiors;
	
	public Mecanic(String nom, String cognom, int edat, int antiguitat, boolean estudisSuperiors) {
		super(nom,cognom,edat,antiguitat);
		
		super.setSou(super.getSou() + (10000 * super.getAntiguitat()));
		this.estudisSuperiors = estudisSuperiors;
		
	}

	public boolean getEstudisSuperiors() {
		return this.estudisSuperiors;
	}
	public void setEstudisSuperiors(boolean estudisSuperiors) {
		this.estudisSuperiors = estudisSuperiors;
	}
	
	public String toString() {
		return "El mecànic " + super.getNom() + " " + super.getCognom() + " te una edat de " + super.getEdat() 
			+ " anys i una antiguitat de " + super.getAntiguitat() + ". Te estudis superiors: " + this.getEstudisSuperiors()
					+ "El seu sou és de " + this.getSou() + "€.";
	}

}
