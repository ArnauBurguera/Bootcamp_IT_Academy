package s1t8n3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S1T8n3 {

	public static void main(String[] args) {
		List<Alumne> alumnes = new ArrayList<Alumne>();
		
		alumnes.add(new Alumne("Marta",14,"2n",7f));
		alumnes.add(new Alumne("Joan",15,"3r",4f));
		alumnes.add(new Alumne("Sofía",16,"4rt",8f));
		alumnes.add(new Alumne("Ermenelic",13,"1r",6f));
		alumnes.add(new Alumne("Sigfrau",14,"2n",5.7f));
		alumnes.add(new Alumne("Zacarias",14,"2n",9.1f));
		alumnes.add(new Alumne("Horaci",15,"3r",10f));
		alumnes.add(new Alumne("Filianora",14,"2n",9.8f));
		alumnes.add(new Alumne("Aratusa",16,"4rt",7.9f));
		alumnes.add(new Alumne("Clota",14,"2n",7f));
		
		//Tasca 1
		alumnes.forEach(s -> System.out.println("Nom:" + s.getNom() + " ; Edat:" + s.getEdat()));
		
		//Tasca 2
		List<Alumne> alumnesLletraA = alumnes.stream()
				.filter(s -> s.getNom().startsWith("A"))
				.collect(Collectors.toList());
		alumnesLletraA.forEach(s -> System.out.println(s.getNom()));
		
		//Tasca 3
		alumnes.stream()
			.filter(s -> s.getNota() >= 5)
			.map(s -> s.getNom())
			.forEach(System.out::println);
		
		//Tacsa 4 (canvio lo de PHP per 2n per propi lore intern i no canviar tanta cosa)
		alumnes.stream()
			.filter(s -> s.getCurs() != "2n")
			.filter(s -> s.getNota() >= 5)
			.map(s -> s.getNom())
			.forEach(System.out::println);
		
		//Tacsa 5 (Com l'exercici anterior canviaré JAVA per 3r i majors de 14
		alumnes.stream()
			.filter(s -> s.getCurs() == "3r"/*JAVA*/ && s.getEdat() >= 14/*18*/)
			.map(s -> s.getNom())
			.forEach(System.out::println);
	}

}
