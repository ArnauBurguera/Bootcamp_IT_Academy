package s1t6n1ex1;

public class S1T6n1ex1 {

	public static void main(String[] args) {
		
		NoGenericMethods<String> obj1 = new NoGenericMethods<String>("Jana","Miquel","Clàudia");
		NoGenericMethods<String> obj2 = new NoGenericMethods<String>("Miquel","Jana","Clàudia");
		
		/*Com es pot observar, s'han creat dos instàncies de la classe
		NoGenericMethods i el constructor d'aquesta admet 3 objectes de tipus
		String independentment del ordre
		*/

	}

}
