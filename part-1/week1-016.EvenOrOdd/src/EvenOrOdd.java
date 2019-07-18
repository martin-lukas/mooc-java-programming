
import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("Type a number: ");
        int x = reader.nextInt();
    
        if (x % 2 == 0) {
            System.out.printf("Number %d is even.", x);
        } else {
            System.out.printf("Number %d is odd.", x);
        }
    }
}
