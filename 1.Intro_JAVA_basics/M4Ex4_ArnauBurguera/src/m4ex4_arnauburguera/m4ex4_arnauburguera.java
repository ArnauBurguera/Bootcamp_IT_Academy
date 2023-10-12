package m4ex4_arnauburguera;

import java.util.Scanner;

public class m4ex4_arnauburguera {

	public static void main(String[] args) {
		
		//Variable declaration
		
		int dies = 0;
		int mes = 0;
		String mesStr = "";
		Scanner sc = new Scanner(System.in);
		
		//Data input
		
		System.out.print("Tria un mes de l'any on:"
				+ "\nGener -> 1"
				+ "\nFebrer -> 2"
				+ "\nMarç -> 3"
				+ "\nAbril -> 4"
				+ "\nMaig -> 5"
				+ "\nJuny -> 6"
				+ "\nJuliol -> 7"
				+ "\nAgost -> 8"
				+ "\nSetembre -> 9"
				+ "\nOctubre -> 10"
				+ "\nNovembre -> 11"
				+ "\nDesembre -> 12");
		
		mes = sc.nextInt();
		
		//Switch 
		
		switch(mes) {
		case 1:
			mesStr = "Gener";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 2:
			mesStr = "Febrer";
			dies = 28;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 3:
			mesStr = "Març";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 4:
			mesStr = "Abril";
			dies = 30;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 5:
			mesStr = "Maig";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 6:
			mesStr = "Juny";
			dies = 30;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 7:
			mesStr = "Juliol";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 8:
			mesStr = "Agost";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 9:
			mesStr = "Setembre";
			dies = 30;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 10:
			mesStr = "Octubre";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 11:
			mesStr = "Novembre";
			dies = 30;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		case 12:
			mesStr = "Desembre";
			dies = 31;
			System.out.println("El mes de " + mesStr + " té " + dies + " dies.");
			break;
		default:
		    System.out.println(mes + "no és un número vàlid.");
		}
		
		
	}

}
