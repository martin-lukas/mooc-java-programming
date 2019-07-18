package farmsimulator;

import java.util.Locale;

public class BulkTank {
    private double capacity;
    private double volume;
    
    public BulkTank() {
        this.capacity = 2000;
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        if (amount > 0) {
            if (howMuchFreeSpace() >= amount) {
                volume += amount;
            } else {
                volume = capacity;
            }
        }
    }
    
    public double getFromTank(double amount) {
        if (amount <= 0) {
            return 0;
        }
        if (volume >= amount) {
            volume -= amount;
            return amount;
        } else {
            double everything = volume;
            volume = 0;
            return everything;
        }
    }
    
    @Override
    public String toString() {
        return String.format((Locale) null, "%.1f/%.1f",
                (double) Math.ceil(volume),
                (double) Math.ceil(capacity));
    }
}
