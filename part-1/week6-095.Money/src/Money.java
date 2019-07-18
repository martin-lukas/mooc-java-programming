
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }
        this.euros = euros;
        this.cents = cents;
    }
    
    public Money minus(Money decremented) {
        if (this.less(decremented)) {
            return new Money(0,0);
        }
        int euros = this.euros - decremented.euros;
        int cents = this.cents - decremented.cents;
        if (cents < 0) {
            euros--;
            cents += 100;
        }
        return new Money(euros, cents);
    }
    
    public boolean less(Money compared) {
        int totalCents1 = this.euros * 100 + this.cents;
        int totalCents2 = compared.euros * 100 + compared.cents;
        return (totalCents1 < totalCents2);
    }
    
    public Money plus(Money added) {
        int newEuros = this.euros + added.euros;
        int newCents = this.cents + added.cents;
        return new Money(newEuros, newCents);
    }
    
    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }

}
