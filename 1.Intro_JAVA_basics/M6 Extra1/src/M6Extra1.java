
public class M6Extra1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = {8, 12, 5, 22, 6};
		
		metode1();
		System.out.println(metode2(numeros));

	}

	public static void metode1() {
		System.out.println("sòc un mètode");
	}
	
	public static int metode2(int[] numeros) {
		int numMax = 0;
		int numPetit = 0;
		int indexPetit = 0;
		
		numMax = numeros[0];
		for(int i = 1; i < numeros.length; i++) {
			if(numMax > numeros[i]) {
				numMax = numMax;
			} else {
				numMax = numeros[i];
			}
		}
		
		System.out.println(numMax);
		
		numPetit = numeros[0];
		for(int i = 0; i < numeros.length; i++) {
			if(numPetit > numeros[i]) {
				numPetit = numeros[i];
				indexPetit = i;
				
			}
		}
		return indexPetit;
	
	}
}
