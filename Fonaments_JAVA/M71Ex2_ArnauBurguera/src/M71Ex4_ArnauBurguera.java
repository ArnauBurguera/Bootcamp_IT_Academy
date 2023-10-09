import java.util.Scanner;

public class M71Ex4_ArnauBurguera {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Introduieix el primer nombre: ");
		num1 = sc.nextInt();
		System.out.print("Introduieix el segon nombre: ");
		num2 = sc.nextInt();
		
		if((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
			System.out.print("Un dels dos números és negatiu.");
		}
	}
}
