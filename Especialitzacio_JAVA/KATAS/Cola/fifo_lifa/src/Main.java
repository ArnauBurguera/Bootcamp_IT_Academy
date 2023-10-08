import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {0,1,2,3};

        show(array);
        System.out.println(Arrays.toString(push(array,4)));
        System.out.println(Arrays.toString(pop(push(array,4))));
    }
    public static int[] push(int[] array, int a){

        int[] arrayToReturn = Arrays.copyOf(array,(array.length + 1));
        arrayToReturn[4] = a;
        return arrayToReturn;

    }
    public static int[] pop(int[] array){
        int[] arrayToReturn = Arrays.copyOf(array,(array.length - 1));
        return arrayToReturn;

    }
    public static void show(int[] array){
        System.out.println(Arrays.toString(array));
    }
}