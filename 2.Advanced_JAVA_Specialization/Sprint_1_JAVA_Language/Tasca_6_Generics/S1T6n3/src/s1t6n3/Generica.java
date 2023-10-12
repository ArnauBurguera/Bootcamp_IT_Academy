package s1t6n3;

public class Generica {

	public static <T extends Telefon> void metode1(T telefon) {
		telefon.trucar();
	}

	public static <T extends Smartphone> void metode2(T smartphone) {
		smartphone.trucar();
		smartphone.ferFotos();
	}

}
