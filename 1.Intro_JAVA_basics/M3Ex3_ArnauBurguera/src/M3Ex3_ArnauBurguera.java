import java.util.Scanner;

public class M3Ex3_ArnauBurguera {

	public static void main(String[] args) {
		
		//Variables
		
		int nota1 = 0;
		int nota2 = 0;
		int nota3 = 0;
		float mitja = 0f;
		final int NUMERONOTES = 3;
		Scanner sc = new Scanner(System.in);
		
		//Process
		
		System.out.print("Introdueix la primera nota: ");
		nota1 = sc.nextInt();
		System.out.print("Introdueix la segona nota: ");
		nota2 = sc.nextInt();
		System.out.print("Introdueix la tercera nota: ");
		nota3 = sc.nextInt();
		mitja = ((float)nota1 + nota2 + nota3) / NUMERONOTES;
		
		//Output
		
		System.out.print("La mitja de les tres notes és de: " + mitja + ".");
		
	}

}
