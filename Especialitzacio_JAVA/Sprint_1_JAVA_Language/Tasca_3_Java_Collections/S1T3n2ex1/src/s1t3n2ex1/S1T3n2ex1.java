package s1t3n2ex1;

import java.util.HashSet;
import java.util.Set;

public class S1T3n2ex1 {

	public static void main(String[] args) {
		
		Set<Restaurant> hashSet = new HashSet<Restaurant>();
		
		hashSet.add(new Restaurant("Sustable",10));
		hashSet.add(new Restaurant("Pulcinella",8));
		hashSet.add(new Restaurant("La Marghe 1889",10));
		//Mateix nom i diferent puntuació
		hashSet.add(new Restaurant("Pulcinella",7));
		//Nom diferent i mateixa puntuació
		hashSet.add(new Restaurant("La Pulcinella",8));
		//Mateix nom i mateixa puntuació. El que no pot ser i només en pot haver un:
		hashSet.add(new Restaurant("Pulcinella",8));
		
		System.out.println(hashSet.toString());

	}

}
