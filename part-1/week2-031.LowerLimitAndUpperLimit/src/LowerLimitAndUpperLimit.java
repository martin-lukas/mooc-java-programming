
import java.util.Scanner;

public class LowerLimitAndUpperLimit {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("First: ");
        int lower = reader.nextInt();
        System.out.print("Last: ");
        int upper = reader.nextInt();
    
        for (int i = lower; i <= upper; i++) {
            System.out.println(i);
        }
    }
}
