
import java.util.ArrayList;
import java.util.Scanner;

public class RecurringWord {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        ArrayList<String> words = new ArrayList<String>();
        while (true) {
            System.out.print("Type a word: ");
            String word = reader.nextLine();
            if (!word.isEmpty()) {
                if (!words.contains(word)) {
                    words.add(word);
                } else {
                    System.out.println("You gave twice the word " + word);
                    break;
                }
            }
        }
    }
}
