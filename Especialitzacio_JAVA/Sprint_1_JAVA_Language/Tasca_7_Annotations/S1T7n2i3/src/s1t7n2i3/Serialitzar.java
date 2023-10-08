package s1t7n2i3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialitzar {
	
	private Object obj;

	public Serialitzar(Object obj) {
		this.obj = obj;
	}
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	@SerializeOnFile(directori = "C:\\Users\\Arnau\\eclipse-workspace\\S1T7n2")//Exercici 2
	public void serialitzar() {

		try {
			ObjectOutputStream escrivint_fitxer = new ObjectOutputStream(new FileOutputStream("Objecte_serialitzat.json"));
			escrivint_fitxer.writeObject(this.obj);
			escrivint_fitxer.close();
			
		}catch(Exception e) {

		}
	}

}
