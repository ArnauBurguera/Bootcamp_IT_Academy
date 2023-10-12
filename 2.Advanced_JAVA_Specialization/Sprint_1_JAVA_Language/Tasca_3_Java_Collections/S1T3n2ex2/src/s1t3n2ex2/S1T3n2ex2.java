package s1t3n2ex2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class S1T3n2ex2 {

	public static void main(String[] args) {
		
		Set<Restaurant> hashSet = new HashSet<Restaurant>();
		
		hashSet.add(new Restaurant("Sustable",10));
		hashSet.add(new Restaurant("Pulcinella",8));
		hashSet.add(new Restaurant("La Marghe 1889",10));
		hashSet.add(new Restaurant("Pulcinella",7));
		hashSet.add(new Restaurant("La Pulcinella",8));
		
		ComparadorRestaurants comparador = new ComparadorRestaurants();
		
		Set<Restaurant> treeSet = new TreeSet<Restaurant>(comparador);
		
		treeSet.add(new Restaurant("Sustable",10));
		treeSet.add(new Restaurant("Pulcinella",8));
		treeSet.add(new Restaurant("La Marghe 1889",10));
		treeSet.add(new Restaurant("Pulcinella",7));
		treeSet.add(new Restaurant("La Pulcinella",8));
		
		
		for(Restaurant a : treeSet) {
			System.out.println(a);
		}

	}

}