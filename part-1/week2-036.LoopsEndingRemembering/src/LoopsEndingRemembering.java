import java.util.ArrayList;
import java.util.Scanner;

public class LoopsEndingRemembering {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        ArrayList<Integer> array = new ArrayList<Integer>();
    
        System.out.println("Type numbers:");
        while (true) {
            int number = reader.nextInt();
            if (number == -1) {
                break;
            }
            array.add(number);
        }
        System.out.println("Thank you and see you later!");
    
        int sum = 0;
        for (int x : array) {
            sum += x;
        }
        System.out.println("The sum is " + sum);
        
        int count = array.size();
        System.out.println("How many numbers: " + count);
    
        System.out.println("Average: " + ((double) sum / (double) count));
        
        int evens = 0;
        int odds = 0;
        for (int x : array) {
            if (x % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        System.out.println("Even numbers: " + evens);
        System.out.println("Odd numbers: " + odds);
    }
}
