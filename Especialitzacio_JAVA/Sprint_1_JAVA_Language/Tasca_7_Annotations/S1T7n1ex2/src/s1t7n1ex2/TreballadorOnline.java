package s1t7n1ex2;

public class TreballadorOnline extends Treballador{
	
	private final double tarifaPlanaInternet;

	public TreballadorOnline(String nom, String cognom, double preu_hora) {
		super(nom, cognom, preu_hora);
		this.tarifaPlanaInternet = 39.99d;	
	}
	
	public double getTarifaPlanaInternet() {
		return this.tarifaPlanaInternet;
	}

	public double calcularSou(int horesTreballadesMes) {
		return (horesTreballadesMes * this.getPreu_hora()) + tarifaPlanaInternet;
	}
	
	@Deprecated
	public String informarTreball() {
		return "Treballo remotament.";
	}

}
