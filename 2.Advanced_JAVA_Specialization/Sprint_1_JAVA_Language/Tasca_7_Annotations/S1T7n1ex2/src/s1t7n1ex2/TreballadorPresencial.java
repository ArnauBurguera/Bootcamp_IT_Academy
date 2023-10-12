package s1t7n1ex2;

public class TreballadorPresencial extends Treballador{
	
	static double benzina;

	public TreballadorPresencial(String nom, String cognom, double preu_hora) {
		super(nom, cognom, preu_hora);
	}
	
	public static double getBenzina() {
		return benzina;
	}

	public static void setBenzina(double benzina) {
		TreballadorPresencial.benzina = benzina;
	}

	public double calcularSou(int horesTreballadesMes) {
		return (horesTreballadesMes * this.getPreu_hora()) + benzina;
	}
	
	@Deprecated
	public String informarTreball() {
		return "Treballo presencialment.";
	}

}
