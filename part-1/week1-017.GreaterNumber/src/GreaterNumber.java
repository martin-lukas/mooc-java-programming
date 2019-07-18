import java.util.Scanner;

public class GreaterNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("Type the first number: ");
        int first = reader.nextInt();
        System.out.print("Type the second number: ");
        int second = reader.nextInt();
        System.out.println();
    
        if (first > second) {
            System.out.println("Greater number: " + first);
        } else if (first < second) {
            System.out.println("Greater number: " + second);
        } else {
            System.out.println("The numbers are equal!");
        }
    }
}
