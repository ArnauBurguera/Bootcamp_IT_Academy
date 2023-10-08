package s1t3n1ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscriureFitxer {
	
	public void escriure(String nom, int puntuacio) {
		FileWriter arxiuPuntuacio = null;
		BufferedWriter bufferSortida = null;
		
		try {
			arxiuPuntuacio = new FileWriter("classificacio.txt", true);
			bufferSortida = new BufferedWriter(arxiuPuntuacio);
			
			bufferSortida.write(nom + " ; " + puntuacio + "/10 punts.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufferSortida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
