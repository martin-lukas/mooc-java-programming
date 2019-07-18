package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private List<Cow> cows = new ArrayList<Cow>();
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    public void manageCows() {
        for (Cow cow : cows) {
            barn.takeCareOf(cow);
        }
    }
    
    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm owner: " + owner + "\n")
                .append("Barn bulk tank: " + barn + "\n")
                .append("Animals:\n");
        for (Cow cow : cows) {
            sb.append("        " + cow);
        }
        return sb.toString();
    }
}
