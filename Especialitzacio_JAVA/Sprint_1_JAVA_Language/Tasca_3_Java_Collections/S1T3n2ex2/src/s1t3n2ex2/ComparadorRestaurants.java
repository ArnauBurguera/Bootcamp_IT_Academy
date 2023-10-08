package s1t3n2ex2;

import java.util.Comparator;

public class ComparadorRestaurants implements Comparator<Restaurant>{

	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		String nom1 = o1.getNom();
		String nom2 = o2.getNom();
		
		if(o2.getPuntuacio() - o1.getPuntuacio() == 0) {
			return nom1.compareTo(nom2);
		}else {
			return o2.getPuntuacio() - o1.getPuntuacio();
		}
	}

}
