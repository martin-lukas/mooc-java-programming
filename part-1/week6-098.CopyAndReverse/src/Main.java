import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = copy(a);
        b[0] = 45;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    
    public static int[] reverseCopy(int[] array) {
        int[] reversed = copy(array);
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length-i-1];
        }
        return reversed;
    }
    
    public static int[] copy(int[] array) {
        int[] copied = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copied[i] = array[i];
        }
        return copied;
    }
}
