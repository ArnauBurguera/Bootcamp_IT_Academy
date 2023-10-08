
public class CalculoDNI {
	
	private char[] lletres; 

	public CalculoDNI() {
		this.lletres = new char[] {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	}

	public char[] getLletres() {
		return lletres;
	}

	public String calcularDni(int numDNI) {
		char lletra = ' ';
		int resto = 0;
		
		resto = numDNI % 23;
		lletra = this.getLletres()[resto];
		System.out.println(numDNI + String.valueOf(lletra));
		return numDNI + String.valueOf(lletra);
	}
}
