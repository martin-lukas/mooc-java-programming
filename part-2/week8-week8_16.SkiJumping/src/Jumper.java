import java.util.ArrayList;
import java.util.List;

public class Jumper implements Comparable<Jumper> {
    private String name;
    private int totalPoints;
    private List<Integer> jumps;
    
    public Jumper(String name) {
        this.name = name;
        this.jumps = new ArrayList<Integer>();
    }
    
    public void newJump(int length, int score) {
        jumps.add(length);
        totalPoints += score;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Jumper otherJumper = (Jumper) o;
        if (this.name.equals(otherJumper.name)) {
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    public void printLengths() {
        System.out.print("jump lengths: ");
        for (int i = 0; i < jumps.size(); i++) {
            System.out.print("" + jumps.get(i) + " m");
            if (i != (jumps.size() - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return name + " (" + totalPoints + " points)";
    }
    
    @Override
    public int compareTo(Jumper anotherJumper) {
        return anotherJumper.totalPoints - this.totalPoints;
    }
}
