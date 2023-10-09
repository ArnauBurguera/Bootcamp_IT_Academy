import java.util.Scanner;

public class M6Ex2_ArnauBurguera {

	public static void main(String[] args) {
		
		int numPersones = 0;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Introdueix el nombre de persones a qui vols demanar l'edat: ");
		numPersones = sc.nextInt();
		
		System.out.print(mitjanaEdat(numPersones));
	}
	
	public static String mitjanaEdat(int numPersones) {
		
		int edatIntroduida = 0;
		int edatsSumades = 0;
		int edatsGuardades = 0;
		float mitjana = 0f;
		Scanner sc = new Scanner(System.in);
		
		while(edatsGuardades < numPersones) {
			System.out.println("Introdueix edat número " + (edatsGuardades + 1) + ": ");
			edatIntroduida = sc.nextInt();
			if(edatIntroduida < 0 || edatIntroduida > 120) {
				System.out.println("La edat ha d'estar compresa entre 0 i 120 anys");	
			}else {
				edatsSumades = edatsSumades + edatIntroduida;
				edatsGuardades++;
			}
		}
		
		mitjana = (float)edatsSumades / numPersones;
		return ("La mitjana de les edats introduïdes és de " + mitjana + " anys."); 
	}
}

