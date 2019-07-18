
public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;
    
    private final double ECONOMICAL_LUNCH = 2.5;
    private final double GOURMET_LUNCH = 4.0;

    public CashRegister() {
        cashInRegister = 1000;
    }

    public boolean payEconomical(LyyraCard card) {
        if (card.balance() >= ECONOMICAL_LUNCH) {
            economicalSold++;
            card.pay(ECONOMICAL_LUNCH);
            return true;
        }
        return false;
    }

    public boolean payGourmet(LyyraCard card) {
        if (card.balance() >= GOURMET_LUNCH) {
            gourmetSold++;
            card.pay(GOURMET_LUNCH);
            return true;
        }
        return false;
    }
    
    public double payEconomical(double cashGiven) {
        if (cashGiven >= ECONOMICAL_LUNCH) {
            economicalSold++;
            cashInRegister += ECONOMICAL_LUNCH;
            return cashGiven - ECONOMICAL_LUNCH;
        }
        return cashGiven;
    }
    
    public double payGourmet(double cashGiven) {
        if (cashGiven >= GOURMET_LUNCH) {
            gourmetSold++;
            cashInRegister += GOURMET_LUNCH;
            return cashGiven - GOURMET_LUNCH;
        }
        return cashGiven;
    }
    
    public void loadMoneyToCard(LyyraCard card, double sum) {
        if (sum > 0) {
            card.loadMoney(sum);
            cashInRegister += sum;
        }
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}
