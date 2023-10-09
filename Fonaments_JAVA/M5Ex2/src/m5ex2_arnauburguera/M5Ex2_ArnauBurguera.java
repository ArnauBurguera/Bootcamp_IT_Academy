package m5ex2_arnauburguera;

import java.util.Scanner;

public class M5Ex2_ArnauBurguera {

	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		int resultat = 0;
		String numeros = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introdueix un nombre enter: ");
		num1 = sc.nextInt();
		System.out.print("Ara introdueix un nombre enter més gran: ");
		num2 = sc.nextInt();
		
		for(int i = num1; i <= num2; i++) {
			resultat += i;
			if(i != num2) {
				numeros += i + " + ";
			}else {
				numeros += i;
			}
		}
		
		System.out.print("Resultat = " + numeros + " = " + resultat );
	}
}
