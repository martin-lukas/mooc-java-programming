import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<Purchase> purchases;
    
    public ShoppingBasket() {
        purchases = new ArrayList<Purchase>();
    }
    
    public void add(String product, int price) {
        Purchase newPurchase = new Purchase(product, 1, price);
        if (purchases.contains(newPurchase)) {
            int index = purchases.indexOf(newPurchase);
            Purchase editedPurchase = purchases.get(index);
            editedPurchase.increaseAmount();
        } else {
            purchases.add(newPurchase);
        }
    }
    
    public int price() {
        int totalPrice = 0;
        for (Purchase p : purchases) {
            totalPrice += p.price();
        }
        return totalPrice;
    }
    
    public void print() {
        for (Purchase p : purchases) {
            System.out.println(p.getProduct() + ": " + p.getAmount());
        }
        System.out.println();
    }
}
