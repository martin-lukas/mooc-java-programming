import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> things;
    private int weightLimit;
    
    public Suitcase(int limit) {
        things = new ArrayList<Thing>();
        this.weightLimit = limit;
    }
    
    public void addThing(Thing thing) {
        if ((totalWeight() + thing.getWeight()) <= weightLimit) {
            things.add(thing);
        }
    }
    
    public void printThings() {
        for (Thing t : things) {
            System.out.println(t);
        }
    }
    
    public Thing heaviestThing() {
        if (things.size() == 0) {
            return null;
        }
        Thing heaviest = things.get(0);
        for (int i = 1; i < things.size(); i++) {
            if (things.get(i).getWeight() > heaviest.getWeight()) {
                heaviest = things.get(i);
            }
        }
        return heaviest;
    }
    
    public int totalWeight() {
        int total = 0;
        for (Thing t : things) {
            total += t.getWeight();
        }
        return total;
    }
    
    public String toString() {
        int amountOfThings = things.size();
        int totalWeight = totalWeight();
        String amountString;
        if (amountOfThings == 0) {
            amountString = "empty";
        } else if (amountOfThings == 1) {
            amountString = "1 thing";
        } else {
            amountString = "" + amountOfThings + " things";
        }
        return amountString + " (" + totalWeight + " kg)";
    }
}
