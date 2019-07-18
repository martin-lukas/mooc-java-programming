
import java.util.Scanner;

public class Divider {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("Type a number: ");
        double a = reader.nextDouble();
        System.out.print("Type another number: ");
        double b = reader.nextDouble();
        System.out.println();
        System.out.println("Division: " + a + " / " + b + " = " + (a/b));
    }
}
