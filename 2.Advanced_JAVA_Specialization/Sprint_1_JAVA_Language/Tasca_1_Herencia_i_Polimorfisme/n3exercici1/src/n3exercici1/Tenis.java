package n3exercici1;

public class Tenis extends Noticia{
	
	private String competicio;
	private String tenistes;
	
	public Tenis(String titular, String competicio, String tenistes) {
		super(titular);
		this.competicio = competicio;
		this.tenistes = tenistes;
	}

	public String getCompeticio() {
		return this.competicio;
	}
	public String getTenistes() {
		return this.tenistes;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}
	public void setTenistes(String tenistes) {
		this.tenistes = tenistes;
	}

	@Override
	public float calcularPreuNoticia() {
		super.setPreu(150);

		if(this.getTenistes().equalsIgnoreCase("Federer") || this.getTenistes().equalsIgnoreCase("Nadal") 
				|| this.getTenistes().equalsIgnoreCase("Djokovic")) {
			super.setPreu(super.getPreu() + 100);
		}
		return super.getPreu();
	}

	@Override
	public int calcularPunts() {
		super.setPuntuacio(4);

		if(this.getTenistes().equalsIgnoreCase("Federer") || this.getTenistes().equalsIgnoreCase("Nadal") 
				|| this.getTenistes().equalsIgnoreCase("Djokovic")) {
			super.setPuntuacio(super.getPuntuacio() + 3);
		}
		return super.getPuntuacio();
	}

}
