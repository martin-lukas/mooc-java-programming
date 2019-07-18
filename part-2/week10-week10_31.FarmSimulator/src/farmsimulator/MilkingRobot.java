package farmsimulator;

public class MilkingRobot {
    private BulkTank tank;
    
    public MilkingRobot() {
    }
    
    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public void milk(Milkable milkable) {
        if (tank != null) {
            double amountMilked = milkable.milk();
            tank.addToTank(amountMilked);
        } else {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }
}
