package n3exercici1;

public abstract class Noticia {
	
	private String titular;
	private String text;
	private int puntuacio;
	private float preu;
	
	public Noticia(String titular) {
		super();
		this.titular = titular;
		this.text = "";
		this.puntuacio = 0;
		this.preu = 0f;
	}
	
	
	public String getTitular() {
		return this.titular;
	}
	public String getText() {
		return this.text;
	}
	public int getPuntuacio() {
		return this.puntuacio;
	}
	public float getPreu() {
		return this.preu;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}

	
	public abstract float calcularPreuNoticia();
	
	public abstract int calcularPunts();
}
