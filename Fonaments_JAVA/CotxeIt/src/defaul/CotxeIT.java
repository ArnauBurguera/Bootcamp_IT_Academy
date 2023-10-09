
public class CotxeIT {
	
	//Atributs. Les dades base s'estableixen al constructor, per això no s'assigna aquí
	private float motor;
	private int portes;
	private String color;
	private String marca;
	private String model;
	private String energia;
	
	//Constructor (màjuscules)
	public CotxeIT(String color, float motor, int portes, String marca, 
			String model, String energia) {
		//el this es per fer la varaible local color "global"per a  la classe. Fa referencia al ambit de memoria de la calasse
		//motor és pel constructor i el this.color per la classe. Es fan el relevo (del constru a la classe). És un permís per sortir del constr
		this.color = color;
		this.motor = motor;
		this.portes = portes;
		this.marca = marca;
		this.model = model;
		this.energia = energia;
	}
	
	//Getters (et diu el valor de la variable principal en el moment actual)
	String getColor() {
		return this.color;
	}
	
	float getMotor() {
		return this.motor;	
	}
	int getPortes() {
		return this.portes;
	}
	String getMarca() {
		return this.marca;
	}
	String getModel() {
		return this.model;
	}
	String getEnergia() {
		return this.energia;
	}
	
	//Setter (per canviar el valor de la varible en qualsevol punt del codi)
	void setColor(String color) {
		this.color = color;
	}
	
	void setMotor(float motor) {
		this.motor = motor;
	}
	
	void setPortes(int portes) {
		this.portes = portes;
	}
	
	void setMarca(String marca) {
		this.marca = marca;
	}
	
	void setModel(String model) {
		this.model = model;
	}
	
	void setEnergia(String energia) {
		this.energia = energia;
	}
	
	
	//Mètodes generals (static és nomes pel main)
	public String presentarse() {
		return "Sóc un cotxe de color " + this.color + " amb un motor de " + 
	this.motor + " c.c. de  " + this.portes + " portes i de la marca " + this.marca + " i model " + 
	this.model + " i funciono amb " + this.energia + ".";
	}
	
}
