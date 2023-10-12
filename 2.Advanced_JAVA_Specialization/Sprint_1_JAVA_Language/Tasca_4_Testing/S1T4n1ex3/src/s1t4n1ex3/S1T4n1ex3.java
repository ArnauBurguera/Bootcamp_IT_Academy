package s1t4n1ex3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class S1T4n1ex3 {

	@Test
	void test() {
		int[] array = {1, 2, 3};
		
		assertThrows(ArrayIndexOutOfBoundsException.class,() -> {
			int element = array[3];
			});
	}

}
