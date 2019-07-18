
import java.util.Scanner;

public class Accounts {

    public static void main(String[] args) {
        Account acc = new Account("mart", 100.0);
        acc.deposit(20.0);
        System.out.println(acc.toString());
    }

}
