
import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // Write your code here. 
    
        while (true) {
            System.out.print("Add number: ");
            double temp = reader.nextDouble();
            if (temp < -30 || temp > 40) {
                continue;
            }
            Graph.addNumber(temp);
        }
//        // Graph is used as follows:
//        Graph.addNumber(7);
//        double value = 9;
//        Graph.addNumber(value);
//        value = 3;
//        Graph.addNumber(value);
//        // Remove or comment out these lines above before trying to run the tests.
    }
}
