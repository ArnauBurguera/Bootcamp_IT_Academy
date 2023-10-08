package s1t3n3;

import java.util.Comparator;

public class ComparadorCognoms implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getCognoms().compareTo(o2.getCognoms());
	}

}
