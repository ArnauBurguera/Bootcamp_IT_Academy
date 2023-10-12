import java.util.ArrayList;
import java.util.Scanner;

public class M73Ex4_ArnauBurguera {

	public static void main(String[] args) {
		
		int num = 0;
		int residu = 0;
		char lletra = ' ';
		char lletraUsuari = ' ';
		boolean lletraCorrecta = false;
		String numStr = "";
		String dni = "";
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introdueix un DNI: ");
		dni = sc.nextLine();
		
		for(int i = 0; i < (dni.length()-1); i++) {
			numeros.add(dni.charAt(i) - '0');
			numStr = numStr + numeros.get(i);
			
		}
		
		for(int i = dni.length(); i == dni.length(); i--) {
			lletraUsuari = dni.charAt(i - 1);
		}

		num = Integer.parseInt(numStr);
		residu = num % 23;
		
		switch(residu) {
		case 0:
			lletra = 'T';
			break;
		case 1:
			lletra = 'R';
			break;
		case 2:
			lletra = 'W';
			break;
		case 3:
			lletra = 'A';
			break;
		case 4:
			lletra = 'G';
			break;
		case 5:
			lletra = 'M';
			break;
		case 6:
			lletra = 'Y';
			break;
		case 7:
			lletra = 'F';
			break;
		case 8:
			lletra = 'P';
			break;
		case 9:
			lletra = 'D';
			break;
		case 10:
			lletra = 'X';
			break;
		case 11:
			lletra = 'B';
			break;
		case 12:
			lletra = 'N';
			break;
		case 13:
			lletra = 'J';
			break;
		case 14:
			lletra = 'Z';
			break;
		case 15:
			lletra = 'S';
			break;
		case 16:
			lletra = 'Q';
			break;
		case 17:
			lletra = 'V';
			break;
		case 18:
			lletra = 'H';
			break;
		case 19:
			lletra = 'L';
			break;
		case 20:
			lletra = 'C';
			break;
		case 21:
			lletra = 'K';
			break;
		case 22:
			lletra = 'E';
			break;
		}
		
		if(lletra == lletraUsuari) {
			lletraCorrecta = true;
			System.out.print("La lletra és correcta.");
		}else {
			System.out.print("La lletra introduida no és correcta pel número introduit. "
					+ "La lletra correcta és " + lletra + ".");
		}
	}

}
