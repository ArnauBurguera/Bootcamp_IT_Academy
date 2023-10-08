package s1t1n1exercici1;

import java.util.ArrayList;

public class S1T1n1exercici1 {

	public static void main(String[] args) {
		
		Producte producte1 = new Producte("Ulleres",2.5f);
		Producte producte2 = new Producte("Sabates",19.99f);
		Producte producte3 = new Producte("Piruleta",0.75f);
		Producte producte4 = new Producte("Melmelada",3.8f);
		
		ArrayList<Producte> llista1 = new ArrayList<Producte>();
		
		Venda venda1 = new Venda(llista1,0.0f);
		
		//Per fer saltar la excepció VendaBuidaException
		try {
			venda1.calcularTotal();
		} catch(VendaBuidaException e){
			System.out.println(e.getMessage());
		}
		
		llista1.add(producte1);
		llista1.add(producte2);
		llista1.add(producte3);
		llista1.add(producte4);
		
		//Càlcul del preu total amb el mètode calcularTotal()
		try {
			venda1.calcularTotal();
			System.out.println(venda1.getPreuTotal() + "€.");
		} catch(VendaBuidaException e){
			System.out.println(e.getMessage());
		}
		
		//Codi necessari per generar i capturar excepció ArrayIndexOutOfBoundsException
		Producte[] llista2 = {};
		try {
			System.out.print(llista2[1]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("El valor accedit no pertany al Array Llista2.");
		}
		
		
		
		
	}

}
