package n1exercici2;

public class Main {

	public static void main(String[] args) {
		Cotxe.metodeStatic();
		
		Cotxe obj1 = new Cotxe();
		
		System.out.println(obj1.getPotencia());
		
		Cotxe obj2 = new Cotxe();
		
		obj1.setModel("Z4");
		System.out.println(obj2.getModel());
		/*Com podem comprovar, si modifiquem el model des del obj1 i després accedeixo 
		 * al valor des del obj2, aquest ha canviat també, ja que es tracta del cmap de la 
		 * classe el que hem modificat, no un atribut del objecte*/
		
		//Cridar mètode frenar de manera estatica
		Cotxe.frenar();
		//Cridar mètode accelerar a apartir d'un objecte
		obj1.accelerar();
	}

}
