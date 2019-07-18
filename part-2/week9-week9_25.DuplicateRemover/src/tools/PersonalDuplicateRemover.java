package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private List<String> strings;
    
    public PersonalDuplicateRemover() {
        strings = new ArrayList<String>();
    }
    
    @Override
    public void add(String characterString) {
        strings.add(characterString);
    }
    
    @Override
    public int getNumberOfDetectedDuplicates() {
        Set<String> unique = new HashSet<String>();
        int countDuplicates = 0;
        for (String s : strings) {
            if (!unique.contains(s)) {
                unique.add(s);
            } else {
                countDuplicates++;
            }
        }
        return countDuplicates;
    }
    
    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> unique = new HashSet<String>();
        for (String s : strings) {
            if (!unique.contains(s)) {
                unique.add(s);
            }
        }
        return unique;
    }
    
    @Override
    public void empty() {
        strings = new ArrayList<String>();
    }
}
