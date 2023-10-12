package m4ex2_arnauburguera;

import java.util.Scanner;

public class m4ex2_arnauburguera {

	public static void main(String[] args) {
		
		//Variable declaration
		
		int edat = 0;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Quina és la teva edat? ");
		edat = sc.nextInt();
		
		/*crec que és millor un if pq amb un switch hauriem de 
		demanar al usuari que seleciones la seva edat dins uns 
		rangs d'edat preestablerts; el que em sembla un format 
		poc user-friendly. No hi ha tantes opcions*/
		if(edat <=  5) {
			System.out.print("preescolar.");
		} else if(edat >= 6 && edat <= 11) {
			System.out.print("primària.");
		} else if(edat >= 12 && edat <= 15) {
			System.out.print("ESO.");
		} else if(edat >= 16 && edat <= 17) {
				System.out.print("Batxillerat.");
		} else {
			System.out.print("FP o Universitat.");
		}
		
	}

}
