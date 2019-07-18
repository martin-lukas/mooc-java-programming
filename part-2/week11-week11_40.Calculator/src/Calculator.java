public class Calculator {
    private int value;
    
    public void plus(int plusValue) {
        value += plusValue;
    }
    
    public void minus(int minusValue) {
        value -= minusValue;
    }
    
    public void reset() {
        value = 0;
    }
    
    public int getValue() {
        return value;
    }
    
    public boolean isZero() {
        return value == 0;
    }
}
