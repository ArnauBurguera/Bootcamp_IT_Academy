public class Compte{
	
	private Integer numCompte;
	private Integer saldo;
	
	public Compte(Integer numCompte) {
		
		this.numCompte = numCompte;
		this.saldo = 0;
		
	}
	
	
	int getNumCompte() {
		return this.numCompte;
	}
	int getSaldo() {
		return this.saldo;
	}
	
	void setNumCompte(Integer numCompte) {
		this.numCompte = numCompte;
	}
	void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}
	
	
	public int ingresar(Integer quantitat) {
		this.saldo = this.getSaldo() + quantitat;
		return this.saldo;
	}
	
	public int retirar(Integer quantitat) {
		this.saldo = this.getSaldo() - quantitat;
		return this.saldo;
	}
	
	public String toString() {
		return this.getNumCompte() + " " + this.getSaldo() + ".";
	}
}
