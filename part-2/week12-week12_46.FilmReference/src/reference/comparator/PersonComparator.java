package reference.comparator;

import reference.domain.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> identities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.identities = peopleIdentities;
    }
    
    @Override
    public int compare(Person p1, Person p2) {
        if (identities.containsKey(p1) && identities.containsKey(p2)) {
            return identities.get(p2) - identities.get(p1);
        }
        return 0;
    }
}
