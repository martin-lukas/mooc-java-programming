package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analysis {
    private File file;
    
    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int numberOfLines = 0;
        while (reader.hasNextLine()) {
            numberOfLines++;
            reader.nextLine();
        }
        return numberOfLines;
    }
    
    public int characters() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int numberOfCharacters = 0;
        while (reader.hasNextLine()) {
            numberOfCharacters += reader.nextLine().length() + 1;
        }
        return numberOfCharacters;
    }
}
