package pedrapapertisora;

import java.util.Scanner;

public class PedraPaperTisora {

	public static void main(String[] args) {
		
		// Variable declaration
		
		int numUsuari = 0;
		int numRandom = (int)(Math.random() * 3) + 1;
		String usuari = "";
		String programa = "";
		boolean errorNum = false;
		boolean usuariGuanyador = false;
		boolean empat = false;
		Scanner sc = new Scanner(System.in);
		
		//Input
		
		System.out.print("Juguem a pedra, paper o tisora:\r\n"
				+ "1. Pedra\r\n"
				+ "2. Paper\r\n"
				+ "3. Tisora\r\n"
				+ "Tria (1-3):");
		numUsuari = sc.nextInt();
		
		//Corroborar nombre correcte
		
		if(numUsuari >= 1 && numUsuari <= 3) {
			
			//Casuística
			
			switch(numUsuari) {
			case 1:
				usuari = "Pedra";
				if(numRandom == 2) {
					programa = "Paper";
				}else if(numRandom == 3) {
					programa = "Tisores";
					usuariGuanyador = true;
				}else{
					empat = true;
				}
				break;
			case 2:
				usuari = "Paper";
				if(numRandom == 3) {
					programa = "Tisores";
				}else if(numRandom == 1) {
					programa = "Pedra";
					usuariGuanyador = true;
				}else{
					empat = true;
				}
				break;
			case 3:
				usuari = "Tisores";
				if(numRandom == 1) {
					programa = "Pedra";
				}else if(numRandom == 2) {
					programa = "Paper";
					usuariGuanyador = true;
				}else{
					empat = true;
				}
				break;
			default:
				errorNum = true;
			}
			
			//Output
			
			if(usuariGuanyador) {
				System.out.print("Jo he tret " + usuari + " i tu " + programa + ". He guanyat!");
			}else if(!usuariGuanyador && !empat){
				System.out.print("Jo he tret " + usuari + " i tu " + programa + ". Has guanyat!");
			}else{
				programa = usuari;
				System.out.print("Jo he tret " + usuari + " i tu " + programa + ". Hem empatat!");
			}
			
			
		}else{
			System.out.print("Entenc que no vols jugar. Adeu.");
		}
	}

}