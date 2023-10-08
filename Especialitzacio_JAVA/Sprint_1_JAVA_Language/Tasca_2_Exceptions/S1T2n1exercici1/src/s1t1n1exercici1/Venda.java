package s1t1n1exercici1;

import java.util.ArrayList;

public class Venda {
	
	private ArrayList<Producte> productes;
	private float preuTotal;
	
	public Venda(ArrayList<Producte> productes, float preuTotal) {
		this.productes = productes;
		this.preuTotal = preuTotal;
	}
	
	public ArrayList<Producte> getProductes() {
		return this.productes;
	}
	public float getPreuTotal() {
		return this.preuTotal;
	}
	
	public void setProductes(ArrayList<Producte> productes) {
		this.productes = productes;
	}
	public void setPreuTotal(float preuTotal) {
		this.preuTotal = preuTotal;
	}
	
	public void calcularTotal() throws VendaBuidaException{
		
		if(this.getProductes().size() < 1) {
			
			throw new VendaBuidaException("Per fer una venda primer has d'afegir productes.");
			
		}else {
			
			for(int i = 0; i < this.getProductes().size(); i++) {
				this.setPreuTotal(this.getPreuTotal() + this.getProductes().get(i).getPreu());
			}
		}	
	}

}
