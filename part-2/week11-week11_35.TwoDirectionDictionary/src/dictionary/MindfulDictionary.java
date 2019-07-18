package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {
    private Map<String, String> words = new HashMap<String, String>();
    private String fileName;
    
    public MindfulDictionary() {
    }
    
    public MindfulDictionary(String fileName) {
        this.fileName = fileName;
    }
    
    public boolean save() {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (String finnishWord : words.keySet()) {
                writer.write(finnishWord + ":" + words.get(finnishWord) + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Couldn't save the dictionary into the file.");
            return false;
        }
    }
    
    public boolean load() {
        if (fileName == null) {
            return false;
        }
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File " + "\"" + fileName + "\" not found.");
            return false;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(":");   // the line is split at :
            add(parts[0], parts[1]);
        }
        return true;
    }
    
    public void add(String finnishWord, String englishWord) {
        if (!(words.containsKey(finnishWord) || words.containsValue(englishWord))) {
            words.put(finnishWord, englishWord);
        }
    }
    
    public String translate(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        } else if (words.containsValue(word)) {
            return getKey(word);
        } else {
            return null;
        }
        
    }
    
    public void remove(String word) {
        if (words.containsKey(word)) {
            String translation = words.get(word);
            words.remove(word, translation);
        } else if (words.containsValue(word)) {
            String finnish = getKey(word);
            words.remove(finnish, word);
        }
    }
    
    private String getKey(String value) {
        for (String finnishWord : words.keySet()) {
            if (words.get(finnishWord).equals(value)) {
                return finnishWord;
            }
        }
        return null;
    }
}
