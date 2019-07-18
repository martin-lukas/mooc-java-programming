public class Main {
    public static void main(String[] args) {
        Box bigBox = new Box(100);
        Box smallBox = new Box(10);
        Book book1 = new Book("writer", "name", 9);
        smallBox.add(book1);
        bigBox.add(smallBox);
        System.out.println(bigBox);
    }
}