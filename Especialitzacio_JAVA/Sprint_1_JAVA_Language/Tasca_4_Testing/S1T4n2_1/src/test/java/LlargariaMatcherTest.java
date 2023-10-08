import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

/*Pese a que llevo dos dias con éste ejercicio y entiendo cada paso, para mi
ha sido un salto de nivel y tengo poco consolidado lo que
sucede aquí. Me he guidao en como otros compañeros lo han hecho y ChtGPT ha
sido crucial como guía en cada paso
 */

public class LlargariaMatcherTest {

    /* Aquí creo un metodo que recibe un Matcher<Integer> y devuelve
    Matcher<String>. Éste método es el que crea el matcher customizado.
    Dentro de él instancio un FeatureMatcher y le paso los argumentos.
     */
    public static Matcher<String> llargaria(Matcher<Integer> matcher) {
        return new FeatureMatcher<String, Integer>(matcher, "llargària string",
                "llargària incorrecta") {
        /*La classe abstracta FeatureMatcher requiere una subclasse
        que implemente el metodo featurevalueOf, y para no crear una classe
        separada creamos una classe anónima dentro i sobreescrivimos el método.
        Éste metodo devuelve el largo de una palabra
         */
            @Override
            protected Integer featureValueOf(String paraula) {
                return paraula.length();
            }
        };
    }
    /*Aquí hacemos el test y pienso que el resultado parece una frase que és
    el objetivo de los matchers. Obviamente el test falla pues 'Mordor'
    tiene 6 characteres. Él mensaje de error és el correcto
     */
    @Test
    public void llargariaTest() {
        MatcherAssert.assertThat("Mordor", llargaria(is(8)));
    }
}