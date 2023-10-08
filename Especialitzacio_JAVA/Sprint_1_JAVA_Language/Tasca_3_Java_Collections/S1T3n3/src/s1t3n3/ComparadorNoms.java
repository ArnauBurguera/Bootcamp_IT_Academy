package s1t3n3;

import java.util.Comparator;

public class ComparadorNoms implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getNom().compareTo(o2.getNom());
	}

}
