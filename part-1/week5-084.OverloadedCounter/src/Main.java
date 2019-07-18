public class Main {
    public static void main(String[] args) {
        Counter c = new Counter(2, true);
        c.decrease(4);
        System.out.println(c.value());
    }
}
