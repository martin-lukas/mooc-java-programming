public class LyyraCard {
    
    private double balance;
    
    public LyyraCard(double balanceAtStart) {
        balance = balanceAtStart;
    }
    
    public void payEconomical() {
        if (balance >= 2.50) {
            balance -= 2.50;
        }
    }
    
    public void payGourmet() {
        if (balance >= 4) {
            balance -= 4;
        }
    }
    
    public void loadMoney(double amount) {
        if (amount < 0) {
            return;
        }
        if (balance + amount > 150) {
            balance = 150;
        } else {
            balance += amount;
        }
    }
    
    public String toString() {
        return "The card has " + balance + " euros";
    }
}
