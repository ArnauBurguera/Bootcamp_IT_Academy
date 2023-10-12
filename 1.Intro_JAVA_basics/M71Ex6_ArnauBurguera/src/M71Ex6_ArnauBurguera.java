import java.util.Scanner;

public class M71Ex6_ArnauBurguera {

	public static void main(String[] args) {
		
		int num = 0;
		int resultat = 0;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Introdueix un nombre del 1 al 10: ");
		num = sc.nextInt();
		
		while(num < 0 || num > 10) {
			System.out.print("El nombre no és correcte. Introdueix un nombre del 1 al 10: ");
			num = sc.nextInt();
		}
		
		for(int i = 0; i < 11; i++) {
			resultat = num * i;
			System.out.println(num + " x " + i + " = " + resultat);
		}
		
	}

}
