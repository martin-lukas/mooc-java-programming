
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        int[] arr = {number1, number2, number3};
        int max = number1;
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}
