package s1t6n1ex2;

public class GenericMethods {
	
	@SafeVarargs
	public static <T> void string(String o1, T... objectes) {
		System.out.println(o1);
		for(T o : objectes) {
			System.out.println(o);
		}
	}

	
}
