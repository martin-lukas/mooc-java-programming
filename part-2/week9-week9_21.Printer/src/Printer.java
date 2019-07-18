import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Printer {
    private String fileName;
    
    public Printer(String fileName) {
        this.fileName = fileName;
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(fileName));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (word.isEmpty()) {
                System.out.println(line);
            } else if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}
