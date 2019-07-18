package farmsimulator;

import java.util.Collection;
import java.util.Locale;

public class Barn {
    private MilkingRobot robot;
    private BulkTank tank;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    
    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        robot = milkingRobot;
        robot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        if (robot != null) {
               robot.milk(cow);
        } else {
            throw new IllegalStateException("Robot hasnt been installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        if (robot != null) {
            for (Cow cow : cows) {
                robot.milk(cow);
            }
        } else {
            throw new IllegalStateException("Robot hasnt been installed");
        }
    }
    
    @Override
    public String toString() {
        return String.format((Locale) null, "%.1f/%.1f",
                Math.ceil(tank.getVolume()),
                Math.ceil(tank.getCapacity()));
    }
}
