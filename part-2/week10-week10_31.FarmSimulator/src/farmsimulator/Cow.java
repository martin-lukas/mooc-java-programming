package farmsimulator;

import java.util.Locale;
import java.util.Random;

public class Cow implements Milkable, Alive {
    private String name;
    private double capacity;
    private double amount;
    
    private Random random = new Random();
    
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow() {
        this.name = NAMES[random.nextInt(NAMES.length)];
        this.capacity = generateCapacity();
    }
    
    public Cow(String name) {
        this.name = name;
        this.capacity = generateCapacity();
    }
    
    public int generateCapacity() {
        return random.nextInt(26) + 15;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public void liveHour() {
        double newAmount = (random.nextInt(14) + 7) / 10.0;
        if ((amount + newAmount) <= capacity) {
            this.amount += newAmount;
        } else {
            amount = capacity;
        }
    }
    
    @Override
    public double milk() {
        double amountMilked = amount;
        amount = 0;
        return amountMilked;
    }
    
    @Override
    public String toString() {
        return String.format((Locale) null, "%s %.1f/%.1f",
                name,
                (double) Math.ceil(amount),
                (double) Math.ceil(capacity));
    }
}
