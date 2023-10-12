import org.example.Cotxe;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class Tests {
    //Exercici 1

    //Sí sí, este test acierta (todos aciertan)
    @Test
    public void testExercici1() {
        Cotxe bmw = new Cotxe("Blau",160);
        Cotxe audi = new Cotxe("Negre",160);
        assertThat(bmw).isEqualToComparingOnlyGivenFields(audi,"potencia");
    }
    @Test//Antes comparava el color de dos cotxes, ahora el valor de dos objetos enteros. Es esto?.
    public void testExercici1_2() {
        Integer a = 2;
        Integer b = 3;
        assertThat(a).isNotEqualTo(b);
    }

    //Exercici 2

    @Test
    public void testExercici2() {
        Cotxe bmw = new Cotxe("Blau",160);
        Cotxe audi = new Cotxe("Negre",160);
        audi = bmw;
        assertThat(bmw).isEqualTo(audi);
    }
    @Test
    public void testExercici2_2() {
        Cotxe bmw = new Cotxe("Blau",160);
        Cotxe audi = new Cotxe("Negre",160);
        assertThat(bmw).isNotEqualTo(audi);
    }

    //Exercici 3
    @Test
    public void testExercici3() {
        int[] array1 = new int[]{1,3,5,7,2};
        int[] array2 = new int[]{1,3,5,7,2};
        assertThat(array1).isEqualTo(array2);
    }

    //Exercise 4
    @Test
    public void testExercici4() {
        ArrayList<Cotxe> llista = new ArrayList<Cotxe>();
        Cotxe bmw = new Cotxe("Blau",160);
        Cotxe ferrari = new Cotxe("Vermell", 350);
        Cotxe pagani = new Cotxe("Platejat", 500);
        llista.add(bmw);
        llista.add(ferrari);
        llista.add(pagani);
        assertThat(llista).containsExactlyInAnyOrder(bmw,pagani,ferrari);
    }
    @Test
    public void testExercici4_2() {
        ArrayList<Cotxe> llista = new ArrayList<Cotxe>();
        Cotxe bmw = new Cotxe("Blau",160);
        Cotxe ferrari = new Cotxe("Vermell", 350);
        Cotxe pagani = new Cotxe("Platejat", 500);
        llista.add(bmw);
        llista.add(ferrari);
        llista.add(pagani);
        assertThat(llista).containsOnlyOnce(pagani);
    }
    @Test
    public void testExercici4_3() {
        ArrayList<Cotxe> llista = new ArrayList<Cotxe>();
        Cotxe bmw = new Cotxe("Blau",160);
        Cotxe audi = new Cotxe("Negre",160);
        Cotxe ferrari = new Cotxe("Vermell", 350);
        Cotxe pagani = new Cotxe("Platejat", 500);
        llista.add(bmw);
        llista.add(ferrari);
        llista.add(pagani);
        assertThat(llista).doesNotContain(audi);
    }

    //Exercici 5

    @Test
    public void testExercici5() {
        Map<String,Integer> mapa = new HashMap<String,Integer>();
        mapa.put("bmw",200);
        mapa.put("audi",150);
        mapa.put("Bugatti",1000);
        assertThat(mapa).containsKey("Bugatti");
    }

    //Exercici 6

    @Test  //No acabo de dominar executables però els vaig tantejant
    public void testExercici6() {
        assertThatThrownBy(() -> {
            Cotxe bmw = new Cotxe("Blau",160);
            bmw.tiraExcepcio();
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    //Exercici 7

    @Test//He investigado lo que considero bastante y no encuentro ningún otro assert para testear listas vacías. Incluso ChatGPT me reitera el uso de .isEmpty()
    public void testExercici7() {
        Optional obj = Optional.empty();
        assertThat(obj).isEmpty();
    }

}
