import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {0,1,2,3};

        show(array);
        System.out.println(Arrays.toString(push(array,4)));
        System.out.println(Arrays.toString(pop(push(array,4))));
    }
    public static int[] push(int[] array, int a){
        int[] arrayCopied;
        int[] newArray = new int[array.length];

        arrayCopied = Arrays.copyOf(array,(array.length -1));
        newArray[0] = a;

        for(int i = 1; i < array.length; i++){
            newArray[i] = arrayCopied[i-1];
        }

        return newArray;

    }
    public static int[] pop(int[] array){
        int[] arrayCopied;
        int[] newArray = new int[array.length];

        arrayCopied = Arrays.copyOf(array,(array.length -1));
        newArray[0] = 0;

        for(int i = 1; i < array.length; i++){
            newArray[i] = arrayCopied[i-1];
        }

        return newArray;
    }
    public static void show(int[] array){
        System.out.println(Arrays.toString(array));
    }
}