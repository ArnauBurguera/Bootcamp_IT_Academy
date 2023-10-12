package s1t4n1ex1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class S1T4n1ex1Test {
	
	private LlistaMesos any = new LlistaMesos();
	
	@BeforeEach
	public void before() {
		if(this.any.getMesosAny().isEmpty()) {
			this.any.addMesos();
		}
	}
	
	@Test
	void testMesos() {
		int mesosoEsperats = 12;
		int resultat = this.any.getMesosAny().size();
		assertEquals(mesosoEsperats,resultat);
	}
	
	@Test
	void testNula() {
		assertNotNull(this.any.getMesosAny());
	}
	
	@Test
	void testAgost() {
		/*He interpretat que l'enunciat del exercici està malament,
		 *perquè si que és cert que Agost és el 8é mes, però en una
		 *llista sempre serà la posició 7 ja que comença en 0.
		 */
		assertEquals(this.any.getMesosAny().get(7),"Agost");
	}

}
