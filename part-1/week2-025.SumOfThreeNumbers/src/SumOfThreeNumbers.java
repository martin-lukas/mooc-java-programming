
import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sum = 0;
        int read; // store numbers read form user in this variable
    
        System.out.print("Type the first number: ");
        sum += reader.nextInt();
        System.out.print("Type the second number: ");
        sum += reader.nextInt();
        System.out.print("Type the third number: ");
        sum += reader.nextInt();

        System.out.println("Sum: " + sum);
    }
}
