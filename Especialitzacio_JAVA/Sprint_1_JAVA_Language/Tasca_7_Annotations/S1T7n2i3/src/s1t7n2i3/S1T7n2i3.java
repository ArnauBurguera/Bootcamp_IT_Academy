package s1t7n2i3;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class S1T7n2i3 {

	public static void main(String[] args) {
		
		Persona obj1 = new Persona("Ramón");
		Serialitzar serialitzar1 = new Serialitzar(obj1);
		
		//Exercici 3 JavaReflection
		for(Method metode : serialitzar1.getClass().getDeclaredMethods()) {
			
			if(metode.isAnnotationPresent(SerializeOnFile.class)) {
				try {
					metode.invoke(serialitzar1);
					System.out.println("Queda demostrat que s'executa la lectura de la annotació");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		//Demostració de que la serialització s'ha efectuat correctamen
		desserialitzar();

	}
	
	public static void desserialitzar() {

		try {
			ObjectInputStream recuperant_fitxer = new ObjectInputStream(new FileInputStream("Objecte_serialitzat.json"));
			Persona persona1 = (Persona) recuperant_fitxer.readObject();
			recuperant_fitxer.close();

			System.out.println(persona1.getNom());
			
		}catch(Exception e) {

		}
	}
	
	

}
