package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File file;
    
    public WordInspection(File file) {
        this.file = file;
    }
    
    public List<String> getLines() {
        List<String> lines = new ArrayList<String>();
        Scanner reader = null;
        try {
            reader = new Scanner(file, "UTF-8");
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
    
    public int wordCount() {
        int count = 0;
        return getLines().size();
    }
    
    public List<String> wordsContainingZ() {
        List<String> wordsWithZ = new ArrayList<String>();
        for (String line : getLines()) {
            if (line.contains("z")) {
                wordsWithZ.add(line);
            }
        }
        return wordsWithZ;
    }
    
    public List<String> wordsEndingInL() {
        List<String> wordsWithL = new ArrayList<String>();
        for (String line : getLines()) {
            if (line.endsWith("l")) {
                wordsWithL.add(line);
            }
        }
        return wordsWithL;
    }
    
    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();
        for (String line : getLines()) {
            boolean isPalindrome = true;
            int i = 0;
            int j = line.length() - 1;
            while (i < j) {
                if (line.charAt(i) != line.charAt(j)) {
                    isPalindrome = false;
                }
                i++;
                j--;
            }
            if (isPalindrome) {
                palindromes.add(line);
            }
        }
        return palindromes;
    }
    
    public List<String> wordsWhichContainAllVowels() {
        char[] vowels = "aeiouyäö".toCharArray();
        List<String> wordsWithVowels = new ArrayList<String>();
        for (String line : getLines()) {
            boolean containsAll = true;
            for (char vowel : vowels) {
                if (!line.contains("" + vowel)) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                wordsWithVowels.add(line);
            }
        }
        return wordsWithVowels;
    }
}
