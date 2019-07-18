import java.util.ArrayList;

public class Container {
    private int weightLimit;
    private ArrayList<Suitcase> suitcases;
    
    public Container(int limit) {
        this.weightLimit = limit;
        this.suitcases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if (totalWeight() + suitcase.totalWeight() <= weightLimit) {
            suitcases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase s : suitcases) {
            s.printThings();
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase s : suitcases) {
            totalWeight += s.totalWeight();
        }
        return totalWeight;
    }
    
    public String toString() {
        return "" + suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
