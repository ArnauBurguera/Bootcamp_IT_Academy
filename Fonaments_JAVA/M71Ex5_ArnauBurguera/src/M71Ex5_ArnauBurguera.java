import java.util.Scanner;

public class M71Ex5_ArnauBurguera {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 100; i >= 0; i--) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

}

