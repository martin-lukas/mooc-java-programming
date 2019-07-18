import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stocks;
    
    public Storehouse() {
        products = new HashMap<String, Integer>();
        stocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product) {
        if (products.containsKey(product)) {
            return products.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if (stocks.containsKey(product)) {
            return stocks.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        if (stocks.containsKey(product)) {
            int stock = stocks.get(product);
            if (stock > 0) {
                stocks.put(product, --stock);
                return true;
            }
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> availableProducts = new HashSet<String>();
        for (String product : stocks.keySet()) {
            if (stocks.get(product) > 0) {
                availableProducts.add(product);
            }
        }
        return availableProducts;
    }
}
