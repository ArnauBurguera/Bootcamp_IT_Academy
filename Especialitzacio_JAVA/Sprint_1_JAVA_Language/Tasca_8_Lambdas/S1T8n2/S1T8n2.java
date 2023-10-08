package s1t8n2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S1T8n2 {

	public static void main(String[] args) {

		List<String> llista = new ArrayList<String>(Arrays.asList("Jaume","Judith","Maurici","Ana","Francesc","Clàdia","Monica","Pol"));
		List<String> llista2 = (Arrays.asList("Jaume","Judith Safrà","23","Maurici","Ana","Francesc Muñoz","-12","Clàdia","Monica","72","Pol"));

		//Exercici 1
		System.out.println(exercici1(llista));

		//Exercici 2
		System.out.println(exercici2(Arrays.asList(3,55,44)));

		//Exercici 3
		exercici3(5f, 17f);

		//Exercici 4
		exercici4(llista2);

	}

	//Exercici 1
	public static List<String> exercici1(List<String> llistaRebuda) {

		Stream<String> llista = llistaRebuda.stream()
				.filter(s -> s.startsWith("A"))
				.filter(s -> s.length() == 3);

		List<String> llistaARetornar = llista.collect(Collectors.toList());

		return llistaARetornar;
	}

	//Exercici 2
	public static String exercici2(List<Integer> llistaRebuda) {
		StringBuilder text = new StringBuilder();

		llistaRebuda.stream()
		.forEach(i -> {
			if(i % 2 == 0) {
				text.append("e" + i + ",");
			}else {
				text.append("o" + i + ",");
			}
		});
		return text.toString().replaceAll(",$", "");
	}

	//Exercici 3
	public static void exercici3(float a, float b) {
		Exercici3Interface suma = () -> a + b;
		Exercici3Interface resta = () -> a - b;
		Exercici3Interface multiplicacio = () -> a * b;
		Exercici3Interface divisio = () -> a / b;

		System.out.println(suma.operacio());
		System.out.println(resta.operacio());
		System.out.println(multiplicacio.operacio());
		System.out.println(divisio.operacio());
	}

	//Exercici 4
	public static void exercici4(List<String> llista) {

		llista.sort(String::compareTo);
		System.out.println("Alfabeticament: " + llista);

		llista.sort((a,b) -> {
			if(a.contains("e") && !b.contains("e")){
				return -1;
			} else if (b.contains("e") && !a.contains("e")) {
				return 1;
			}else{
				return a.compareTo(b);
			}
		});
		System.out.println("Contenen 'e'al principi: " + llista);

		Stream<String> aMostrar = llista.stream()
		.map(s -> (s.replace('a','4')))
		.map(s -> (s.replace('A','4')));
		
		System.out.println("Now a == 4: " + aMostrar.toList());
		
		Stream<String> numerics= llista.stream()
		.filter(s -> s.chars().anyMatch(Character::isDigit));
		
		System.out.println("Numerics: " + numerics.toList());

	}

}
