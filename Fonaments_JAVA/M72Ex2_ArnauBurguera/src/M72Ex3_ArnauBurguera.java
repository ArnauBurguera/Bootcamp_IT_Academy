import java.util.Scanner;

public class M72Ex3_ArnauBurguera {

	public static void main(String[] args) {
		
		int num = 0;
		final String TOKEN = "*";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introdueix el nombre de repeticions: ");
		num = sc.nextInt();
		
		for(int i = 0; i < num; i++) { 
			for(int a = 0; a < i; a++) {
				System.out.print(TOKEN);
			}
			System.out.println(TOKEN);
		}
		
		for(int i = (num - 1); i > 0; i--) { 
			for(int a = 0; a < (i - 1); a++) {
				System.out.print(TOKEN);
			}
			System.out.println(TOKEN);
		}

	}

}
