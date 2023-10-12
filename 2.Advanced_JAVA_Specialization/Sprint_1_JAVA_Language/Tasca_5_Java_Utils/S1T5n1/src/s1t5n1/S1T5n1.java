package s1t5n1;

import java.io.*;
import java.util.ArrayList;

public class S1T5n1{

	public static void main(String[] args) {
		//He fet tots els exercicis en un sol programa per simplificar

		//Exercicis 1 i 2
		FileManager tractament1 = new FileManager(new File("Carpeta Exemple"));
		tractament1.ordenarILlistar();
		tractament1.mostratLlista();

		//Exercici 3
		tractament1.guardarLlistaTXT();

		System.out.println("\n");

		//Exercici 4
		llegirTXT(new File("Llista_Fitxers.txt"));
		
		//Exercici 5
		serialitzar(tractament1);
		desserialitzar(tractament1);
	}

	public static void llegirTXT(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linea = "";

			while((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void serialitzar(FileManager obj) {

		try {
			ObjectOutputStream escrivint_fitxer = new ObjectOutputStream(new FileOutputStream("Llista_Serialitzada.ser"));
			escrivint_fitxer.writeObject(obj.getLlista());
			escrivint_fitxer.close();
		}catch(Exception e) {

		}
	}

	public static void desserialitzar(FileManager obj) {

		try {
			ObjectInputStream recuperant_fitxer = new ObjectInputStream(new FileInputStream("Llista_Serialitzada.ser"));
			ArrayList<String> llistaDesserialitzada = (ArrayList<String>) recuperant_fitxer.readObject();
			recuperant_fitxer.close();
			
			System.out.println("\nLlista desserialitzada:\n");
			
			for(String element : llistaDesserialitzada) {
				System.out.println(element);
			}
		}catch(Exception e) {

		}
	}

}
