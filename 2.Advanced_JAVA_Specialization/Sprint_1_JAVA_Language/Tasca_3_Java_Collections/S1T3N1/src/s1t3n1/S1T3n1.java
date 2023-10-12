package s1t3n1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class S1T3n1 {

	public static void main(String[] args) {

		ArrayList<Month> any = new ArrayList<Month>();
		String objecteIterat = "";

		any.add(new Month("Gener"));
		any.add(new Month("Febrer"));
		any.add(new Month("Març"));
		any.add(new Month("Abril"));
		any.add(new Month("Maig"));
		any.add(new Month("Juny"));
		any.add(new Month("Juliol"));
		any.add(new Month("Setembre"));
		any.add(new Month("Octubre"));
		any.add(new Month("Novembre"));
		any.add(new Month("Desembre"));

		ListIterator<Month> it = any.listIterator();

		while(it.hasNext()) {

			objecteIterat = it.next().getName();

			if(objecteIterat.equalsIgnoreCase("Juliol")) {
				it.add(new Month("Agost"));
			}
		}

		/*for(Month mes : any) {
			System.out.println(mes.getName());
		}*/

		HashSet<Month> hashSet = new HashSet<Month>(any);

		hashSet.add(new Month("Novembre"));

		for(Month mes : hashSet) {
			System.out.println(mes.getName());
		}
		/* Com podem veure, al sobreescriure els metodes equals() i HashCode() i dir-li quin
		 * és el paràmetre personalitzat sobre el qual volem traçar la comparació [name], la instrucció
		 * hashSet.add(new Month("Novembre")); no s'efectua (o més ben dit, el sobreescriu) perquè detecta 
		 * que ja hi ha un element amb aquest hashcode al HashSet.
		 */
		
		System.out.println("\n");
		it = any.listIterator();
		
		while(it.hasNext()) {

			objecteIterat = it.next().getName();

			System.out.println(objecteIterat);
		}

	}

}
