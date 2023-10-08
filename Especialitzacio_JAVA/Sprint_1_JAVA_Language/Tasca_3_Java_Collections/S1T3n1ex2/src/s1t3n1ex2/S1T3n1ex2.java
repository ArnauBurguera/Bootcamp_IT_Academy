package s1t3n1ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class S1T3n1ex2 {

	public static void main(String[] args) {

		List<Integer> llista1 = new ArrayList<Integer>();

		llista1.add(1);
		llista1.add(2);
		llista1.add(4);
		llista1.add(6);
		llista1.add(2);

		List<Integer> llista2 = new ArrayList<Integer>();

		ListIterator<Integer> it = llista1.listIterator(llista1.size());
		
		while(it.hasPrevious()) {
			llista2.add(it.previous());
		}
		
		for(Integer n : llista2) {
			System.out.println(n);
		}
		
	

	}

}
