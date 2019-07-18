import java.util.Scanner;
import java.util.TreeMap;

public class TextUserInterface {
    private Dictionary dictionary;
    private Scanner reader;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.dictionary = dictionary;
        this.reader = reader;
    }
    
    public void start() {
        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.isEmpty()) {
                printMenu();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
            System.out.println();
        }
        System.out.println("Cheers!");
    }
    
    private void add() {
        System.out.print("In Finnish: ");
        String finnishWord = reader.nextLine();
        System.out.print("Translation: ");
        String translatedWord = reader.nextLine();
        dictionary.add(finnishWord, translatedWord);
    }
    
    private void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        String translation = dictionary.translate(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("The word is not in the dictionary.");
        }
    }
    
    private void printMenu() {
        TreeMap<String, String> commands = new TreeMap<String, String>();
        commands.put("add", "adds a word pair to the dictionary");
        commands.put("translate", "asks a word and prints its translation");
        commands.put("quit", "quits the text user interface");
        for (String command : commands.keySet()) {
            System.out.println("  " + command + " - " + commands.get(command));
        }
    }
}
