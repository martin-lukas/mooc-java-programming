import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> debtors;
    
    public PromissoryNote() {
        debtors = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        debtors.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (debtors.containsKey(whose)) {
            return debtors.get(whose);
        }
        return 0;
    }
}

