package s1t1n2;

import java.util.Scanner;

public class S1T1n2 {

	public static void main(String[] args) {
		
		
		Entrada entrada1 = new Entrada();
		
		System.out.println("BYTE: La teva edat és " + Entrada.llegirByte("BYTE:introdueix la teva edat: "));
		System.out.println("INT: La teva edat és " + Entrada.llegirInt("INT: introdueix la teva edat: "));
		System.out.println("FLOAT: La teva edat és " + Entrada.llegirFloat("FLOAT: introdueix la teva edat: "));
		System.out.println("DOUBLE: La teva edat és " + Entrada.llegirDouble("DOUBLE: introdueix la teva edat: "));
		System.out.println("CHAR: El teu caràcter és " + Entrada.llegirChar("Char: introdueix el teu cràcter: "));
		System.out.println("STRING: La teva frase és " + Entrada.llegirString("STRING: introdueix la teva frase: "));
		System.out.println("BOOLEAN: La resposta és " + Entrada.llegirSiNo("BOOLEAN: introdueix el teu cràcter: "));
		
		
	}

}
