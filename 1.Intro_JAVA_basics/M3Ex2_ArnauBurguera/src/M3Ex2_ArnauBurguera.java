import java.util.Scanner;

public class M3Ex2_ArnauBurguera {

	public static void main(String[] args) {
		
		//Variables
		
		int num1 = 0;
		int num2 = 0;
		int suma = 0;
		int resta = 0;
		int multiplicacio = 0;
		float divisio = 0f;
		Scanner sc = new Scanner(System.in);
	
		//Process
		
		System.out.print("Introdueix un nombre enter: ");
		num1 = sc.nextInt();
		sc.nextLine();
		System.out.print("Introdueix un altre nombre enter: ");
		num2 = sc.nextInt();
		
		suma = num1 + num2;
		resta = num1 - num2;
		multiplicacio = num1 * num2;
		divisio = (float)num1 / num2;
		
		
		//Output
		
		System.out.println("El resultat de la suma és: " + suma + 
				"\nEl resultat de la resta és: " + resta + 
				"\nEl resultat de la multiplicació és: " + multiplicacio + 
				"\nEl resultat de la divisió és: " + divisio);

	}

}
