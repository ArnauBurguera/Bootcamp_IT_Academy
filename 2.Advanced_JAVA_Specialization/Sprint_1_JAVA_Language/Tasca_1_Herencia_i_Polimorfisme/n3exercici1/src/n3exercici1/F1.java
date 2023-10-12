package n3exercici1;

public class F1 extends Noticia{
	
	private String escuderia;

	public F1(String titular, String escuderia) {
		super(titular);
		this.escuderia = escuderia;
		
	}

	public String getEscuderia() {
		return this.escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	@Override
	public float calcularPreuNoticia() {
		super.setPreu(100);

		if(this.getEscuderia().equalsIgnoreCase("Mercedes") || this.getEscuderia().equalsIgnoreCase("Ferrari")) {
			super.setPreu(super.getPreu() + 50);
		}
		return super.getPreu();
		
	}

	@Override
	public int calcularPunts() {
		super.setPuntuacio(4);

		if(this.getEscuderia().equalsIgnoreCase("Ferrari") || this.getEscuderia().equalsIgnoreCase("Mercedes")) {
			super.setPuntuacio(super.getPuntuacio() + 2);
		}
		return super.getPuntuacio();
	}

}
