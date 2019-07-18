
public class NumberStatistics {
    private int amountOfNumbers;
    private int sum;
    
    public NumberStatistics() {
        amountOfNumbers = 0;
        sum = 0;
    }
    
    public int sum() {
        return sum;
    }
    
    public double average() {
        if (amountOfNumbers == 0) {
            return 0;
        }
        return ((double) sum) / amountOfNumbers;
    }
    
    public void addNumber(int number) {
        amountOfNumbers++;
        sum += number;
    }
    
    public int amountOfNumbers() {
        return amountOfNumbers;
    }
}
