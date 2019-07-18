import java.util.Arrays;

public class Main {
    
    public static int smallest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }
    
    public static int indexOfTheSmallest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int smallestIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    
    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        if (array.length == 0) {
            return 0;
        }
        if (index >= array.length) {
            return 0;
        }
        int smallestIndex = index;
        for (int i = index + 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    
    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallestIndex = indexOfTheSmallestStartingFrom(array, i);
            if (smallestIndex != i) {
                swap(array, i, smallestIndex);
            }
            System.out.println(Arrays.toString(array));
        }
    }
    
    public static void main(String[] args) {
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        System.out.println(Arrays.toString(values));
        sort(values);
    }
}
