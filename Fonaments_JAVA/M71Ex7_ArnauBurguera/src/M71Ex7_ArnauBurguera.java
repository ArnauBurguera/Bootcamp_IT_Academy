import java.util.Scanner;

public class M71Ex7_ArnauBurguera {

	public static void main(String[] args) {
		
		int num = 0;
		String caracter = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introdueix un nombre: ");
		num = sc.nextInt();
		System.out.print("Ara introdueix un caràcter: ");
		caracter = sc.next();
		
		for(int i = 0; i < num; i++) {
			for(int a = 1; a < num; a++) {
				System.out.print(caracter);
			}
			System.out.println(caracter);
		}

	}

}
