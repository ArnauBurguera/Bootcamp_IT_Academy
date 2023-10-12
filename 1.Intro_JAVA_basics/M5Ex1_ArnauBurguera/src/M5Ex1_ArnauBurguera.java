import java.util.ArrayList;
import java.util.Scanner;

public class M5Ex1_ArnauBurguera {

	public static void main(String[] args) {
		
		int numParaules = 0;
		String eleccio = "";
		ArrayList<String> paraules = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantes paraules vols escriure: ");
		numParaules = sc.nextInt();
		
		for(int i = 1; i <= numParaules; i++) {
			System.out.print("Introdueix la paraula: ");
			eleccio = sc.next();
			if(i == (numParaules - 1)){
				paraules.add(eleccio + " i ");
			}else if(i != numParaules) {
				paraules.add(eleccio + ", ");
			}else {
				paraules.add(eleccio + ".");
			}
		}
		
		for(String paraula : paraules) {
			System.out.print(paraula);
		}
	}

}
