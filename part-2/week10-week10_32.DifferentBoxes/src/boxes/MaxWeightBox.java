package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private List<Thing> things = new ArrayList<Thing>();
    
    private int maxWeight;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    @Override
    public void add(Thing thing) {
        int weight = 0;
        for (Thing t : things) {
            weight += t.getWeight();
        }
        if (weight + thing.getWeight() <= maxWeight) {
            things.add(thing);
        }
    }
    
    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }
}
