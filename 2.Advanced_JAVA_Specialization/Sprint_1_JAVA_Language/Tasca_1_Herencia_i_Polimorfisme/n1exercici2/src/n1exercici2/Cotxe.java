package n1exercici2;

public class Cotxe {
	
	static final String marca = "BMW";
	static String model;
	final int potencia = 300;
	
	//Aquests dos mètodes els tinc per experimentar
	static {
		System.out.println("Class loaded");
	}
	
	{
		System.out.println("Inicialize block executed");
	}
	
	public Cotxe() {
		/*L'únic atribut que permet ser declarat al constructor és model. Però hem d'accedir a ell mitjançant
	 	la classe, ja que, al ser static, pertany a la classe Cotxe i no a una instància del objecte.
		Els altres dos no permeten ser modificats ja que en ambdós casos estem tractant amb constants*/
		Cotxe.model = "M5";	
	}
	
	

	
	/*Al ser atributs statics, "marca" i "model", no es poden accedir amb el "this.", ja que aquest fa 
	referència a la instància actual de la classe, i aquests dos atributs son camps de la classe, no del objecte*/
	public static String getMarca() {
		return marca;
	}
	public static String getModel() {
		return model;
	}
	public int getPotencia() {
		return this.potencia;
	}
	
	/*Naturalment, l'únic atribut al que li puc modificar el valor és "model", ja que és la única variable,
	i s'accedeix a aquest mitjançant la classe, ja que és static i un atribut de la classe*/
	public static void setModel(String model) {
		Cotxe.model = model;
	}


	static void metodeStatic() {
		System.out.println("metode executat");
	}
	
	static void frenar() {
		System.out.println("El vehicle està frenant");
	}
	
	void accelerar() {
		System.out.println("El vehicle està accelerant");
	}
	
}
