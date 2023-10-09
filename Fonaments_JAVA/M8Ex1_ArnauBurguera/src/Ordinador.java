
public class Ordinador {
	
	private String marca;
	private String model;
	private String processador;
	private int ram;
	private float discDur;
	
	
	public Ordinador(String marca, String model) {
		this.marca = marca;
		this.model = model;
	}
	public Ordinador(String marca, String model, String processador, int ram, float discDur) {
		this.marca = marca;
		this.model = model;
		this.processador = processador;
		this.ram = ram;
		this.discDur = discDur;
	}
	
	
	String getMarca() {
		return this.marca;
	}
	String getModel() {
		return this.model;
	}
	String getProcessador() {
		return this.processador;
	}
	int getRam() {
		return this.ram;
	}
	float getDiscDur() {
		return this.discDur;
	}
	
	/*void setMarca(String marca) {
		this.marca = marca;
	}
	void setModel(String model) {
		this.model = model;
	}*/
	void setProcessador(String processador) {
		this.processador = processador;
	}
	void setRam(int ram) {
		this.ram = ram;
	}
	void setDiscDur(float discDur) {
		this.discDur = discDur;
	}
	
	public String executant(String nomPrograma) {
		return "En aquests moments s'està executant: " + nomPrograma + ".";
	}
	
	public String toString() {
		return "La marca és " + marca + ", el model " + model + ", el processador " + 
	processador + ", la RAM de " + ram + " GB i de " + discDur + " GB de disc dur.";
	}
}
