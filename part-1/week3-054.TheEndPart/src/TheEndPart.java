import java.util.Scanner;

public class TheEndPart {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("Type a word: ");
        String word = reader.nextLine();
        System.out.print("Length of the first part: ");
        int length = reader.nextInt();
        System.out.println("Result: " + word.substring(word.length()-length, word.length()));
    }
}
