package m4extra1;

import java.util.Scanner;

public class M4eExtra1 {

	public static void main(String[] args) {
		
		// Variable declaration
		
		int dividend = 0;
		int divisor = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input
		
		System.out.print("Introdueix un nombre enter: ");
		divisor = sc.nextInt();
		
		
		if(divisor >= 2 && divisor <= 7) {
			System.out.print("Introdueix un altre nombre enter: ");
			dividend = sc.nextInt();
			if (dividend % divisor == 0) {
				System.out.print("El dividend i el divisor son múltiples");
			}else{
				System.out.print("El dividend i el divisor no son múltiples");
			}
			
		}else{
			System.out.print("El nombre no està comprès entre 2 i 7.");
		}
	}

}
