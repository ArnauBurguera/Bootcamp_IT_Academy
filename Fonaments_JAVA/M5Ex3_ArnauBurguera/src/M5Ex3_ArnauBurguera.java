import java.util.Scanner;

public class M5Ex3_ArnauBurguera {

	public static void main(String[] args) {
		
		int numPc = (int)Math.ceil((Math.random() * 10)); 
		int numUsuari = 0;
		Scanner sc = new Scanner(System.in);
		
		while(numPc != numUsuari) {
			System.out.print("Introdueix un nombre del 1 al 10: ");
			numUsuari = sc.nextInt();
		}
		
		System.out.print("Enhorabona, el número era " + numPc + ".");

	}

}
