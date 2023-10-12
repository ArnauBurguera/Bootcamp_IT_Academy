package n2exercici1;

public class Telefon {
	
	private String marca;
	private String model;
	
	public Telefon(String marca, String model) {
		this.marca = marca;
		this.model = model;
	}
	
	public String getMarca() {
		return this.marca;
	}
	public String getModel() {
		return this.model;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public void trucar(String numTel) {
		System.out.println("S'està trucant al numero " + numTel + ".");
	}
	
	

}
