package s1t8n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S1T8n1 implements ValorPi, Revertir{

	public static void main(String[] args) {

		List<String> llista = new ArrayList<String>(Arrays.asList("Jaume","Judith","Maurici","Francesc","Clàdia","Monica","Pol"));
		List<String> mesos = new ArrayList<String>(Arrays.asList("Gener","Febrer","Març","Abril","Maig","Juny","Juliol","Agost","Setembre","Octubre","Novembre","Desembre"));

		//Exercici 1
		System.out.println(contenenO(llista)); 

		//Exercici 2
		System.out.println(contenenOIMesDeCinc(llista));

		//Exercici 3
		llistaMesosAny(mesos);

		//Exercici 4
		llistaMesosMethodRef(mesos);

		//Exercici 5
		ValorPi obj = () -> 3.1415d;
		System.out.println(obj.getPiValue());

		//Exercici 6
		llistaOrdenadaTamany();

		//Exercici 7
		llistaOrdenadaReves();

		//Exrcici 8
		Revertir obj2 = (cadena) -> {
			StringBuilder builder = new StringBuilder(cadena);
			return builder.reverse().toString();
			};
		
		System.out.println(obj2.reverse("Hola, molt bon dia"));


	}

	//Exercici 1
	public static List<String> contenenO(List<String> llistaRebuda) {

		Stream<String> llista = llistaRebuda.stream()
				.filter(s -> s.contains("o"));

		List<String> llistaARetornar = llista.collect(Collectors.toList());

		return llistaARetornar;
	}

	//Exercici 2
	public static List<String> contenenOIMesDeCinc(List<String> llistaRebuda) {

		Stream<String> llista = llistaRebuda.stream()
				.filter(s -> s.length() > 5)
				.filter(s -> s.contains("o"));

		List<String> llistaARetornar = llista.collect(Collectors.toList());

		return llistaARetornar;
	}

	//Exercici 3
	public static void llistaMesosAny(List<String> mesos) {
		mesos.forEach(s -> System.out.println(s));
	}

	//Exercici 4
	public static void llistaMesosMethodRef(List<String> mesos) {
		mesos.forEach(System.out::println);
	}

	//Exercici 5
	@Override
	public double getPiValue() {
		return 0d;
	}

	//Exercici 6
	public static void llistaOrdenadaTamany() {
		List<String> list = new ArrayList<String>(Arrays.asList("sauigyhau rfughuighjh vghafjhvgjadhfgjah","14","dsfkjhadsv","asdghfaodvhaodvhoavh"));

		list.sort(Comparator.comparing(s -> (s).length()));
		list.forEach(System.out::println);
	}

	//Exercici 7
	public static void llistaOrdenadaReves() {
		List<String> list = new ArrayList<String>(Arrays.asList("sauigyhau rfughuighjh vghafjhvgjadhfgjah","14","dsfkjhadsv","asdghfaodvhaodvhoavh"));

		list.sort((s1, s2) -> (s2.length() - s1.length()));
		list.forEach(System.out::println);
	}

	//Exercici 8
	@Override
	public String reverse(String cadena) {
		return null;
	}

}
