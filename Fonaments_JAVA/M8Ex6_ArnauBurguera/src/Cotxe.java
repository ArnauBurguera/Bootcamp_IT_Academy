
public class Cotxe {
	
	private String model;
	private String color;
	private float potencia;
	private float velMax;
	private float preuMercat;
	
	public Cotxe(String model, String color, float potencia, float velMax, float preuMercat) {
		
		this.model = model;
		this.color = color;
		this.potencia = potencia;
		this.velMax = velMax;
		this.preuMercat = preuMercat;
	}
	
	public String getModel() {
		return this.model;
	}
	public String getColor() {
		return this.color;
	}
	public float getPotencia() {
		return this.potencia;
	}
	public float getVelMax() {
		return this.velMax;
	}
	public float getPreuMercat() {
		return this.preuMercat;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public void setColor(String nom) {
		this.color = color;
	}
	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}
	public void setVelMax(float velMax) {
		this.velMax = velMax;
	}
	public void setPreuMercat(float preuMercat) {
		this.preuMercat = preuMercat;
	}
	
	public String toString() {
		return "El cotxe " + this.getModel() + "blah blah.";
	}
	

}
