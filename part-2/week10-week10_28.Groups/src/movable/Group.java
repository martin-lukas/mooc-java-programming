package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> organisms = new ArrayList<Movable>();
    
    @Override
    public void move(int dx, int dy) {
        for (Movable organism : organisms) {
            organism.move(dx, dy);
        }
    }
    
    public void addToGroup(Movable movable) {
        organisms.add(movable);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable organism : organisms) {
            sb.append(organism + "\n");
        }
        return sb.toString();
    }
}
