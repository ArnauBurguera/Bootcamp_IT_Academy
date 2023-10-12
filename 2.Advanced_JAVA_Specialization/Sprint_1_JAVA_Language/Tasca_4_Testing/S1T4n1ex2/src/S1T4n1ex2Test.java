import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class S1T4n1ex2Test {
	
	 @ParameterizedTest
	 @MethodSource("getData")
	public void testDni(String esperat, int numIntroduit) {
		CalculoDNI calcul = new CalculoDNI();
		assertEquals(esperat,calcul.calcularDni(numIntroduit));
		
	}

	public static Iterable<Object[]> getData(){
	
		List<Object[]> llista = new ArrayList<Object[]>();		
		llista.add(new Object[] {"47216380W",47216380});
		llista.add(new Object[] {"46005620P",46005620});
		llista.add(new Object[] {"72055121P",72055121});
		llista.add(new Object[] {"26453678K",26453678});
		llista.add(new Object[] {"55931801X",55931801});
		llista.add(new Object[] {"32220817W",32220817});
		llista.add(new Object[] {"33463171B",33463171});
		llista.add(new Object[] {"49527158Q",49527158});
		llista.add(new Object[] {"19533254K",19533254});
		llista.add(new Object[] {"65117744Y",65117744});
		return llista;
	}

}
