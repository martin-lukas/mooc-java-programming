package personnel;

public class Main {

    public static void main(String[] args) {
        Employees e = new Employees();
        e.add(new Person("Arto", Education.D));
        e.print(Education.D);
    }
}
