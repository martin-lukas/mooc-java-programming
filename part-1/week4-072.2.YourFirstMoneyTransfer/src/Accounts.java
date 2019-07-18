
public class Accounts {

    public static void main(String[] args) {
        Account acc1 = new Account("Matt's account", 1000.0);
        Account acc2 = new Account("My account", 0);
        acc1.withdrawal(100);
        acc2.deposit(100);
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
    }

}
