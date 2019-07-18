import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words = new HashMap<String, String>();
    
    public String translate(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        }
        return null;
    }
    
    public void add(String word, String translation) {
        words.put(word, translation);
    }
    
    public int amountOfWords() {
        return words.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<String>();
        for (String word : words.keySet()) {
            translations.add(word + " = " + words.get(word));
        }
        return translations;
    }
}
