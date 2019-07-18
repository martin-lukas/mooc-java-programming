public class Purchase {
    private String product;
    private int amount;
    private int unitPrice;
    
    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return amount * unitPrice;
    }
    
    public void increaseAmount() {
        amount++;
    }
    
    public String getProduct() {
        return product;
    }
    
    public int getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return product + ": " + amount;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        
        Purchase p = (Purchase) o;
        if (this.product.equals(p.product)) {
            if (this.unitPrice == p.unitPrice) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return product.hashCode() + unitPrice;
    }
}
